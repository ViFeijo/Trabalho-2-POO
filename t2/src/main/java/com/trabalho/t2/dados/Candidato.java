package com.trabalho.t2.dados;

public class Candidato {
    private int numero;
    private String nome;
    private String situacao;

    public Candidato(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        situacao = "pré-candidato";
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return getNome() + " - " + getNumero() + " - " + getSituacao();
    }
}