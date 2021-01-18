package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenJobAscByName() {
        Comparator<Job> cmpJobAskByName = new JobAscByName();
        int rsl = cmpJobAskByName.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobAscByPriority() {
        Comparator<Job> cmpJobAskByPriority = new JobAscByPriority();
        int rsl = cmpJobAskByPriority.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByName() {
        Comparator<Job> cmpJobDescByName = new JobDescByName();
        int rsl = cmpJobDescByName.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByPriority() {
        Comparator<Job> cmpJobDeskByPriority = new JobDescByPriority();
        int rsl = cmpJobDeskByPriority.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorJobDescByNameAndJobDescByPriority() {
        Comparator<Job> cmp = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorJobDescByNameAndJobAscByPriority() {
        Comparator<Job> cmp = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorJobDescByPriorityAndJobAscByName() {
        Comparator<Job> cmp = new JobDescByPriority()
                .thenComparing(new JobAscByName());
        int rsl = cmp.compare(
                new Job("X bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}