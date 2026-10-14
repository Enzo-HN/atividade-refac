package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.ILivroLabelGenerator;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaService implements ILivroLabelGenerator {

    @Override
    public void gerarEtiqueta() {

        throw new UnsupportedOperationException(
                "Não implementado");
    }
}
