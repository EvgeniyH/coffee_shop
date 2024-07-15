package com.epam.task.enums;

import java.util.Arrays;

public enum Extra {
    EXTRA_MILK("Extra milk", 6),
    FOAMED_MILK("Foamed milk", 7),
    ROAST_COFFEE("Special roast coffee", 8);

    private final String description;
    private final int index;
    private boolean free = false;

    Extra(String description, int index) {
        this.description = description;
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public int getIndex() {
        return index;
    }

    public static Extra getExtra(int index) {
        return Arrays.stream(Extra.values()).filter(extra -> extra.getIndex() == index).findFirst().orElse(null);
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "description='" + description + '\'' +
                ", index=" + index +
                '}';
    }
}
