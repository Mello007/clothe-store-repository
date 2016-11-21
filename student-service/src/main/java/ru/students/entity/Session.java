package ru.students.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Session")

public class Session extends BaseEntity {
    private String description;
    private String teacherName;
    private String discipline;
    private String numberGroup;
    private String dateOfPass;
}
