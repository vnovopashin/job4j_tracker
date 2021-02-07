package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    private final List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));

    }

    @Test
    public void whenCollectToMap() {
        ListToMap listToMap = new ListToMap();
        Map<String, Student> rsl = listToMap.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname2", new Student(20, "Surname2"));
        expected.put("Surname3", new Student(30, "Surname3"));
        assertThat(rsl, is(expected));

    }
}