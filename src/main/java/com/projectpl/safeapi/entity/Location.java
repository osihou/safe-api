package com.projectpl.safeapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_table")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String city;
    private String street;
    private String num;
    private String postal_code;
    private String type;
    private double security_rat;
    private double STAFF_WEARING_MASKS;
    private double SANITIZER_AV;
    private double DIST_KEPT;
    private double other;
    private boolean IsOPEN;
    private double latitude;
    private double longitude;

    public Location(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location(
            String name,
            String city,
            String street,
            String num,
            String postal_code,
            String type,
            double security_rate,
            double STAFF_WEARING_MASKS,
            double SANITIZER_AV,
            double DIST_KEPT,
            double other,
            boolean IsOPEN,
            double latitude,
            double longitude) {


        this.name = name;
        this.city = city;
        this.street = street;
        this.num = num;
        this.postal_code = postal_code;
        this.type = type;

        this.security_rat = security_rate;
        this.STAFF_WEARING_MASKS = STAFF_WEARING_MASKS;
        this.SANITIZER_AV = SANITIZER_AV;
        this.DIST_KEPT = DIST_KEPT;
        this.other = other;

        this.IsOPEN = IsOPEN;

        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //sec rats

    public double getSecurity_rate() {
        return security_rat;
    }

    public void setSecurity_rate(double security_rate) {
        this.security_rat = security_rate;
    }

    public double getSTAFF_WEARING_MASKS() {
        return STAFF_WEARING_MASKS;
    }

    public void setSTAFF_WEARING_MASKS(double STAFF_WEARING_MASKS) {
        this.STAFF_WEARING_MASKS = STAFF_WEARING_MASKS;
    }

    public double getSANITIZER_AV() {
        return SANITIZER_AV;
    }

    public void setSANITIZER_AV(double SANITIZER_AV) {
        this.SANITIZER_AV = SANITIZER_AV;
    }



    public double getDIST_KEPT() {
        return DIST_KEPT;
    }

    public void setDIST_KEPT(double DIST_KEPT) {
        this.DIST_KEPT = DIST_KEPT;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }



    //bool for open

    public boolean isOPEN() {
        return IsOPEN;
    }

    public void setOPEN(boolean OPEN) {
        IsOPEN = OPEN;
    }



    //G&S for location

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

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                "city=" + city +
                '}';
    }


}
