package com.company;

/**
 * Created by artem on 25.03.16.
 */

public class Dima implements Human
{
    public void setAge(Integer age) {
        this.age = age;
    }


    private Integer age = 129;
    private String name = "Diman";

    @Override
    public void setFammily(String fammily) {
        this.fammily = fammily;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String fammily = "MotherandFather";

    @Override
    public String getFammily() {
        return fammily;
    }


    @Override
    public Integer getNullableAge() {
        return age;
    }

    @Override
    public Human clone() {
        Dima dima = new Dima();
        dima.age = age;
        dima.name = name;
        return dima;
    }

    @Override
    public int hashCode() {
        return age*name.length();
    }

    public String toString() {
        return "age =" + age + " name = " + name + " fammily = " + fammily;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }
}
