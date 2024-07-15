package com.epam.task.utils;

import com.epam.task.beans.Coffee;
import com.epam.task.beans.Juice;
import com.epam.task.beans.Position;
import com.epam.task.beans.Roll;
import com.epam.task.enums.Extra;

import java.util.List;

import static com.epam.task.enums.Item.*;
import static com.epam.task.enums.Size.*;

public class Utils {

    public static void init(List<Position> positions) {
        positions.add(new Coffee(SMALL.getIndex(), COFFEE.name(),
                COFFEE.getDescription(),
                getPrice(SMALL.getIndex()),
                SMALL,
                List.of(Extra.EXTRA_MILK, Extra.FOAMED_MILK, Extra.ROAST_COFFEE)));
        positions.add(new Coffee(MEDIUM.getIndex(), COFFEE.name(),
                COFFEE.getDescription(),
                getPrice(MEDIUM.getIndex()),
                MEDIUM,
                List.of(Extra.EXTRA_MILK, Extra.FOAMED_MILK, Extra.ROAST_COFFEE)));
        positions.add(new Coffee(LARGE.getIndex(), COFFEE.name(),
                COFFEE.getDescription(),
                getPrice(LARGE.getIndex()),
                LARGE,
                List.of(Extra.EXTRA_MILK, Extra.FOAMED_MILK, Extra.ROAST_COFFEE)));
        positions.add(new Roll(ROLL.getIndex(), ROLL.name(),
                ROLL.getDescription(),
                getPrice(ROLL.getIndex())));
        positions.add(new Juice(ORANGE_JUICE.getIndex(), ORANGE_JUICE.name(),
                ORANGE_JUICE.getDescription(),
                getPrice(ORANGE_JUICE.getIndex())));

    }

    public static Double getPrice(int index) {
        return switch (index) {
            case 1 -> 2.55;
            case 2 -> 3.05;
            case 3 -> 3.55;
            case 4 -> 4.53;
            case 5 -> 3.95;
            case 6 -> 0.32;
            case 7 -> 0.51;
            case 8 -> 0.95;
            default -> 0.0;
        };
    }
}
