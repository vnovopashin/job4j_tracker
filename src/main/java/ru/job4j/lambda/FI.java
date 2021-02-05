package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };

        Comparator<Attachment> compLambda = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return right.getSize() - left.getSize();
        };
        Arrays.sort(atts, compLambda);
    }
}
