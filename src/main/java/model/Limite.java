package model;

/**
 * Entidade que representa o limite anual do MEI.
 *
 * @author Elane
 */

public class Limite {

    private String ano;
    private double limiteAnual;

    public Limite(String ano, double limiteAnual) {
        this.ano = ano;
        this.limiteAnual = limiteAnual;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getLimiteAnual() {
        return limiteAnual;
    }

    public void setLimiteAnual(double limiteAnual) {
        this.limiteAnual = limiteAnual;
    }

    public double getLimiteMensal() {
        return limiteAnual / 12;
    }

    public double getLimiteCompras() {
        return limiteAnual * 0.8;
    }
}