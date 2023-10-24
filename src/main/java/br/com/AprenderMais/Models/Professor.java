package br.com.AprenderMais.Models;

public class Professor extends ModeloUsuario{
    private String areaDeAtuacao;
    private String nivelFormacao;
    private String bibliografia;
    
    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }
    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }
    public String getNivelFormacao() {
        return nivelFormacao;
    }
    public void setNivelFormacao(String nivelFormacao) {
        this.nivelFormacao = nivelFormacao;
    }
    public String getBibliografia() {
        return bibliografia;
    }
    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
}
