package model;

import java.time.LocalDateTime;

/**
 * Representa um pedido de cadastro feito por alguém sem login.
 * o gerente será notificado via e-mail ou na tela do sistema.
 * @author Elane
 */
public class SolicitacaoCadastro {

    private final int id;
    private final String nome;
    private final String email;
    private final LocalDateTime dataSolicitacao;
    

    public SolicitacaoCadastro(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataSolicitacao = LocalDateTime.now();
        
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    

}
