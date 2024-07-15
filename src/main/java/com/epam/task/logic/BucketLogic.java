package com.epam.task.logic;

import com.epam.task.beans.*;
import com.epam.task.enums.Extra;
import com.epam.task.enums.Item;
import com.epam.task.utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import static com.epam.task.constants.Constants.ORDER_ITEMS;

public class BucketLogic {

    DisplayLogic display = new DisplayLogic();

    public void showBucket(User user, List<Position> positions) {
        if (!positions.isEmpty()) {
            double totalSum = 0.0;
            boolean hasFreeExtra = false;
            boolean orderedSnack = positions.stream().anyMatch(position -> position.getName().equalsIgnoreCase(Item.COFFEE.name()) ||
                    position.getName().equalsIgnoreCase(Item.ORANGE_JUICE.name()));
            boolean orderedBeverage = positions.stream().anyMatch(position -> position.getName().equalsIgnoreCase(Item.ROLL.name()));
            long number = positions.stream()
                    .filter(position -> position instanceof Coffee || position instanceof Juice)
                    .count() + user.getNumberOfBeverageOrdered();
            for (Position position : positions) {
                if (number >= 5 && !(position instanceof Roll)) {
                    totalSum += 0.0;
                    number-= 5;
                } else
                    totalSum += position.getPrice();

                if (Objects.nonNull(position.getExtras())) {
                    for(Extra extra : position.getExtras()) {
                        if(orderedBeverage && orderedSnack && !hasFreeExtra) {
                            totalSum+= 0.0;
                            hasFreeExtra = true;
                            extra.setFree(true);
                        } else
                            totalSum+= Utils.getPrice(extra.getIndex());
                    }
                }
            }
            Order order = new Order(positions, rounding(totalSum));
            display.displayOrder(order);
            ORDER_ITEMS.forEach(System.out::println);
        } else {
            System.out.println("Nothing has been added to order yet...\n");
        }
    }

    private double rounding(double totalSum) {
        BigDecimal bigDecimal = new BigDecimal(totalSum);
        return bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
