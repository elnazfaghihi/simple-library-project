package com.example.elnazfaghihitestassignment.model;

import com.example.elnazfaghihitestassignment.enums.Gender;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "member_since")
    private Date memberSince;

    @Column(name = "member_till")
    private Date memberTill;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public User(String name, String firstName,  Gender gender) {
        this.name = name;
        this.firstName = firstName;
        this.gender = gender;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getMemberTill() {
        return memberTill;
    }

    public void setMemberTill(Date memberTill) {
        this.memberTill = memberTill;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
