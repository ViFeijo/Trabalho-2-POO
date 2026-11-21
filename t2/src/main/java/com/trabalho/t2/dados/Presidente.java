package com.trabalho.t2.dados;

public class Presidente extends Candidato {
    private double patrimonio;

    public Presidente(int numero, String nome, double patrimonio) {
        super(numero, nome);
        this.patrimonio = patrimonio;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    @Override
    public String getDescricao() {
        return getNome() + " - " + getNumero() + " - " + getSituacao() + " - " + getPatrimonio();
    }
}