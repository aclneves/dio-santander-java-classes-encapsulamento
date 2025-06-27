package br.com.dio.exercicios.petShop;

public class Pet {
    private final String name;
    private boolean isClean;

    public Pet(final String name) {
        this.name = name;
        this.isClean = false;
    }

    public String getName() {
        return name;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }
}
