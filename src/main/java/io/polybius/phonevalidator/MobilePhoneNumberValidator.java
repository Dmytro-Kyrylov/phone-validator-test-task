package io.polybius.phonevalidator;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MobilePhoneNumberValidator {

    public ValidationResultDto validate(List<String> phoneNumbers) {
        ValidationResultDto result = new ValidationResultDto();

        for (String phoneNumber : phoneNumbers) {
            Optional<Country> countryByPhoneNumber = getCountryByPhoneNumber(phoneNumber);

            if (countryByPhoneNumber.isPresent()) {
                Country country = countryByPhoneNumber.get();
                if (!result.getValidPhonesByCountry().containsKey(country)) {
                    result.getValidPhonesByCountry().put(country, new LinkedList<>());
                }

                result.getValidPhonesByCountry().get(country).add(phoneNumber);
            } else {
                result.getInvalidPhones().add(phoneNumber);
            }
        }

        return result;
    }

    public Optional<Country> getCountryByPhoneNumber(String phoneNumber) {
        String formattedPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");

        for (Country country : Country.values()) {
            if (formattedPhoneNumber.startsWith(country.getPhoneCode())) {
                String phoneNumberWithoutCountryCode = formattedPhoneNumber
                        .replaceFirst(country.getPhoneCode(), "");

                boolean isOperatorCodeValid = country.getOperatorCodes()
                        .stream()
                        .anyMatch(phoneNumberWithoutCountryCode::startsWith);

                boolean isLengthCorrect = country.getAllowedLength()
                        .stream()
                        .anyMatch(allowedLength -> phoneNumberWithoutCountryCode.length() == allowedLength);

                if (isOperatorCodeValid && isLengthCorrect) {
                    return Optional.of(country);
                }
            }
        }

        return Optional.empty();
    }

}
