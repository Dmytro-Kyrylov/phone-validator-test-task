package io.polybius.phonevalidator;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MobilePhoneNumberValidatorTest {

    private final MobilePhoneNumberValidator validator = new MobilePhoneNumberValidator();

    @Test
    public void should_returnLithuania_when_correctPhoneNumber() {
        Optional<Country> countryByPhoneNumber = validator.getCountryByPhoneNumber("+37060000000");
        assertEquals(Country.LITHUANIA, countryByPhoneNumber.orElse(null));
    }

    @Test
    public void should_returnLatvia_when_correctPhoneNumber() {
        Optional<Country> countryByPhoneNumber = validator.getCountryByPhoneNumber("+37120000000");
        assertEquals(Country.LATVIA, countryByPhoneNumber.orElse(null));
    }

    @Test
    public void should_returnEstonia_when_correctPhoneNumber() {
        Optional<Country> countryByPhoneNumber = validator.getCountryByPhoneNumber("+37250000000");
        assertEquals(Country.ESTONIA, countryByPhoneNumber.orElse(null));

        countryByPhoneNumber = validator.getCountryByPhoneNumber("+3725000000");
        assertEquals(Country.ESTONIA, countryByPhoneNumber.orElse(null));
    }

    @Test
    public void should_returnBelgium_when_correctPhoneNumber() {
        Optional<Country> countryByPhoneNumber = validator.getCountryByPhoneNumber("+32456000000");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));

        countryByPhoneNumber = validator.getCountryByPhoneNumber("+32470000000");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));

        countryByPhoneNumber = validator.getCountryByPhoneNumber("+32480000000");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));

        countryByPhoneNumber = validator.getCountryByPhoneNumber("+32490000000");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));
    }

    @Test
    public void should_returnAnyCountry_when_correctPhoneNumberWithExtraSymbols() {
        Optional<Country> countryByPhoneNumber = validator.getCountryByPhoneNumber("32456000000");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));

        countryByPhoneNumber = validator.getCountryByPhoneNumber("+32-47-000-00-00");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));

        countryByPhoneNumber = validator.getCountryByPhoneNumber("32 48 000 00 00");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));

        countryByPhoneNumber = validator.getCountryByPhoneNumber("+32(49) 000-00-00");
        assertEquals(Country.BELGIUM, countryByPhoneNumber.orElse(null));
    }

    @Test
    public void should_empty_when_phoneNumberIncorrect() {
        Optional<Country> countryByPhoneNumber = validator.getCountryByPhoneNumber("3245600000000000");
        assertTrue(countryByPhoneNumber.isEmpty());

        countryByPhoneNumber = validator.getCountryByPhoneNumber("324560");
        assertTrue(countryByPhoneNumber.isEmpty());

        countryByPhoneNumber = validator.getCountryByPhoneNumber("32459000000");
        assertTrue(countryByPhoneNumber.isEmpty());

        countryByPhoneNumber = validator.getCountryByPhoneNumber("31245900000");
        assertTrue(countryByPhoneNumber.isEmpty());
    }

}