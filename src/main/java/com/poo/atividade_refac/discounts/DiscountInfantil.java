package com.poo.atividade_refac.discounts;

import org.springframework.stereotype.Component;

@Component
public class DiscountInfantil implements IDiscountTemplate{
    public boolean aplicaA(String categoria) {
        return "INFANTIL".equals(categoria);
    }

    @Override
    public double aplicar(double preco) {
        return preco * 0.7;
    }
}
