package io.polybius.phonevalidator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ValidationResultDto {

    private Map<Country, List<String>> validPhonesByCountry = new HashMap<>();

    private List<String> invalidPhones = new LinkedList<>();

    public Map<Country, List<String>> getValidPhonesByCountry() {
        return validPhonesByCountry;
    }

    public void setValidPhonesByCountry(Map<Country, List<String>> validPhonesByCountry) {
        this.validPhonesByCountry = validPhonesByCountry;
    }

    public List<String> getInvalidPhones() {
        return invalidPhones;
    }

    public void setInvalidPhones(List<String> invalidPhones) {
        this.invalidPhones = invalidPhones;
    }
}
