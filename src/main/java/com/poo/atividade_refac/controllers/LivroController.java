package com.poo.atividade_refac.controllers;

import com.poo.atividade_refac.contracts.ILivrosServiceOperations;
import com.poo.atividade_refac.entities.Livro;
import com.poo.atividade_refac.services.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final ILivrosServiceOperations livrosService;
    public LivroController(ILivrosServiceOperations livrosService) {
        this.livrosService = livrosService;
    }


    @GetMapping
    public List<Livro> listarLivros() {
        return livrosService.listarLivros();
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro){
        livrosService.cadastrarLivros(livro);
        return livro;
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        return livrosService.atualizarLivros(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livrosService.deletarLivros(id);
    }
}

