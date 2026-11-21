package com.trabalho.t2.dados;

public class Governador extends Candidato {
    private String escolaridade;

    public Governador(int numero, String nome, String escolaridade) {
        super(numero, nome);
        this.escolaridade = escolaridade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    @Override
    public String getDescricao() {
        return getNome() + " - " + getNumero() + " - " + getSituacao() + " - " + getEscolaridade();
    }
}