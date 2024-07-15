package com.epam.task.beans;

import com.epam.task.enums.Extra;

import java.util.List;

public class Position {

    public Position(int index, String name, String description, Double price, List<Extra> extras) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.price = price;
        this.extras = extras;
    }

    public Position(int index, String name, String description, Double price) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Position(Position position) {
        this(position.getIndex(), position.getName(), position.getDescription(), position.getPrice(), List.of());
    }

    private int index;
    private String name;
    private String description;
    private Double price;
    private List<Extra> extras;

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Position{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price + " CHF " +
                '}';
    }
}
