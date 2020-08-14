package com.projectpl.safeapi.persistance.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations_table_test")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "user_key")
    private String user_key;


    public Location() {
    }

    public Location(
            Integer id,
            String name,
            String address,
            String user_key
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.user_key = user_key;
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

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }
}
