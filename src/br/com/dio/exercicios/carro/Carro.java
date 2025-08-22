package br.com.dio.exercicios.carro;

public class Carro {

    private String modelo;
    private String fabricante;
    private int velocidade;
    private int marcha;
    private boolean isLigado;
    private final int VELOCIDADE_MAXIMA = 120;

    public Carro(String modelo, String fabricante) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.velocidade = 0;
        this.marcha = 0;
        this.isLigado = false;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public boolean isLigado() {
        return isLigado;
    }

    public void setLigado(boolean ligado) {
        isLigado = ligado;
    }

    public void ligarCarro() {
        if (!this.isLigado) {
            this.isLigado = true;
            System.out.println("O carro foi ligado.");
            return;
        }
        System.out.println("O carro já está ligado.");
    }

    public void desligarCarro() {
        if (!this.isLigado) {
            System.out.println("O carro já está desligado");
            return;
        }
        if (this.velocidade > 0 || this.marcha != 0) {
            System.out.println("Impossível desligar. O carro precisa estar parado e em ponto morto.");
        } else {
            this.isLigado = false;
            System.out.println("O carro foi desligado.");
        }
    }

    public void acelerar() {

        if (!this.isLigado) {
            System.out.println("Impossível acelerar o carro. O carro precisa estar ligado.");
            return;
        }

        if (this.velocidade >= VELOCIDADE_MAXIMA) {
            System.out.println("Impossível acelerar, o carro está em velocidade máxima de " + VELOCIDADE_MAXIMA + "km" +
                    "/h.");
            return;
        }
        if (this.marcha == 0) {
            System.out.println("O carro está em ponto morto, favor engatar a primeira marcha.");
            return;
        }

        int velocidadeMaximaDaMarcha = getVelocidadeLimiteMarcha(this.marcha);

        if (this.velocidade >= velocidadeMaximaDaMarcha) {
            System.out.println("Velocidade máxima para a " + this.marcha + " marcha atingida. Favor trocar de marcha " +
                    "para acelerar mais.");
        } else {
            this.velocidade += 1; // Requisito: incrementar 1km/h
            if (this.velocidade > velocidadeMaximaDaMarcha) {
                this.velocidade = velocidadeMaximaDaMarcha;
            }
            System.out.println("Acelerando o carro...");
            System.out.println("Velocidade atual: " + this.velocidade + " km/h");
        }
    }

    public void frear() {
        if (!this.isLigado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (this.velocidade <= 0) {
            System.out.println("O carro está parado.");
            return;
        } else {
            this.velocidade -= 1; // Requisito: decrementar 1km/h
            if (this.velocidade < 0) {
                this.velocidade = 0;
            }
            System.out.println("Freando o carro...");
            System.out.println("Velocidade atual: " + this.velocidade + " km/h");
        }
    }

    public void subirMarcha() {
        if (!this.isLigado) {
            System.out.println("O carro precisa estar ligado para subir a marcha.");
            return;
        }

        if (this.marcha == 6) {
            System.out.println("O carro já está na 6ª marcha (máxima).");
            return;
        }

        int velocidadeMinimaParaTrocaMarcha = getVelocidadeLimiteMarcha(this.marcha);
        // Usar >= torna a troca mais flexível e realista
        if (this.velocidade >= velocidadeMinimaParaTrocaMarcha) {
            this.marcha++;
            System.out.println("Marcha alterada para " + this.marcha + "ª.");
        } else {
            System.out.println("Velocidade incompatível. Acelere até " + velocidadeMinimaParaTrocaMarcha + " km/h para subir de marcha.");
        }


    }

    public void reduzirMarcha() {
        if (!this.isLigado) {
            System.out.println("O carro precisa estar ligado para reduzir a marcha.");
            return;
        }
        if (this.marcha == 0) {
            System.out.println("O carro está em ponto morto, impossível reduzir a marcha.");
            return;
        }
        int velocidadeMaximaParaMarchaAnterior = getVelocidadeLimiteMarcha(this.marcha - 1);
        if (this.velocidade <= velocidadeMaximaParaMarchaAnterior) {
            this.marcha--;
            System.out.println("Marcha alterada para: " + (this.marcha == 0 ? "Ponto Morto" : this.marcha + "ª"));
        } else {
            System.out.println("Velocidade incompatível. Reduza para " + velocidadeMaximaParaMarchaAnterior + "km" +
                    "/h ou menos para descer de marcha.");
        }
    }

    public void virarParaDireita() {
        if (!this.isLigado) {
            System.out.println("O carro precisa estar ligado para virar");
            return;
        }

        if (this.velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virando para direita...");
        } else {
            System.out.println("Impossível virar, velocidade incompatível (deve ser entre 1 e 40 km/h).");
        }
    }

    public void virarParaEsquerda() {
        if (!this.isLigado) {
            System.out.println("O carro precisa estar ligado para virar");
            return;
        }

        if (this.velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virando para esquerda...");
        } else {
            System.out.println("Impossível virar, velocidade incompatível (deve ser entre 1 e 40 km/h).");
        }
    }


    private int getVelocidadeLimiteMarcha(int marcha) {
        return switch (marcha) {
            case 1 -> 20;
            case 2 -> 40;
            case 3 -> 60;
            case 4 -> 80;
            case 5 -> 100;
            case 6 -> VELOCIDADE_MAXIMA;
            default -> 0;
        };
    }
}
