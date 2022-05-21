package com.example.elnazfaghihitestassignment.dto;

import com.example.elnazfaghihitestassignment.enums.Gender;
import com.example.elnazfaghihitestassignment.model.User;
import com.example.elnazfaghihitestassignment.util.DateUtil;
import org.modelmapper.ModelMapper;

import java.util.Date;

public class UserDTO {

    private String name;
    private String firstname;
    private Date memberSince;
    private Date memberTill;
    private Gender gender;

    public User toModel() {
        return new ModelMapper().map(this, User.class);
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = DateUtil.convertStringToDate(memberSince);
    }

    public Date getMemberTill() {
        return memberTill;
    }

    public void setMemberTill(String memberTill) {
        this.memberTill = DateUtil.convertStringToDate(memberTill);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = Gender.getByValue(gender);
    }
}
