package com.poo.atividade_refac.discounts;

import org.springframework.stereotype.Component;

@Component
public class DiscountHQ implements IDiscountTemplate{
    public boolean aplicaA(String categoria) {
        return "HQ".equals(categoria);
    }

    @Override
    public double aplicar(double preco) {
        return preco * 0.6;
    }
}
