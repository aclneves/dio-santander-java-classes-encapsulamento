package br.com.dio.aulaRecord;

public class Main {
    public static void main(String[] args) {
        Person male = new Person("João", 12);
        System.out.println(male.name());
        System.out.println(male.age());

        System.out.println(male.getInfo());

        Person female = new Person("Maria");
        System.out.println(female.name());
        System.out.println(female.age());
        System.out.println(female.getInfo());
    }
}
