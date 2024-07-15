package com.epam.task;

import com.epam.task.logic.MainLogic;

/**
 * Simple Coffee shop application
 */
public class CoffeeShopApplication {
    public static void main( String[] args ) {
        MainLogic logic = new MainLogic();
        logic.start();
    }
}
