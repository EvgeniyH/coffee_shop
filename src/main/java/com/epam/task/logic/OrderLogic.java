package com.epam.task.logic;

import com.epam.task.beans.Coffee;
import com.epam.task.beans.Juice;
import com.epam.task.beans.Position;
import com.epam.task.beans.User;
import com.epam.task.enums.Extra;
import com.epam.task.utils.Utils;

import java.util.*;

import static com.epam.task.constants.Constants.*;

public class OrderLogic {

    DisplayLogic display = new DisplayLogic();

    public static void addOrderToHistory(User user, List<Position> positions) {
        int orderNumber = user.getOrders().size() + 1;
        var userOrders = new HashMap<Integer, List<Position>>();
        userOrders.put(orderNumber, positions);
        user.setOrders(userOrders);
        increaseNumberOfBeverage(user, positions);
        user.decreaseNumber();
    }

    public static void increaseNumberOfBeverage(User user, List<Position> positions) {
        positions.stream()
                .filter(position -> position instanceof Coffee || position instanceof Juice)
                .forEach(position -> user.increaseNumber());
    }

    public void addExtra(Scanner scanner, Position position, Position chosen) {
        try {
            position.getExtras().forEach(extra -> System.out.printf(MENU_POSITION_TEMPLATE, extra.getIndex(), extra.getDescription(), Utils.getPrice(extra.getIndex())));
            System.out.println("\nEnter the position number you want to order...");
            String extraIndex = scanner.nextLine();

            List<Extra> extras = new ArrayList<>(List.copyOf(chosen.getExtras()));
            Extra extra = Extra.getExtra(Integer.parseInt(extraIndex));
            if (extras.isEmpty()) {
                chosen.setExtras(List.of(extra));
            } else {
                extras.add(extra);
                chosen.setExtras(extras);
            }
            display.displayExtra(extra);

            System.out.println("Do you want to add extra? Y or N?");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y"))
                addExtra(scanner, position, chosen);

        } catch (RuntimeException e) {
            System.out.println("Invalid command, try again ...");
        }
    }

    public void clearOrder(List<Position> positions) throws InterruptedException {
        positions.clear();

        System.out.println(CANCEL_ORDER_TITLE);
        Thread.sleep(2000);
    }

    public void pay(User user, List<Position> positions) throws InterruptedException {
        if (!positions.isEmpty()) {
            System.out.println("Wait a moment, transaction is in process...\n");
            Thread.sleep(3000);

            System.out.printf(COMPLETE_ORDER_TITLE, new Random().nextInt(100));
            Thread.sleep(2000);
            System.out.println();
            OrderLogic.addOrderToHistory(user, positions);
        } else
            System.out.println("Nothing has been added to order yet...\n");
    }

    public void orderPosition(int index, List<Position> menu, Scanner scanner, List<Position> positions) {
        Position position = menu.stream().filter(item -> item.getIndex() == index).findFirst()
                .orElseThrow(() -> new RuntimeException("Position not found, try again ..."));
        Position chosen = position instanceof Coffee ? new Coffee(position) :
                position instanceof Juice ? new Juice(position) : new Position(position);
        if (Objects.nonNull(position.getExtras())) {
            System.out.println("Do you want to add extra? Y or N?");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                addExtra(scanner, position, chosen);
            }
        }
        positions.add(chosen);

        StringBuilder extras = new StringBuilder();
        if (!Objects.requireNonNull(chosen).getExtras().isEmpty()) {
            chosen.getExtras().forEach(extra -> {
                extras.append("\n+ ");
                extras.append(extra.name());
            });
        }
        display.displayChosen(chosen, extras);
    }
}
