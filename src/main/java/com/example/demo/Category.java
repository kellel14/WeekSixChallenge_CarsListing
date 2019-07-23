package com.example.demo;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<CarAndCategory> carCategory;

    public Category(){
        carCategory = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<CarAndCategory> getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(Set<CarAndCategory> carCategory) {
        this.carCategory = carCategory;
    }
}