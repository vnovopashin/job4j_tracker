package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    /**
     * Метод принимает на вход список типа Profile, возвращает список типа Address
     *
     * @param profiles Список для преобразования типа Profile
     * @return Преобразованный список содержит уникальные элементы типа Address
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
