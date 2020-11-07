package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Replaced item");
        item = tracker.add(item);
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"}
                );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Deleted item");
        item = tracker.add(item);
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
                );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Show" + System.lineSeparator()
                +  "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNames() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. FindByName" + System.lineSeparator()
                +  "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item2 = new Item();
        tracker.add(item);
        tracker.add(item2);
        Input in = new StubInput(
                new String[]{"1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. FindById" + System.lineSeparator()
                +  "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                      +  "0. Exit" + System.lineSeparator()
        ));
    }
}