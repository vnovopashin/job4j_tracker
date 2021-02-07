package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    private List<Profile> profileList = new ArrayList<>();

    @Before
    public void setUp() {
        profileList.add(new Profile(new Address("City", "Street", 5, 1)));
        profileList.add(new Profile(new Address("City", "Street", 5, 1)));
        profileList.add(new Profile(new Address("NewCity", "NewStreet", 6, 2)));
        profileList.add(new Profile(new Address("NewCity", "NewStreet", 6, 2)));
        profileList.add(new Profile(new Address("City", "Street", 5, 1)));
    }

    @Test
    public void whenCollectProfilesToAddress() {
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(profileList);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("City", "Street", 5, 1));
        expected.add(new Address("NewCity", "NewStreet", 6, 2));

        assertThat(rsl, is(expected));
    }
}