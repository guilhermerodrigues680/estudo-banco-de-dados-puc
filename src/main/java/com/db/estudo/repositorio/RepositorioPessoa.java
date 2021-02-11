package com.db.estudo.repositorio;

import com.db.estudo.model.Pessoa;

import java.util.List;

public interface RepositorioPessoa {

    void cadastrarPessoa(String nome, int idade) throws RepositorioGenericException;
    List<Pessoa> buscarTodasPessoas() throws RepositorioGenericException;

}
