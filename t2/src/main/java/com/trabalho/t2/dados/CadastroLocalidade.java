package com.trabalho.t2.dados;

import java.util.ArrayList;

import com.trabalho.t2.exceptions.*;

public class CadastroLocalidade {
    private ArrayList<Localidade> localidades;

    public CadastroLocalidade() {
        localidades = new ArrayList<>(10);
    }

    public String cadastrarLocalidade(String qtdEleitores, String cep, String nome, String tipo) {
        String dadosValidos = validadorDados(qtdEleitores, cep, nome, tipo);
        if (dadosValidos != null)
            return dadosValidos;

        TipoLocalidade t = TipoLocalidade.valueOf(tipo.toUpperCase());
        long qtdEleitoresLong = Long.parseLong(qtdEleitores);

        Localidade novoLocalidade = new Localidade(qtdEleitoresLong, cep, nome, t);
        localidades.add(novoLocalidade);
        return "Localidade criada com sucesso.";
    }

    private String validadorDados(String qtdEleitores, String cep, String nome, String tipo) {
        try {
            if (nome == null || nome.trim().length() == 0)
                throw new IllegalArgumentException("Nome inválido.");

            if (cep == null || cep.trim().length() != 8)
                throw new IllegalArgumentException("O cep precisa ter 8 dígitos.");

            if (LocalidadeExiste(cep))
                throw new DadosRepetidosException("Essa Localidade já existe.");

            if (tipo == null)
                throw new IllegalArgumentException("O tipo não pode ser nulo");

            if (qtdEleitores == null || Long.parseLong(qtdEleitores) < 0)
                throw new IllegalArgumentException("A quantidade de eleitores não pode ser nula nem negativa");

            if (!tipo.toUpperCase().equals("MUNICIPAL") &&
                    !tipo.toUpperCase().equals("ESTADUAL") &&
                    !tipo.toUpperCase().equals("NACIONAL"))
                throw new IllegalArgumentException("Esse tipo não está registrado no sistema.");
            return null;
        } catch (NumberFormatException exception) {
            return qtdEleitores + " Não é um número.";
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        } catch (DadosRepetidosException exception) {
            return exception.getMessage();
        }
    }

    private boolean LocalidadeExiste(String cep) {
        for (Localidade l : localidades) {
            if (cep == l.getCep())
                return true;
        }
        return false;
    }
}
