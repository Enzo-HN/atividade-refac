package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.ILivrosServiceOperations;
import com.poo.atividade_refac.discounts.DiscountCalculator;
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
    @Autowired
    private DiscountCalculator calculadoraDesconto;

    @Override
    public List<Livro> listarLivros() {
        return livroRepo.findAll();
    }

    @Override
    public Livro cadastrarLivros(Livro livro){
        validarLivro.validar(livro);
        livro.setPreco(calculadoraDesconto.aplicar(livro));
        livroRepo.save(livro);
        return livro;

    }
    @Override
    public Livro atualizarLivros(Long id, Livro livro) {
        validarLivro.validar(livro);
        Livro existente = livroRepo.findById(id).orElseThrow();
        existente.setTitulo(livro.getTitulo());
        existente.setAutor(livro.getAutor());
        existente.setPreco(livro.getPreco());
        existente.setCategoria(livro.getCategoria());
        return livroRepo.save(existente);
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
