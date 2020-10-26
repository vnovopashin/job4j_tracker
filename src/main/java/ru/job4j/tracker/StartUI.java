package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            int id;
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка заменена");
                } else {
                    System.out.println("Заявка не заменена");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter id: ");
                id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена");
                } else {
                    System.out.println("Заявка не удалена");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.print("Enter id: ");
                id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                System.out.print("Bye bye :)");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.print("Select: ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

    }

}
