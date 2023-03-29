package com.example.noobzrus.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tournaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String rules;

    private int aantalSpelers;

    @ElementCollection
    private List<String> deelnemers = new ArrayList<>();

    public Tournaments() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }


    public int getAantalSpelers() {
        return aantalSpelers;
    }

    public void setAantalSpelers(int aantalSpelers) {
        this.aantalSpelers = aantalSpelers;
    }

    public List<String> getDeelnemers() {
        return deelnemers;
    }

    public void setDeelnemers(List<String> deelnemers) {
        this.deelnemers = deelnemers;
    }
}
