package com.example.tie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wallbrackets")
public class WallBracket {

    @Id
    @GeneratedValue
    private Long id;
    private String size;
    private boolean adjustable;
    private String name;
    private double price;

    @OneToMany(mappedBy = "television")
    @JsonIgnore
    List<TelevisionWallBracket> televisionWallBrackets;
    public WallBracket() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<TelevisionWallBracket> getTelevisionWallBrackets() {
        return televisionWallBrackets;
    }

    public void setTelevisionWallBrackets(List<TelevisionWallBracket> televisionWallBrackets) {
        this.televisionWallBrackets = televisionWallBrackets;
    }

}
