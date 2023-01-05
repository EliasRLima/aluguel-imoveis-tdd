package com.ifma.aluguel.mocks.Locacao;

import com.ifma.aluguel.entidade.Locacao;

import java.time.LocalDateTime;

public class LocacaoObjTest {

    public Locacao getLocacaoTest(){
        Locacao locacao = new Locacao();
        locacao.setDataInicio(LocalDateTime.now());
        locacao.setDataFim(LocalDateTime.now().plusDays(30));
        locacao.setValorAluguel(1200.0);
        return locacao;
    }

    public Locacao getLocacaoAtrasadaTest(){
        Locacao locacao = new Locacao();
        locacao.setDataInicio(LocalDateTime.now().minusDays(65));
        locacao.setDataFim(LocalDateTime.now().minusDays(30));
        locacao.setValorAluguel(1400.0);
        return locacao;
    }
}
