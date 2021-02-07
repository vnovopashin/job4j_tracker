package ru.job4j.stream;

import java.util.Objects;

/**
 * Класс описывает профиль клиента
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "Profile{"
                + "address=" + address
                + '}';
    }
}
