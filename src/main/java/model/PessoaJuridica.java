package model;

/**
 * Superclasse para dados de pessoas jurídicas.
 * 
 * @author Elane
 */

public abstract class PessoaJuridica {
    
    protected String razaoSocial;
    protected String numCNPJ;
    protected String numIE;
    protected String numIM;
    protected Endereco endereco;
    protected String email;
    protected String telefone;
    protected String responsavel;

      public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, String numCNPJ, String numIE, String numIM, Endereco endereco, 
            String email, String telefone, String responsavel) {
        this.razaoSocial = razaoSocial;
        this.numCNPJ = numCNPJ;
        this.numIE = numIE;
        this.numIM = numIM;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.responsavel = responsavel;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getNumIM() {
        return numIM;
    }

    public void setNumIM(String numIM) {
        this.numIM = numIM;
    }

    public String getNumCNPJ(){
        return numCNPJ; 
    }
    public void setNumCNPJ(String numCNPJ) { 
        this.numCNPJ = numCNPJ;
    }

    public String getNumIE(){
        return numIE;
    }
    public void setNumIE(String numIE) {
        this.numIE = numIE; 
    }

     public Endereco getEndereco() { 
        return endereco;
    }
    public void setEndereco(Endereco endereco) { 
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email; 
    }

    public String getTelefone(){
        return telefone; 
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone; 
    }
}
