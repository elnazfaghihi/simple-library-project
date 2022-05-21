package com.example.elnazfaghihitestassignment.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Gender {
    FEMALE("f"),
    MALE("m");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static final Map<String, Gender> lookup = Arrays.stream(Gender.values())
            .collect(Collectors.toMap(Gender::getValue, sub -> sub));

    public static Gender getByValue(String value) {
        return lookup.get(value);
    }
}
