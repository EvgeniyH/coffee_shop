package com.epam.task.beans;

public class Juice extends Position {
    public Juice(int index, String name, String description, Double price) {
        super(index, name, description, price);
    }

    public Juice(Position position) {
        super(position);
    }
}
