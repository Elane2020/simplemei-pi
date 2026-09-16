
package model;

/**
 * Entidade que representa uma atividade permitida ao MEI.
 * Possui dados como CNAE, ocupação, descrição e tipo de imposto.
 *
 * @author Elane
 */

public class Atividade {
      
    private String cnae;
    private String ocupacao;
    private String descCNAE;
    private Imposto tipoImposto;
    
    public Atividade (String cnae, String ocupacao, String descCNAE, Imposto tipoImposto) {
        
        this.cnae = cnae;
        this.ocupacao = ocupacao;
        this.descCNAE = descCNAE;
        this.tipoImposto = tipoImposto;
        
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getDescCNAE() {
        return descCNAE;
    }

    public void setDescCNAE(String descCNAE) {
        this.descCNAE = descCNAE;
    }

    public Imposto getTipoImposto() {
        return tipoImposto;
    }

    public void setTipoImposto(Imposto tipoImposto) {
        this.tipoImposto = tipoImposto;
    }

   
}
