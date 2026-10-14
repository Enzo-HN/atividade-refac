package com.poo.atividade_refac.validations;

import com.poo.atividade_refac.entities.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivrosValidation {
    public void validar(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("Título obrigatório");
        }
        if (livro.getPreco() == null || livro.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
    }
}
