package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка заменена");
        } else {
            System.out.println("Заявка не заменена");
        }
        return true;
    }
}
