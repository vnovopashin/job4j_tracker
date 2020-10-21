package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
       return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithOutNull = findAll();
        int size = 0;
        for (int index = 0; index < itemsWithOutNull.length; index++) {
            Item item = itemsWithOutNull[index];
            if (key.equals(item.getName())) {
                itemsWithOutNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsWithOutNull, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != 1;
        if (rsl) {
            int start = index + 1;
            int distPos = index;
            int length = size - index;
            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}