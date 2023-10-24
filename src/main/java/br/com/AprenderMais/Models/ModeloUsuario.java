package br.com.AprenderMais.Models;

public class ModeloUsuario {

    private String email;
    private String nomeUsuario;
    private String senha;
    private String numeroCelular;
    private int nivelAcesso;

    public int getNivelAcesso() {
        return nivelAcesso;
    }
    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nome) {
        this.nomeUsuario = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNumeroCelular() {
        return numeroCelular;
    }
    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }    
}
