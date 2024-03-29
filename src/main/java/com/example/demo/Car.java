package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String carName;
    private String carModel;
    private String carManufacturer;
    private int carYear;
    private float carMSRP;



    @OneToMany(mappedBy = "vehicle")
    private Set<CarAndCategory> carCategory;

    public Car(){
        carCategory = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Set<CarAndCategory> getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(Set<CarAndCategory> carCategory) {
        this.carCategory = carCategory;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public float getCarMSRP() {
        return carMSRP;
    }

    public void setCarMSRP(float carMSRP) {
        this.carMSRP = carMSRP;
    }
}