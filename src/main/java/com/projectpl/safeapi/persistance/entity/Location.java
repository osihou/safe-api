package com.projectpl.safeapi.persistance.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations_table2")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Integer user_key;

    public Location() {
    }

    public Location(
            Integer id,
            String name,
            String address,
            Integer user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.user_key = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUser_key() {
        return user_key;
    }

    public void setUser_key(Integer user_key) {
        this.user_key = user_key;
    }
}
