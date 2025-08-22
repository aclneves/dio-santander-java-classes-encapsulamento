package br.com.dio.exercicios.carro;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem vindo ao sistema de controle de carros");
        System.out.println("Vamos cadastar um carro");

        Carro carro = criarCarro();

        int option = -1;

        do {
            System.out.println("===Menu do carro===");
            System.out.println("===Escolha uma das opções: ===");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar o carro");
            System.out.println("4 - Frear o carro");
            System.out.println("5 - Virar para direita");
            System.out.println("6 - Virar para esquerda");
            System.out.println("7 - Verificar a velocidade do carro");
            System.out.println("8 - Trocar de marcha");
            System.out.println("0 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> carro.ligarCarro();
                case 2 -> carro.desligarCarro();
                case 3 -> carro.acelerar();
                case 4 -> carro.frear();
                case 5 -> carro.virarParaDireita();
                case 6 -> carro.virarParaEsquerda();
                case 7 -> System.out.println("A velocidade atual é de " + carro.getVelocidade() + "km/h.");
                case 8 -> gerenciarMarcha(carro);
            }
        } while (option != 0);
    }

    private static Carro criarCarro() {
        System.out.println("Digite o modelo do carro: ");
        String modelo = scanner.nextLine().trim();

        System.out.println("Digite a fabricante do carro");
        String fabricante = scanner.nextLine().trim();

        return new Carro(modelo, fabricante);
    }

    private static void gerenciarMarcha(Carro carro) {
        System.out.println("--- Controle de Marcha ---");
        System.out.println("1 - Subir marcha");
        System.out.println("2 - Reduzir marcha");
        System.out.println("0 - Voltar ao menu principal");
        int subOption = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (subOption) {
            case 1 -> carro.subirMarcha();
            case 2 -> carro.reduzirMarcha();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
        }
    }



}