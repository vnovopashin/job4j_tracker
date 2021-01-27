package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] arr1 = o1.split("/");
        String[] arr2 = o2.split("/");
        int res = arr2[0].compareTo(arr1[0]);
        return res == 0 ? o1.compareTo(o2) : res;
    }
}
