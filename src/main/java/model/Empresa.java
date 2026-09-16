
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa a empresa MEI cadastrada no sistema.
 * Herda {@link PessoaJuridica} e possui outros atributos específicos do MEI.
 * 
 * @author Elane
 */
public class Empresa extends PessoaJuridica {

    private List<Atividade> atividades;
    private Endereco enderecoComercial;
    private String ano;
    private String dataAbertura;
    private String cpf;
            
    public Empresa(String razaoSocial, String numCNPJ, String dataAbertura, String numIE, String numIM,
            Endereco endereco, String responsavel, String cpf, String numTelefone, String email)
    {
        super(razaoSocial, numCNPJ, numIE, numIM,
              endereco, email, numTelefone, responsavel);

        this.atividades = new ArrayList<>();
        this.dataAbertura = dataAbertura;
        this.cpf = cpf;
    }

    public Empresa(String razaoSocial, String numCNPJ, String dataAbertura, String numIE, String numIM,
           Endereco endereco, List<Atividade> atividades, String responsavel, String cpf,
            String telefone, String email) {

        super(razaoSocial, numCNPJ, numIE, numIM,
              endereco, email, telefone, responsavel);

        this.atividades = atividades;
        this.dataAbertura = dataAbertura;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void addAtividade(Atividade atividade) {
        if (atividade == null) {
            return;
        }

        if (!atividades.contains(atividade)) {
            atividades.add(atividade);
        }
    }

    public boolean removerAtividade(Atividade atividade) {
        return atividades.remove(atividade);
    }

    public Endereco getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(Endereco enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}

