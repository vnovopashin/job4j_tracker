package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    /**
     * Метод принимает на вход список типа Profile, возвращает список типа Address
     *
     * @param profiles Список для преобразования типа Profile
     * @return Преобразованный список типа Address
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
