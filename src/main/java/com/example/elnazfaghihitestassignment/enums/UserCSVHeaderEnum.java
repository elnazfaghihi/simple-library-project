package com.example.elnazfaghihitestassignment.enums;

import com.example.elnazfaghihitestassignment.dto.UserDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UserCSVHeaderEnum implements CSVHeaderInterface<UserDTO>  {
    NAME("Name", UserDTO::setName),
    FIRST_NAME("First name", UserDTO::setFirstname),
    MEMBER_SINCE("Member since", UserDTO::setMemberSince),
    MEMBER_TILL("Member till", UserDTO::setMemberTill),
    GENDER("Gender", UserDTO::setGender);

    private final String value;
    private final BiConsumer<UserDTO, String> dtoSetterFunction;

    UserCSVHeaderEnum(String value, BiConsumer<UserDTO, String> dtoSetterFunction) {
        this.value = value;
        this.dtoSetterFunction = dtoSetterFunction;
    }

    private static final Map<String, UserCSVHeaderEnum> lookup = Arrays.stream(UserCSVHeaderEnum.values())
            .collect(Collectors.toMap(UserCSVHeaderEnum::getValue, sub -> sub));


    public static UserCSVHeaderEnum getByValue(String value) {
        return lookup.get(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        return Stream.of(values())
                .map(UserCSVHeaderEnum::getValue)
                .collect(Collectors.toList());
    }


    @Override
    public BiConsumer<UserDTO, String> getDtoSetterFunction() {
        return dtoSetterFunction;
    }
}
