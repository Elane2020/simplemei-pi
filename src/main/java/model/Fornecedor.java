package model;

/**
 * Entidade que representa um fornecedor no sistema.
 * Possui dados como tipo, nome, cnpj, ie, endereço e contatos.
 *
 * @author Elane
 */

public class Fornecedor extends PessoaJuridica {

    private int idFornecedor;
    private String razaoSocial;
    private String tipoFornecedor; 

     public Fornecedor() {
        super();
    }

    public Fornecedor(String razaoSocial, String tipoFornecedor, String numCNPJ, String numIE,
    Endereco endereco, String email, String telefone, String responsavel) {
        super(razaoSocial, numCNPJ, numIE, null, endereco, email, telefone, responsavel);
        this.razaoSocial = razaoSocial;
        this.tipoFornecedor = tipoFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
     public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    
    public String getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(String tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

   
   
}
