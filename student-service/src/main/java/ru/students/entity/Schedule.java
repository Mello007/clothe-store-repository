package ru.students.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Schedule")

public class Schedule extends BaseEntity {
    private String teacher;
    private String discipline;
    private String lectureHull;
}
