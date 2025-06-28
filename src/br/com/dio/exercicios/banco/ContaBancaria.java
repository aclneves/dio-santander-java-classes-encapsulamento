package br.com.dio.exercicios.banco;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.*;

public class ContaBancaria {
    private BigDecimal saldo;
    private BigDecimal limite;
    private BigDecimal limite_utilizado;

    public ContaBancaria(double saldo) {
        this.saldo = valueOf(saldo).setScale(2, RoundingMode.HALF_EVEN);
        if (saldo < 500) {
            this.limite = valueOf(50).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            this.limite = valueOf(saldo * 0.5).setScale(2, RoundingMode.HALF_EVEN);
        }
        this.limite_utilizado = ZERO.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getLimite_utilizado() {
        return limite_utilizado;
    }

    public void setLimite_utilizado(BigDecimal limite_utilizado) {
        this.limite_utilizado = limite_utilizado;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("---------------------------------------");
        consultarLimite();
        System.out.println("---------------------------------------");
        System.out.println("Total disponível: " + (calcularLimiteDisponivel().add(this.saldo)));
    }

    public BigDecimal calcularLimiteDisponivel() {
        return this.limite.subtract(limite_utilizado);
    }

    public void consultarLimite() {
        System.out.println("Limite contratado: " + this.limite);
        System.out.println("Limite disponível: " + (this.limite.subtract(this.limite_utilizado)));
        System.out.println("Limite utilizado: " + this.limite_utilizado);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor não pode ser menor ou igual a zero");
        }
        if (limite_utilizado.compareTo(ZERO) > 0) {
            if (limite_utilizado.compareTo(valueOf(valor)) >= 0) {
                limite_utilizado = limite_utilizado.subtract(valueOf(valor));
            } else {
                this.saldo = this.saldo.add(valueOf(valor).subtract(limite_utilizado));
                limite_utilizado = ZERO;
            }
        } else {
            this.saldo = this.saldo.add(valueOf(valor));
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor não pode ser menor ou igual a zero");
        }
        if (this.saldo.compareTo(valueOf(valor)) < 0) {
            if (totalDisponivel().compareTo(valueOf(valor)) < 0) {
                throw new IllegalArgumentException("Valor maior que o saldo disponível");
            } else {
                System.out.println("Esta operação utiliza o limite disponível");
                System.out.println("Os juros da utilização do limite serão aplicados");
                this.limite_utilizado = this.limite_utilizado.subtract(this.saldo.subtract(valueOf(valor)))
                        .setScale(2, RoundingMode.HALF_EVEN);
                this.limite_utilizado = this.limite_utilizado.add(calculaJurosLimite(limite_utilizado))
                        .setScale(2, RoundingMode.HALF_EVEN);
                this.saldo = ZERO;
            }
        } else {
            this.saldo = this.saldo.subtract(valueOf(valor));
        }
    }

    public void pagarBoleto(double valor) {
        sacar(valor);
    }


    public BigDecimal totalDisponivel() {
        return this.limite.add(this.saldo);
    }

    public BigDecimal calculaJurosLimite(BigDecimal valorUtilizado) {
        return valorUtilizado.multiply(valueOf(0.2));
    }

}
