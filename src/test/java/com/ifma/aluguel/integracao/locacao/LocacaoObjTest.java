package com.ifma.aluguel.integracao.locacao;

import com.ifma.aluguel.entidade.Locacao;

import java.time.LocalDateTime;

public class LocacaoObjTest {

    public Locacao getLocacaoNovoTest(){
        Locacao locacao = new Locacao();
        locacao.setValorAluguel(1000.0);
        locacao.setIdCliente(22);
        locacao.setIdImovel(11);
        locacao.setAtivo(true);
        return locacao;
    }

    public Locacao getLocacaoExistenteTest(){
        Locacao locacao = new Locacao();
        locacao.setIdLocacao(11);
        locacao.setValorAluguel(1200.0);
        return locacao;
    }
}
