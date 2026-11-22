package com.trabalho.t2.dados;

import java.util.ArrayList;

public class CadastroPartido {
    private ArrayList<Partido> partidos;

    public CadastroPartido() {
        partidos = new ArrayList<>(10);
    }

    public String cadastrarPartido(String codigo, String nome) {
        try {
            if (nome == null || nome.trim().length() == 0)
                throw new IllegalArgumentException("Nome inválido.");

            int codigoInt = Integer.parseInt(codigo);
            if (partidoExiste(codigoInt))
                return "ERRO: Esse partido já existe.";

            Partido novoPartido = new Partido(codigoInt, nome);
            partidos.add(novoPartido);
            return "Partido criado com sucesso. ";
        } catch (NumberFormatException exception) {
            return codigo + " Não é um número.";
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }

    private boolean partidoExiste(int codigo) {
        for (Partido p : partidos) {
            if (codigo == p.getCodigo())
                return true;
        }
        return false;
    }
}
