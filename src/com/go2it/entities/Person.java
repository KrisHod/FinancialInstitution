package com.go2it.entities;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String surname;
    private LocalDate DoB;

    public Person(String name, String surname, LocalDate doB) {
        this.name = name;
        this.surname = surname;
        DoB = doB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate doB) {
        DoB = doB;
    }

}
