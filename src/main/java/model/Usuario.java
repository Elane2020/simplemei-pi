package model;

/**
 * Classe que representa um usuário do sistema.
 * 
 * @author Elane
 */

public class Usuario {

    private int id;
    private String usuario;
    private String senha;
    private String tipo;
    private String email;
    private boolean primeiroAcesso = true;

    public Usuario() {
    }

    
    public Usuario(int id, String usuario, String senha, String tipo, String email) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(boolean primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }

    
}