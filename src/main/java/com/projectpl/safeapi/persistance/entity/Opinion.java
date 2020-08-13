package com.projectpl.safeapi.persistance.entity;

import javax.persistence.*;

@Entity
@Table(name = "opinions_table3")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_score;

    private int score;
    private int cleanliness;
    private int service;
    private int improvements;
    private int equipment;
    private int consumables;
    private int endorsement;

    private int locationKey;

    public Opinion() {
    }

    public Opinion(
            Integer id_score,
            int score,
            int cleanliness,
            int service,
            int improvements,
            int equipment,
            int consumables,
            int endorsement,
            int locationKey
    ) {
        this.id_score = id_score;
        this.score = score;
        this.cleanliness = cleanliness;
        this.service = service;
        this.improvements = improvements;
        this.equipment = equipment;
        this.consumables = consumables;
        this.endorsement = endorsement;
        this.locationKey = locationKey;
    }

    public Integer getId_score() {
        return id_score;
    }

    public void setId_score(Integer id_score) {
        this.id_score = id_score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getImprovements() {
        return improvements;
    }

    public void setImprovements(int improvements) {
        this.improvements = improvements;
    }

    public int getEquipment() {
        return equipment;
    }

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

    public int getConsumables() {
        return consumables;
    }

    public void setConsumables(int consumables) {
        this.consumables = consumables;
    }

    public int getEndorsement() {
        return endorsement;
    }

    public void setEndorsement(int endorsement) {
        this.endorsement = endorsement;
    }

    public int getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(int locationKey) {
        this.locationKey = locationKey;
    }
}
