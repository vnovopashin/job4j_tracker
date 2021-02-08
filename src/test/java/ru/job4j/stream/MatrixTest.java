package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenMatrixToList() {
        Integer[][] array = new Integer[][]{{1, 2}, {3, 4}};
        List<Integer> exp = Arrays.asList(1, 2, 3, 4);
        Matrix matrix = new Matrix();
        List<Integer> rsl = matrix.collect(array);
        assertThat(rsl, is(exp));
    }
}