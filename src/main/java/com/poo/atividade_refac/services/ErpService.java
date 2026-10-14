package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.ILivroErpSyncher;
import org.springframework.stereotype.Service;

@Service
public class ErpService implements ILivroErpSyncher
{
    @Override
    public void sincronizarComERP() {
        throw new UnsupportedOperationException(
                "Não implementado");
    }
}
