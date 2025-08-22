package br.com.dio.exercicios.petShop;

import java.util.Scanner;


public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PetWashMachine petWashMachine = new PetWashMachine();

    public static void main(String[] args) {

        int option = -1;

        do {
            System.out.println("===Escolha uma das opções: ===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer máquina com água");
            System.out.println("3 - Abastecer máquina com shampoo");
            System.out.println("4 - Verificar quantidade de água na máquina");
            System.out.println("5 - Verificar quantidade de shampoo na máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet na máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> petWashMachine.washPet();
                case 2 -> addWaterInMachine();
                case 3 -> addShampooInMachine();
                case 4 -> verifyWaterAmount();
                case 5 -> verifyShampooAmount();
                case 6 -> checkIfHasPet();
                case 7 -> insertPetInMachine();
                case 8 -> petWashMachine.removePet();
                case 9 -> petWashMachine.cleanMachine();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private static void addWaterInMachine() {
        System.out.println("Tentando colocar água na máquina.");
        petWashMachine.addWater();
        verifyWaterAmount();
    }

    private static void addShampooInMachine() {
        System.out.println("Tentando colocar shampoo na máquina.");
        petWashMachine.addShampoo();
        verifyShampooAmount();
    }

    private static void verifyWaterAmount() {
        int amount = petWashMachine.getWater();
        System.out.println("A máquina está abastecida com " + amount + " litros de água");
    }

    private static void verifyShampooAmount() {
        int amount = petWashMachine.getShampoo();
        System.out.println("A máquina está abastecida com " + amount + " litros de shampoo");
    }

    private static void checkIfHasPet() {
        boolean hasPet = petWashMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina." : "Não tem pet na máquina.");
    }


    private static void insertPetInMachine() {
        System.out.println("Insira o nome do pet: ");

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        String name = scanner.nextLine().trim();

        while (name.isBlank()) {
            System.out.println("O nome do pet não pode estar em branco. Tente novamente: ");
            name = scanner.nextLine().trim();

        }

        Pet pet = new Pet(name);
        boolean success = petWashMachine.setPet(pet);
        if (success) {
            System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
        }
    }
}


