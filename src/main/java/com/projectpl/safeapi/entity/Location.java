package com.projectpl.safeapi.entity;




import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "locations_table")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String street;
    private String city;
    private String country;
    private String number;
    private String postal_code;
    private String type;

    private String is_open;

    private double latitude;
    private double longitude;

    public Location(){

    }


    public Location(
            String name,
            String street,
            String city,
            String country,
            String number,
            String postal_code,
            String type,

            String is_open,

            double latitude,
            double longitude) {


        this.name = name;
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.postal_code = postal_code;
        this.type = type;

        this.is_open = is_open;

        this.latitude = latitude;
        this.longitude = longitude;
    }
    //ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //NAME
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //STREET
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    //CITY
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    //COUNTRY
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    //NUMBER
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    //POSTAL_CODE
    public String getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    //TYPE
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //IS_OPEN
    public String getIs_open() {
        return is_open;
    }
    public void setIs_open(String is_open) {
        this.is_open = is_open;
    }

    //LATITUDE
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    //LONGITUDE
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }



}
