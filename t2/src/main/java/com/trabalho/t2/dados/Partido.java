package com.trabalho.t2.dados;

import java.util.ArrayList;

public class Partido {
    private int codigo;
    private String nome;
    private ArrayList<Candidato> candidatos;

    public Partido(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        candidatos = new ArrayList<Candidato>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }
}
