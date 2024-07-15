package com.epam.task.beans;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private String username = "";
    private HashMap<Integer, List<Position>> orders = new HashMap<>();
    private final AtomicInteger numberOfBeverageOrdered = new AtomicInteger(0);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<Integer, List<Position>> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Integer, List<Position>> orders) {
        this.orders = orders;
    }

    public int getNumberOfBeverageOrdered() {
        return numberOfBeverageOrdered.get();
    }

    public void increaseNumber() {
        numberOfBeverageOrdered.getAndIncrement();
    }

    public void decreaseNumber() {
        if (numberOfBeverageOrdered.get() >= 5)
            numberOfBeverageOrdered.set(numberOfBeverageOrdered.get() - 5);
    }
}
