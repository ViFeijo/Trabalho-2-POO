package com.trabalho.t2.dados;

import java.util.ArrayList;

import com.trabalho.t2.exceptions.DadosRepetidosException;

public class CadastroPartido {
    private ArrayList<Partido> partidos;

    public CadastroPartido() {
        partidos = new ArrayList<>(10);
    }

    public String cadastrarPartido(String codigo, String nome) {
        String dadosValidos = validadorDados(codigo, nome);
        if (dadosValidos != null)
            return dadosValidos;

        int codigoInt = Integer.parseInt(codigo);

        Partido novoPartido = new Partido(codigoInt, nome);
        partidos.add(novoPartido);
        return "Partido criado com sucesso. ";

    }

    private String validadorDados(String codigo, String nome) {
        try {
            if (nome == null || nome.trim().length() == 0)
                throw new IllegalArgumentException("Nome inválido.");

            int codigoInt = Integer.parseInt(codigo);
            if (codigoInt <= 0)
                throw new IllegalArgumentException("O número precisa ser maior que 0.");
            if (partidoExiste(codigoInt))
                throw new DadosRepetidosException("Esse partido já existe.");
            return null;
        } catch (NumberFormatException exception) {
            return codigo + " Não é um número válido.";
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        } catch (DadosRepetidosException exception) {
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
