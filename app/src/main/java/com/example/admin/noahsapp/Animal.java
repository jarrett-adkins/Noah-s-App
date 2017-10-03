package com.example.admin.noahsapp;

/**
 * Created by Admin on 10/3/2017.
 */

public class Animal {

    private String category, commonName, scientificName, conservationStatus;

    public Animal(String category, String commonName, String scientificName, String conservationStatus) {
        this.category = category;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.conservationStatus = conservationStatus;
    }

    public String getCategory() {

        return category;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getConservationStatus() {
        return conservationStatus;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "category='" + category + '\'' +
                ", commonName='" + commonName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", conservationStatus='" + conservationStatus + '\'' +
                '}';
    }
}
