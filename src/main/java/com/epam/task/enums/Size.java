package com.epam.task.enums;

public enum Size {
    SMALL("Small", 1),
    MEDIUM("Medium", 2),
    LARGE("Large", 3);

    private final String description;
    private final int index;

    Size(String description, int index) {
        this.description = description;
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public int getIndex() {
        return index;
    }
}
