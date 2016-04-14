package com.company;

/**
 * Created by artem on 25.03.16.
 */
public class Vasia implements Human, Comparable
{
    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age = 129;
    private String name = "Vasia";
    private String fammily = "MotherandFather";

    public String getFammily()
    {
        return fammily;
    }
    @Override
    public Integer getNullableAge()
    {
        return age;
    }


    @Override
    public void setFammily(String fammily) {
        this.fammily = fammily;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Human clone() {
        Vasia vasia = new Vasia();
        vasia.age = age;
        vasia.name = name;
        return vasia;
    }

    @Override
    public int hashCode() {
        return age*name.length();
    }

    @Override
    public String toString() {
        return "age =" + age + " name = " + name + " fammily = " + fammily;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }

    @Override
    public int compareTo(Object o) {
        return (o.hashCode() - this.hashCode());
    }
}
