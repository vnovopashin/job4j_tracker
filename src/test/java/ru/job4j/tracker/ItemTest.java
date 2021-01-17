package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void whenSortNaturalOrder() {
        List<Item> items = Arrays.asList(
                new Item(2, "Two"),
                new Item(1, "One"),
                new Item(5, "Five")
        );
        Collections.sort(items, new SortByIdItemNaturalOrder());
        Assert.assertThat(items,
                is(Arrays.asList(
                        new Item(1, "One"),
                        new Item(2, "Two"),
                        new Item(5, "Five")))
        );
    }

    @Test
    public void whenSortReverseOrder() {
        List<Item> items = Arrays.asList(
                new Item(2, "Two"),
                new Item(1, "One"),
                new Item(5, "Five")
        );
        Collections.sort(items, new SortByIdItemReverseOrder());
        Assert.assertThat(items,
                is(Arrays.asList(
                        new Item(5, "Five"),
                        new Item(2, "Two"),
                        new Item(1, "One")))
        );
    }

}