package com.epam.task.constants;

import java.util.List;

public class Constants {

    public static final String INFORMATION = """
            \tWelcome to Coffee shop. Here you can order different types of coffee,\s
            juices and snacks. We can't offer a lot of variety yet, but we work on that.
            So try to choose what you like and enjoy your drink and snacks.

            Best wishes, administration ;)
            """;
    public static final String CURRENCY = "CHF";
    public static final List<String> MAIN_MENU_ITEMS = List.of("> I - info", "> M - menu", "> B - bucket", "> E - exit\n");
    public static final List<String> ORDER_ITEMS = List.of("> P - pay", "> C - cancel");

    public static final String MENU_TITLE = """
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            ||                          MENU                            ||
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            """;
    public static final String BUCKET_TITLE = """
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            ||                         BUCKET                           ||
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            """;
    public static final String INFO_TITLE = """
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            ||                          INFO                            ||
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            """;
    public static final String MAIN_MENU_TITLE = """
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            ||                        MAIN MENU                         ||
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            """;
    public static final String COMPLETE_ORDER_TITLE = """
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            ||                                                          ||
            ||      Completed! Thank you, your order number is %s       ||
            ||                                                          ||
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            """;
    public static final String CANCEL_ORDER_TITLE = """
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            ||                                                          ||
            ||              Your order has been canceled                ||
            ||                                                          ||
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
            """;
    public static String RESULT_ORDER_TEMPLATE = "%s(%s) x 1 has been successfully added. Let's continue? B - Bucket\n";
    public static String RESULT_ORDER_EXTRA_TEMPLATE = "%s(%s) x 1 %s\n has been successfully added. Let's continue? B - Bucket\n";
    public static String MENU_POSITION_COFFEE_TEMPLATE = "%d. %s(%s) \t\t\t%s\n";
    public static String MENU_POSITION_TEMPLATE = "%d. %s \t\t\t%s\n";
    public static String POSITION_EXTRA_TEMPLATE = " + %s \t\t\t\t%s\n";
    public static String TOTAL_TEMPLATE = "\nTotal: %s%s\n";
}
