package com.example.elnazfaghihitestassignment.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Genre {

    ECONOMICS("economics"),
    HISTORY("history"),
    NONFICTION("nonfiction"),
    FICTION("fiction"),
    MATHEMATICS("mathematics"),
    SCIENCE("science"),
    DATA_SCIENCE("data_science"),
    COMPUTER_SCIENCE("computer_science");


    private final String value;

    private static final Map<String, Genre> lookup = Arrays.stream(Genre.values())
            .collect(Collectors.toMap(Genre::getValue, sub -> sub));

    public static Genre getByValue(String value) {
        return lookup.get(value);
    }

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
