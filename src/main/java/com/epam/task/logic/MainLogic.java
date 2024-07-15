package com.epam.task.logic;

import com.epam.task.beans.Position;
import com.epam.task.beans.User;
import com.epam.task.enums.Command;
import com.epam.task.enums.Point;
import com.epam.task.utils.Utils;

import java.util.*;

import static com.epam.task.constants.Constants.*;

public class MainLogic {
    static volatile List<Position> menu = new ArrayList<>();
    static volatile List<Position> positions = new ArrayList<>();
    static volatile Point point;
    static volatile User user =  new User();

    DisplayLogic display = new DisplayLogic();
    OrderLogic order = new OrderLogic();
    BucketLogic bucket = new BucketLogic();

    static {
        Utils.init(menu);
        mainMenuLoad();
    }

    public void start() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                try {
                    String input = scanner.nextLine();
                    if (inputIsCommand(input)) {
                        Command command = Command.valueOf(input.toUpperCase(Locale.ROOT));

                        switch (command) {
                            case MAIN_MENU ->
                                mainMenuLoad();
                            case I -> {
                                System.out.println(INFO_TITLE);
                                System.out.println(INFORMATION);

                                mainMenuLoadItems();
                            }
                            case M -> {
                                point = Point.POSITION;

                                System.out.println(MENU_TITLE);
                                menu.forEach(display::displayPosition);
                                System.out.println("\n");

                                mainMenuLoadItems();
                                System.out.println("Enter the position number you want to order...");
                            }
                            case B -> {
                                System.out.println(BUCKET_TITLE);
                                bucket.showBucket(user, positions);

                                mainMenuLoadItems();
                            }
                            case P -> {
                                order.pay(user, positions);

                                mainMenuLoad();
                            }
                            case C -> {
                                if (!positions.isEmpty())
                                    order.clearOrder(positions);

                                mainMenuLoad();
                            }
                            case E -> System.exit(0);
                        }
                    } else {
                        if (Objects.equals(point, Point.POSITION)
                                && !point.name().equalsIgnoreCase(input)) {
                            point = Point.POSITION;
                            int index = Integer.parseInt(input.trim());
                            order.orderPosition(index, menu, scanner, positions);
                        }
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (RuntimeException e) {
                    System.out.println("Invalid command, try again ...");
                }
            }
        }
    }

    private static void mainMenuLoad() {
        System.out.println(MAIN_MENU_TITLE);
        mainMenuLoadItems();
    }

    private static void mainMenuLoadItems() {
        System.out.println(String.join("\t\t", MAIN_MENU_ITEMS));
    }

    private boolean inputIsCommand(String input) {
        return Arrays.stream(Command.values()).anyMatch(command -> command.name().equalsIgnoreCase(input));
    }
}
