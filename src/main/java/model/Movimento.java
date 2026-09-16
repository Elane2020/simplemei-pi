package model;

/**
 * Entidade que representa o tipo de movimento realizado.
 *
 * @author Elane
 */

public enum Movimento {
    RECEITA ("Receita"),
    DESPESA ("Despesa"),
    COMPRAS ("Compra"),
    CUSTOS ("Custo");
    
    private String descricao;
        Movimento(String descricao) {
        this.descricao = descricao;
        }
        
    @Override
    public String toString() {
    return descricao; 
    
    }
}
