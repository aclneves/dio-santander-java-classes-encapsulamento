package br.com.dio.aulaRecord;

public record Person(String name, int age) {
    public Person{
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public Person(final String name) {
        this(name, 1);
    }

    public String getInfo(){
        return "Name: " + name + " Age: " + age;
    }
}
