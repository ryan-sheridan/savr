/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author ryan
 */
public class RSettingPersistence {
    
    public static void saveTheme(RDynamicUI.Theme theme) {
        try {
            // find our settings directory based on the platform
            String settingsDir = getSettingsDirectory();
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
            String settingsDir = getSettingsDirectory();
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

    private static String getSettingsDirectory() {
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
}
