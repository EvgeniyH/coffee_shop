package com.epam.task.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.epam.task.beans.*;
import com.epam.task.enums.Extra;
import com.epam.task.enums.Item;
import com.epam.task.enums.Size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderLogicTest {

    User user;
    OrderLogic order;
    ArrayList<Position> positions;

    @Before
    public void setUp() {
        user = new User();
        order = new OrderLogic();
        positions = new ArrayList<>();
    }

    @Test
    public void testAddOrderToHistoryAndHistoryIsEmpty() {
        OrderLogic.addOrderToHistory(user, positions);

        HashMap<Integer, List<Position>> orders = user.getOrders();
        List<Position> getResult = orders.get(1);
        assertTrue(getResult.isEmpty());
    }

    @Test
    public void testAddOrderToHistoryAndResultTheSame() {
        OrderLogic.addOrderToHistory(user, positions);

        HashMap<Integer, List<Position>> orders = user.getOrders();
        List<Position> getResult = orders.get(1);
        assertSame(positions, getResult);
    }

    @Test
    public void testAddOrderToHistoryAndOrderContainsOnePosition() {

        Coffee coffee = new Coffee(1, Item.COFFEE.name(), Item.COFFEE.getDescription(), 10.0d, Size.MEDIUM, List.of(Extra.EXTRA_MILK, Extra.ROAST_COFFEE));
        positions.add(coffee);

        OrderLogic.addOrderToHistory(user, positions);

        HashMap<Integer, List<Position>> orders = user.getOrders();
        assertEquals(1, orders.size());
        assertSame(coffee, positions.get(0));
        assertSame(positions, orders.get(1));
    }

    @Test
    public void testAddOrderToHistoryAndPositionsContainsTheSamePosition() {

        Coffee coffee = new Coffee(1, Item.COFFEE.name(), Item.COFFEE.getDescription(), 10.0d, Size.MEDIUM, List.of(Extra.EXTRA_MILK, Extra.ROAST_COFFEE));
        positions.add(coffee);

        OrderLogic.addOrderToHistory(user, positions);

        assertSame(coffee, positions.get(0));
    }

    @Test
    public void testAddOrderToHistoryAndOrderContainsTheSamePosition() {

        Coffee coffee = new Coffee(1, Item.COFFEE.name(), Item.COFFEE.getDescription(), 10.0d, Size.MEDIUM, List.of(Extra.EXTRA_MILK, Extra.ROAST_COFFEE));
        positions.add(coffee);

        OrderLogic.addOrderToHistory(user, positions);

        HashMap<Integer, List<Position>> orders = user.getOrders();
        assertSame(positions, orders.get(1));
    }

    @Test
    public void testIncreaseNumberOfBeverageEqualsAndNumberIs1() {
        positions.add(new Coffee(1, Item.COFFEE.name(), Item.COFFEE.getDescription(), 10.0d, Size.MEDIUM, List.of(Extra.EXTRA_MILK, Extra.ROAST_COFFEE)));

        OrderLogic.increaseNumberOfBeverage(user, positions);

        assertEquals(1, user.getNumberOfBeverageOrdered());
    }

    @Test
    public void testIncreaseNumberOfBeverageAnsNumberIs0() {
        positions.add(new Roll(Item.ROLL.getIndex(), Item.ROLL.name(), Item.ROLL.getDescription(), 5D));

        OrderLogic.increaseNumberOfBeverage(user, positions);

        assertEquals(0, user.getNumberOfBeverageOrdered());
    }

    @Test
    public void testOrderPositionEmptyMenu() {

        ArrayList<Position> menu = new ArrayList<>();
        Scanner scanner = new Scanner("1");

        assertThrows(RuntimeException.class, () -> order.orderPosition(1, menu, scanner, new ArrayList<>()));
    }

    @Test
    public void testOrderPositionAndPositionsContainsOnePosition() {
        ArrayList<Position> menu = new ArrayList<>();
        menu.add(new Juice(Item.ORANGE_JUICE.getIndex(), Item.ORANGE_JUICE.name(), Item.ORANGE_JUICE.getDescription(), 4D));
        Scanner scanner = new Scanner("1");

        order.orderPosition(Item.ORANGE_JUICE.getIndex(), menu, scanner, positions);

        Assert.assertEquals(1, positions.size());
    }

    @Test
    public void testOrderPositionAndPositionsSizeTheSameAsMenuSize() {
        ArrayList<Position> menu = new ArrayList<>();
        menu.add(new Juice(Item.ORANGE_JUICE.getIndex(), Item.ORANGE_JUICE.name(), Item.ORANGE_JUICE.getDescription(), 4D));
        Scanner scanner = new Scanner("1");

        order.orderPosition(Item.ORANGE_JUICE.getIndex(), menu, scanner, positions);

        Assert.assertEquals(menu.size(),positions.size());
    }

    @Test
    public void testOrderPositionAndPositionNameTheSameAsPositionMenuName() {
        ArrayList<Position> menu = new ArrayList<>();
        menu.add(new Juice(Item.ORANGE_JUICE.getIndex(), Item.ORANGE_JUICE.name(), Item.ORANGE_JUICE.getDescription(), 4D));
        Scanner scanner = new Scanner("1");

        order.orderPosition(Item.ORANGE_JUICE.getIndex(), menu, scanner, positions);

        Assert.assertTrue(menu.get(0).getName().equalsIgnoreCase(positions.get(0).getName()));
    }

    @Test
    public void testOrderPositionNotFoundPosition() {
        ArrayList<Position> menu = new ArrayList<>();
        menu.add(new Juice(Item.ORANGE_JUICE.getIndex(), Item.ORANGE_JUICE.name(), Item.ORANGE_JUICE.getDescription(), 4D));
        Scanner scanner = new Scanner("1");

        assertThrows(RuntimeException.class, () -> order.orderPosition(1, menu, scanner, new ArrayList<>()));
    }
}
