package com.poo.atividade_refac.discounts;

import org.springframework.stereotype.Component;

@Component
public class DiscountTecnologia implements IDiscountTemplate{
    public boolean aplicaA(String categoria) {
        return "TECNOLOGIA".equals(categoria);
    }

    @Override
    public double aplicar(double preco) {
        return preco * 0.8;
    }
}
