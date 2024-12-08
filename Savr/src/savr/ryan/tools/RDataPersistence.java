/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import savr.ryan.RedistributionRecord;
import savr.ryan.WasteSource;

/**
 *
 * @author ryan
 */
public class RDataPersistence {
    
    private static RDataPersistence instance;
    private Connection connection;
    private String url;
    
    private RDataPersistence() {
        try {
            // determine database path
            String dataDirectory = getDataDirectory();
            File dataDirFile = new File(dataDirectory);

            // if we cannot find or create
            if (!dataDirFile.exists() && !dataDirFile.mkdirs()) {
                throw new RuntimeException("failed to create dir: " + dataDirectory);
            }

            // file path for db
            String dbFilePath = dataDirectory + File.separator + "zero_hunger.db";

            // check if db file exists
            File dbFile = new File(dbFilePath);
            if (!dbFile.exists()) {
                // copy resource to dbFilePath
                try (InputStream inputStream = RDataPersistence.class.getResourceAsStream("/resources/zero_hunger.db")) {
                    if (inputStream == null) {
                        throw new IOException("zero_hunger.db not found in resources");
                    }
                    Files.copy(inputStream, dbFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("db copied to: " + dbFilePath);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("failed to copy db", e);
                }
            }

            // build db url
            url = "jdbc:sqlite:" + dbFilePath;

            // create new connection, there should only ever be one
            connection = DriverManager.getConnection(url);
            
            System.out.println("db connection established at " + dbFilePath);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("failed to create connection", e);
        }
    }
    
    public static synchronized RDataPersistence getInstance() {
        if (instance == null) {
            instance = new RDataPersistence();
        }
        return instance;
    }
    
    public static void saveTheme(RDynamicUI.Theme theme) {
        try {
            // find our settings directory based on the platform
            String settingsDir = getDataDirectory();
            File settingsFolder = new File(settingsDir);
            
            // if the folder already exists, create it, if all fails, throw an error
            if(!settingsFolder.exists() && !settingsFolder.mkdirs()) {
                throw new IOException("failed to create directory" + settingsFolder.getAbsolutePath());
            }
            
            // we need an xml file for our xml ye know wat i mean
            File xml = new File(settingsFolder, "settings.xml");
            
            // cool api
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            
            // all xml must have a root element, we can work from here
            Element root = doc.createElement("settings");
            doc.appendChild(root);
            
            // within the root element, we need a mode element
            Element modeElement = doc.createElement("mode");
            modeElement.setTextContent(theme == RDynamicUI.Theme.DARK ? "dark" : "light");
            root.appendChild(modeElement);
            
            // write dom
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(xml));

            // was told to do this
            transformer.transform(source, result);

            // settings saved
            System.out.println("Settings saved to: " + xml.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static RDynamicUI.Theme getTheme() {
        try {
            // grab settings directory and file
            String settingsDir = getDataDirectory();
            File settingsFile = new File(settingsDir, "settings.xml");

            // if the file doesnt exist return the mode as DARK
            if (!settingsFile.exists()) {
                return RDynamicUI.Theme.DARK;
            }

            // parse xml
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(settingsFile);

            // get root element
            // shoutout to webdev class
            Element root = document.getDocumentElement();

            // get value
            String mode = root.getElementsByTagName("mode").item(0).getTextContent();
            
            if ("dark".equalsIgnoreCase(mode)) {
                return RDynamicUI.Theme.DARK;
            } else {
                return RDynamicUI.Theme.LIGHT;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Default to LIGHT if there's an error
            return RDynamicUI.Theme.LIGHT;
        }
    }

    public static String getDataDirectory() {
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        
        if(os.contains("mac")) {
            // the macos standard for storing application data is
            // ~/Library/Application Support/AppName
            
            // File.separator so things dont break, windows is \ and macos is /
            // i dont like \
            return userHome + File.separator + "Library" + File.separator + "Application Support" + File.separator + "Savr";
        } else if (os.contains("win")) {
            String appData = System.getenv("APPDATA");
            return appData + File.separator + "Savr";
        } else if (os.contains("freebsd") || os.contains("nix") || os.contains("nux")){
            // shoutout to freebsd and linux
            return userHome + File.separator + ".config" + File.separator + "Savr";
        } else {
            return userHome + File.separator + ".config" + File.separator + "Savr";
        }
    }
    
    public static void exportObject(Object data, String filename, String directory) {
        String fileLocation = directory + File.separator + filename;
        
        try (FileOutputStream fileOut = new FileOutputStream(fileLocation);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(data);
            System.out.println("Object serialized and saved to " + fileLocation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void exportObject(Object data, String filename) {
        String directory = getDataDirectory();
        
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        exportObject(data, filename, directory);
    }
    
    public static HashMap<Integer, WasteSource> importObject(String filename, String directory) {
        String fileLocation = directory + File.separator + filename;
        HashMap<Integer, WasteSource> result = null;

        try (FileInputStream fileIn = new FileInputStream(fileLocation);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Object obj = in.readObject();
            if (obj instanceof HashMap) {
                result = (HashMap<Integer, WasteSource>) obj;
                System.out.println("object deserialised from " + fileLocation);
            } else {
                System.err.println("deserialised object is not a HashMap<Integer, WasteSource>.");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static HashMap<Integer, WasteSource> importObject(String filename) {
        String directory = getDataDirectory();
        return importObject(filename, directory);
    }

    public Connection getConnection() {
        return this.connection;
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("db connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static ArrayList<RedistributionRecord> getSavedRedistributionRecords() {
        return RDatabaseORM.getRedistributionRecords();
    }
}
