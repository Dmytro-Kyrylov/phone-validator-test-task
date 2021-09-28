package io.polybius.phonevalidator;

import java.util.List;

public enum Country {

    LITHUANIA("LT", "370", List.of("6"), List.of(8)),
    LATVIA("LV", "371", List.of("2"), List.of(8)),
    ESTONIA("EE", "372", List.of("5"), List.of(7, 8)),
    BELGIUM("BE", "32", List.of("456", "47", "48", "49"), List.of(9));

    private final String isoCode;

    private final String phoneCode;

    private final List<String> operatorCodes;

    private final List<Integer> allowedLength;

    Country(String isoCode, String phoneCode, List<String> operatorCodes, List<Integer> allowedLength) {
        this.isoCode = isoCode;
        this.phoneCode = phoneCode;
        this.operatorCodes = operatorCodes;
        this.allowedLength = allowedLength;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public List<String> getOperatorCodes() {
        return operatorCodes;
    }

    public List<Integer> getAllowedLength() {
        return allowedLength;
    }
}
