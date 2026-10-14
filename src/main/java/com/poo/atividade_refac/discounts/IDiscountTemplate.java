package com.poo.atividade_refac.discounts;

public interface IDiscountTemplate {
    boolean aplicaA(String categoria);
    double aplicar(double preco);

}
