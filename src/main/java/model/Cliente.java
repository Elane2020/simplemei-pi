package model;

/**
 * Entidade que representa um cliente no sistema.
 * Possui dados como tipo, nome, cnpj, ie, endereço e contatos.
 *
 * @author Elane
 */
public class Cliente extends PessoaJuridica {

    private int idCliente;
    private String nomeCliente;
    private String tipoCliente; 

      public Cliente() {
        super();
    }
      
     public Cliente(String nomeCliente, String tipoCliente, String numCNPJ,
        String numIE, Endereco endereco, String email, String telefone, String responsavel) {
    
        super(nomeCliente, numCNPJ, numIE, null, endereco, email, telefone, responsavel);
        
        this.nomeCliente = nomeCliente;
        this.tipoCliente = tipoCliente;
    
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
   