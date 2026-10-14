package com.poo.atividade_refac.discounts;

import com.poo.atividade_refac.entities.Livro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountCalculator {
    private final List<IDiscountTemplate> descontos;

    public DiscountCalculator(List<IDiscountTemplate> descontos) {
        this.descontos = descontos;
    }

    public double aplicar(Livro livro) {
        for (IDiscountTemplate d : descontos) {
            if (d.aplicaA(livro.getCategoria())) {
                return d.aplicar(livro.getPreco());
            }
        }
        return livro.getPreco();
    }

}
