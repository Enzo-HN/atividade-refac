package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.ILivroReportGenerator;
import com.poo.atividade_refac.entities.Livro;
import com.poo.atividade_refac.repositories.IJPALivroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService implements ILivroReportGenerator {

    @Autowired
    private IJPALivroRepo livroRepo;

    @Override
    public void gerarRelatorio() {

        List<Livro> livros =
                livroRepo.findAll();

        System.out.println(
                "Quantidade de livros: "
                        + livros.size());
    }

    @Override
    public void exportarPdf() {

        throw new UnsupportedOperationException(
                "Não implementado");
    }
}
