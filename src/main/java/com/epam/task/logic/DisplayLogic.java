package com.epam.task.logic;

import com.epam.task.beans.Coffee;
import com.epam.task.beans.Order;
import com.epam.task.beans.Position;
import com.epam.task.enums.Extra;
import com.epam.task.utils.Utils;

import java.util.Objects;

import static com.epam.task.constants.Constants.*;

public class DisplayLogic {

    public void displayChosen(Position chosen, StringBuilder extras) {
        if(chosen instanceof Coffee coffee) {
            if(!extras.isEmpty())
                System.out.printf(RESULT_ORDER_EXTRA_TEMPLATE, coffee.getDescription(), coffee.getSize().getDescription(), extras);
            else
                System.out.printf(RESULT_ORDER_TEMPLATE, coffee.getDescription(), coffee.getSize().getDescription());
        } else {
            System.out.printf(RESULT_ORDER_TEMPLATE, chosen.getName(), chosen.getDescription());
        }
    }

    public void displayOrder(Order order) {
        order.getPositions().forEach(this::displayPosition);
        System.out.printf(TOTAL_TEMPLATE, order.getTotalPrice(), CURRENCY);
    }

    public void displayPosition(Position position) {
        if(position instanceof Coffee coffee) {
            System.out.printf(MENU_POSITION_COFFEE_TEMPLATE, coffee.getIndex(), coffee.getDescription(), coffee.getSize().getDescription(), position.getPrice());
        } else
            System.out.printf(MENU_POSITION_TEMPLATE, position.getIndex(), position.getDescription(), position.getPrice());
        if (Objects.nonNull(position.getExtras()))
            position.getExtras().forEach(this::displayExtra);
    }

    public void displayExtra(Extra extra) {
        System.out.printf(POSITION_EXTRA_TEMPLATE, extra.getDescription(), extra.isFree() ? "free" : Utils.getPrice(extra.getIndex()));
    }
}
