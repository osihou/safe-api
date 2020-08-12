package com.projectpl.safeapi.persistance.entity;

import javax.persistence.*;

@Entity
@Table(name = "opinions_table2")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_score;

    private double cleanliness;
    private double service;
    private double improvements;
    private double equipment;
    private double consumables;

    private Integer id_location;

    public Opinion() {
    }

    public Opinion(Integer id_score,
                   double cleanliness,
                   double service,
                   double improvements,
                   double equipment,
                   double consumables,
                   Integer id_location
    ) {
        this.id_score = id_score;
        this.cleanliness = cleanliness;
        this.service = service;
        this.improvements = improvements;
        this.equipment = equipment;
        this.consumables = consumables;
        this.id_location = id_location;
    }

    public Integer getId_score() {
        return id_score;
    }

    public void setId_score(Integer id_score) {
        this.id_score = id_score;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getImprovements() {
        return improvements;
    }

    public void setImprovements(double improvements) {
        this.improvements = improvements;
    }

    public double getEquipment() {
        return equipment;
    }

    public void setEquipment(double equipment) {
        this.equipment = equipment;
    }

    public double getConsumables() {
        return consumables;
    }

    public void setConsumables(double consumables) {
        this.consumables = consumables;
    }

    public Integer getId_location() {
        return id_location;
    }

    public void setId_location(Integer id_location) {
        this.id_location = id_location;
    }
}
