package ru.students.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter @Entity @Table(name = "Teacher")


public class Teacher extends BaseEntity{
    private String name;
    private String address;
    private String numberPhone;
    private String category;
}
