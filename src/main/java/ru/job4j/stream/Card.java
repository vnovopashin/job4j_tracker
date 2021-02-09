package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();

        Stream.of(suits)
                .forEach(s -> Stream.of(values)
                        .map(v -> s + " " + v)
                        .forEach(System.out::println));
    }
}