package com.projectpl.safeapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "opinions_table")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_score;

    private String device_id;
    private double sec_rat;
    private double staff_wearing_masks;
    private double sanitizer_av;
    private double dist_kept;
    private double other;

    private Integer id_location;

    private String opinion;

    public Opinion(){

    }

    public Opinion(
            Integer id_score,
            String device_id,

            double sec_rat,
            double staff_wearing_masks,
            double sanitizer_av,
            double dist_kept,
            double other,

            Integer id_location,

            String opinion) {

        this.id_score = id_score;
        this.device_id = device_id;

        this.sec_rat = sec_rat;
        this.staff_wearing_masks = staff_wearing_masks;
        this.sanitizer_av = sanitizer_av;
        this.dist_kept = dist_kept;
        this.other = other;

        this.id_location = id_location;

        this.opinion = opinion;
    }

    //ID_SCORE
    public Integer getId_score() {
        return id_score;
    }
    public void setId_score(Integer id_score) {
        this.id_score = id_score;
    }

    //DEVICE_ID
    public String getDevice_id() {
        return device_id;
    }
    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    //SEC_RAT
    public double getSec_rat() {
        return sec_rat;
    }
    public void setSec_rat(double sec_rat) {
        this.sec_rat = sec_rat;
    }

    //STAFF_WEARING_MASKS
    public double getStaff_wearing_masks() {
        return staff_wearing_masks;
    }
    public void setStaff_wearing_masks(double staff_wearing_masks) {
        this.staff_wearing_masks = staff_wearing_masks;
    }

    //SANITIZER_AV
    public double getSanitizer_av() {
        return sanitizer_av;
    }
    public void setSanitizer_av(double sanitizer_av) {
        this.sanitizer_av = sanitizer_av;
    }

    //DIST_KEPT
    public double getDist_kept() {
        return dist_kept;
    }
    public void setDist_kept(double dist_kept) {
        this.dist_kept = dist_kept;
    }

    //OTHER
    public double getOther() {
        return other;
    }
    public void setOther(double other) {
        this.other = other;
    }

    //ID_LOCATION
    public Integer getId_location() {
        return id_location;
    }
    public void setId_location(Integer id_location) {
        this.id_location = id_location;
    }

    //OPINION
    public String getOpinion() {
        return opinion;
    }
    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
