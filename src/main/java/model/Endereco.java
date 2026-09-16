
package model;

/**
 * Entidade que representa um endereço.
 * Possui informações como logradouro, bairro, cidade, estado e CEP.
 *
 * @author Elane
 */

public class Endereco {
    
    private String logradouro;
    private String bairro;
    private String cidade;
    private String complemento;
    private String estado;
    private String cep;
   
    public Endereco() {
    }
    
    
    public Endereco (String logradouro, String bairro,
        String cidade, String complemento, String estado,String cep){
        
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
       
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

   
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Override
    public String toString() {
    return logradouro + ", " + " - " + bairro + " - " + complemento + " - " + cidade + "/" + estado + 
            " - CEP: " + cep + " - ";
}
}
