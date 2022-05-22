package com.ehealth.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author hirwa
 */
@Entity
public class Citizen {
    @Id
    private String nationalId;
    private String names;
    private Double height;
    private Double weight;
    private String healthConditions;

    public Citizen() {
    }
    
    public Double getBmi(){
        return weight/(height*height);
    }
    
    public void calculateBmi(){
        double bmi = weight/(height*height);
        if(bmi < 18) {
            healthConditions = "Under weight";
        }else if(bmi < 25) {
            healthConditions = "Normal";        
        }else if(bmi < 30) {
            healthConditions = "Over weight";            
        }else {
            healthConditions = "Obese weight";        
        }
    }


    public Citizen(String nationalId, String names, Double height, Double weight, String healthConditions) {
        this.nationalId = nationalId;
        this.names = names;
        this.height = height;
        this.weight = weight;
        this.healthConditions = healthConditions;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getHealthConditions() {
        return healthConditions;
    }

    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
    }
    
    
}
