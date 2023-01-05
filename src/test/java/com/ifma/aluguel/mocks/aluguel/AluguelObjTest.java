package com.ifma.aluguel.mocks.aluguel;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.entidade.Locacao;

import java.time.LocalDateTime;

public class AluguelObjTest {

    public Aluguel getAluguelParaTest(){
        Aluguel aluguel = new Aluguel();
        aluguel.setIdLocacao(11);
        aluguel.setValorPago(1200.0);
        aluguel.setDataVencimento(LocalDateTime.now());
        aluguel.setDataPagamento(LocalDateTime.now().minusDays(2));
        return aluguel;
    }

    public Locacao getLocacaoDoAluguelParaTest(){
        Locacao locacao = new Locacao();
        locacao.setValorAluguel(2000.0);
        return locacao;
    }

}
