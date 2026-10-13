package com.poo.atividade_refac.contracts;

import com.poo.atividade_refac.entities.Livro;

import java.util.List;

public interface ILivrosServiceOperations {

    List<Livro> listarLivros();

    Livro cadastrarLivros(Livro livro);

    Livro atualizarLivros(Long id, Livro livro);

    void deletarLivros(Long id);
}
