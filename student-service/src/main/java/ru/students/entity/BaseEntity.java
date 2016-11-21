package ru.students.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column protected Long id;
}