package br.com.dio.exercicios.banco;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Criando conta bancária

        System.out.println("Bem vindo");
        ContaBancaria contaBancaria = criarConta();


        int option;
        do {
            System.out.println("===Escolha uma das opções: ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar limite disponível");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> contaBancaria.consultarSaldo();
                case 2 -> contaBancaria.consultarLimite();
                case 3 -> depositarNaConta(contaBancaria);
                case 4 -> sacarDinheiro(contaBancaria);
                case 5 -> pagarBoleto(contaBancaria);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    public static ContaBancaria criarConta() {
        System.out.println("Para criação da sua conta bancária, digite o valor que deseja depositar: ");

        while (true) {
            try {
                double depositoInicial = scanner.nextDouble();
                ContaBancaria conta = new ContaBancaria(depositoInicial);
                System.out.println("Conta criada com sucesso!");
                System.out.println("---------------------------------------");
                conta.consultarSaldo();
                return conta;
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
                System.out.println("Digite um valor válido (maior que zero): ");
            }
        }
    }


    public static void depositarNaConta(ContaBancaria contaBancaria) {
        System.out.println("Digite o valor que deseja depositar: ");
        double valorDeposito = scanner.nextDouble();
        System.out.println("Processando depósito...");
        try {
            contaBancaria.depositar(valorDeposito);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Deposito realizado com sucesso!");
        System.out.println("---------------------------------------");
        contaBancaria.consultarSaldo();
    }

    public static void sacarDinheiro(ContaBancaria contaBancaria) {
        System.out.println("Digite o valor que deseja sacar: ");
        double valorSaque = scanner.nextDouble();
        System.out.println("Processando saque...");
        try {
            contaBancaria.sacar(valorSaque);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Saque realizado com sucesso!");
        System.out.println("---------------------------------------");
        contaBancaria.consultarSaldo();
    }

    public static void pagarBoleto(ContaBancaria contaBancaria) {
        System.out.println("Digite o valor do boleto: ");
        double valorBoleto = scanner.nextDouble();
        System.out.println("Processando pagamento...");
        try {
            contaBancaria.pagarBoleto(valorBoleto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Boleto pago com sucesso!");
        System.out.println("---------------------------------------");
        contaBancaria.consultarSaldo();
    }
}
