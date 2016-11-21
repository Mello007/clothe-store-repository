package ru.students.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Chair")

public class Chair extends BaseEntity {
        private String description;
    private String head;
}
