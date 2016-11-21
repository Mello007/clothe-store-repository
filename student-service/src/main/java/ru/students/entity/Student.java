package ru.students.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity @Table(name = "Student")

public class Student extends BaseEntity{
    private String name;
    private String dateOfBirthDay;
    private String sex;
    private String phoneNumber;
}
