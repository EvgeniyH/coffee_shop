package com.epam.task.enums;

public enum Item {
    COFFEE("Coffee", 0),
    ROLL("Bacon Roll", 4),
    ORANGE_JUICE("Freshly squeezed orange juice (0.25l)", 5);

    private final String description;
    private final int index;

    Item(String description, int index) {
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
