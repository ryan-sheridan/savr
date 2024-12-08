/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package savr.ryan;

import java.io.Serializable;

/**
 *
 * @author ryan
 */
public class Location implements Serializable {
    private double latitude;
    private double longitude;
    private String address;
    private Integer id;
    private String country;
    
    public Location(Integer id, double latitude, double longitude, String country) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }
    
    public Location(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Location(String address, String country) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setAddressFromCoordinates() {
        return;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
