package br.com.dio.exercicios.petShop;

public class PetWashMachine {

    private boolean isClean;
    private int water;
    private int shampoo;
    private Pet pet;

    public PetWashMachine() {
        this.water = 30;
        this.shampoo = 10;
        this.isClean = true;
    }

    public void washPet() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }

        if (this.water < 10 ) {
            System.out.println("A máquina não tem água suficiente para o banho.");
            return;
        }

        if (this.shampoo < 2) {
            System.out.println("A máquina não tem shampoo suficiente para o banho.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);

        this.isClean = false;

        System.out.println("O pet " + pet.getName() + " está limpo!");
        System.out.println("A máquina ficou suja após o banho");
    }

    public void addWater() {
        if (water == 30) {
            System.out.println("A capacidade de água da máquina está no máximo.");
            return;
        }

        water += 2;
        System.out.println("Foram adicionados 2 litros de água na máquina.");
    }

    public void addShampoo() {
        if (shampoo == 10) {
            System.out.println("A capacidade de shampoo da máquina está no máximo.");
            return;
        }

        shampoo += 2;
        System.out.println("Foram adicionados 2 litros de shampoo na máquina.");
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public Pet getPet() {
        return pet;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public boolean setPet(Pet pet) {
        if (!this.isClean) {
            System.out.println("A máquina precisa estar limpa para aceitar um pet.");
            return false;
        }
        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " está na máquina.");
            return false;
        }
        this.pet = pet;
        return true;
    }

    public void removePet() {
        if (this.pet == null) {
            System.out.println("Não há pet na máquina.");
            return;
        }
        
        if(!this.pet.isClean()) {
            this.isClean = false;
            System.out.println("O pet " + this.pet.getName() + " foi removido da máquina.");
            System.out.println("⚠️ Pet sujo contaminou a máquina! Limpe antes do próximo uso.");
        } else {
            System.out.println("O pet " + this.pet.getName() + " foi removido da máquina.");
        }
        this.pet = null;
    }

    public void cleanMachine() {
        if (this.isClean) {
            System.out.println("A máquina já está limpa.");
            return;
        }

        if (this.water < 10) {
            System.out.println("Não há água suficiente para limpar a máquina.");
            return;
        }

        if (this.shampoo < 2) {
            System.out.println("Não há shampoo suficiente para limpar a máquina.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        this.isClean = true;
        System.out.println("A máquina foi limpa.");
    }

}

