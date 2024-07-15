package com.epam.task.beans;

import com.epam.task.enums.Extra;
import com.epam.task.enums.Size;

import java.util.List;

public class Coffee extends Position {

    public Coffee(int index, String name, String description, Double price, Size size, List<Extra> extras) {
        super(index, name, description, price, extras);
        this.size = size;
        this.extras = extras;
    }

    public Coffee(Position position) {
        super(position);
        Coffee coffee = (Coffee) position;
        this.size = coffee.getSize();
        this.extras = coffee.getExtras();
    }

    private final Size size;
    private final List<Extra> extras;

    public Size getSize() {
        return size;
    }
}
