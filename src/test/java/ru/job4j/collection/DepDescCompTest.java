package ru.job4j.collection;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartment() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K2"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDepartmentEquals() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K2/SK1"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenNaturalOrder() {
        List<String> input =
                Arrays.asList("k2", "k1/sk1", "k1", "k2/sk1/ssk2", "k2/sk1/ssk1", "k1/sk2");
        List<String> expect =
                Arrays.asList("k1", "k1/sk1", "k1/sk2", "k2", "k2/sk1/ssk1", "k2/sk1/ssk2");
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenReverseOrder() {
        List<String> input =
                Arrays.asList("k2", "k2/sk2/ssk1", "k1/sk1", "k1", "k2/sk1/ssk2", "k2/sk1/ssk1");
        List<String> expect =
                Arrays.asList("k2", "k2/sk1/ssk1", "k2/sk1/ssk2", "k2/sk2/ssk1", "k1", "k1/sk1");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}