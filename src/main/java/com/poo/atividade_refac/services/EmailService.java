package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.ILivroMailer;

public class EmailService implements ILivroMailer {
    @Override
    public void enviarEmailPromocional() {
        System.out.println("Email promocional");
    }

}
