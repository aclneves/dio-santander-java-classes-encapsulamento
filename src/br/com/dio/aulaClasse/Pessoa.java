package br.com.dio.aulaClasse;

import java.time.OffsetDateTime;

public class Pessoa {

    private final String name;
    private int age;
    private int lastYearAgeInc = OffsetDateTime.now().getYear() -1;

    public Pessoa(String name) {
        this.name = name;
        this.age = 1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getLastYearAgeInc() {
        return lastYearAgeInc;
    }

    public void increaseAge() {
        if (this.lastYearAgeInc >= OffsetDateTime.now().getYear()) return;

        this.age+=1;
        this.lastYearAgeInc = OffsetDateTime.now().getYear();
    }

}
