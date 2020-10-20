package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item(1, "item");
        LocalDateTime currentDateTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(currentDateTime.format(formatter));
        System.out.println(item);
        Tracker tracker = new Tracker();
        tracker.add(item);
        System.out.println(tracker.findById(1));

    }

}
