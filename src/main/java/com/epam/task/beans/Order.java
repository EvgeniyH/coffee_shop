package com.epam.task.beans;

import java.util.List;

public class Order {

    public Order(List<Position> positions, double totalPrice) {
        this.positions = positions;
        this.totalPrice = totalPrice;
    }

    private final List<Position> positions;
    private final double totalPrice;

    public List<Position> getPositions() {
        return positions;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "positions=" + positions +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
