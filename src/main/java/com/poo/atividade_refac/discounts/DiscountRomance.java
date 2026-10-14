package com.poo.atividade_refac.discounts;

import org.springframework.stereotype.Component;

@Component
public class DiscountRomance implements IDiscountTemplate {
    @Override
    public boolean aplicaA(String categoria) {
        return "ROMANCE".equals(categoria);
    }

    @Override
    public double aplicar(double preco) {
        return preco * 0.9;
    }
}
