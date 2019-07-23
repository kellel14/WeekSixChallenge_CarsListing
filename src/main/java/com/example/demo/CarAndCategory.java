package com.example.demo;

import javax.persistence.*;

@Entity
public class CarAndCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Car vehicle;

    @ManyToOne
    private Category category;

    public CarAndCategory(){
    vehicle = new Car();
    category = new Category();
    }

    public CarAndCategory(Category category, Car vehicle){
        this.vehicle = vehicle;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getVehicle() {
        return vehicle;
    }

    public void setVehicle(Car vehicle) {
        this.vehicle = vehicle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}