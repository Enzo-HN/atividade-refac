package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.ILivrosServiceOperations;
import com.poo.atividade_refac.entities.Livro;
import com.poo.atividade_refac.repositories.IJPALivroRepo;
import com.poo.atividade_refac.validations.LivrosValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService implements ILivrosServiceOperations {

    @Autowired
    private IJPALivroRepo livroRepo;
    @Autowired
    private LivrosValidation validarLivro;

    @Override
    public List<Livro> listarLivros() {
        return livroRepo.findAll();
    }

    @Override
    public Livro cadastrarLivros(Livro livro){
        validarLivro.validar(livro);
        livroRepo.save(livro);
        return livro;

    }
    @Override
    public Livro atualizarLivros(Long id, Livro livro){
        validarLivro.validar(livro);
        Optional<Livro> livroAtualizado = livroRepo.findById(id);
        if(livroAtualizado.isPresent()){
            livroAtualizado.get().setTitulo(livro.getTitulo());
            livroAtualizado.get().setAutor(livro.getAutor());
            livroAtualizado.get().setPreco(livro.getPreco());
            livroAtualizado.get().setCategoria(livro.getCategoria());
            livroRepo.save(livroAtualizado.get());
        }
        return livroAtualizado.get();
    }
    @Override
    public void deletarLivros(Long id){
        Livro livroDeletado = livroRepo.findById(id).orElseThrow();

        if ("RARO".equals(livroDeletado.getCategoria())) {
            throw new RuntimeException("Livros raros não podem ser removidos");
        }
        else {
            livroRepo.delete(livroDeletado);
        }
    }


}
