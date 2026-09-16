package model;

/**
 * Representa os tipos de impostos aplicados às atividades do MEI,
 * que são: ICMS, ISS, ICMS + ISS ou apenas INSS. 
 * 
 * @author Elane
 */

public enum Imposto {
    //valor fixo e descricao
    ICMS (1.00, "ICMS"),
    ISS (5.00, "ISS"),
    ICMS_ISS(6.00, "ICMS + ISS"),
    NENHUM (0.00, "Sem incidência de ISS/ICMS. Somente contribuição previdenciária");


public static final double SALARIO_MINIMO = 1621.00;
   
    private static final double ALIQ_INSS = 0.05;

    private final double vlrFixo;
    private final String descricao;

    Imposto(double vlrFixo, String descricao) {
        this.vlrFixo = vlrFixo;
        this.descricao = descricao;
    }

    public double getVlrFixo() {
        return vlrFixo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double calculoDAS(double salarioMinimo) {
        return (salarioMinimo * ALIQ_INSS) + vlrFixo;
    }

    public double calculoDAS() {
        return calculoDAS(SALARIO_MINIMO);
    }

    @Override
    public String toString() {
        return descricao;
    }
}