package br.com.dio.aulaClasse;

import br.com.dio.aulaRecord.Person;

public class Main {
    public static void main(String[] args) {

        Pessoa male = new Pessoa("João");
        male.increaseAge();
        Pessoa female = new Pessoa("Maria");
        female.increaseAge();

        System.out.println("Male name: " + male.getName() + " age: " + male.getAge());
        System.out.println("Female name: " + female.getName() + " age: " + female.getAge());
    }
}
