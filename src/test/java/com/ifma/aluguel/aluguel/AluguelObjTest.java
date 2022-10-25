package com.ifma.aluguel.aluguel;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.repositorio.AluguelRepository;

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

    public Aluguel getNovoAluguelParaTest(){
        Aluguel aluguel = new Aluguel();
        aluguel.setIdLocacao(1);
        aluguel.setValorPago(1200.0);
        aluguel.setDataVencimento(LocalDateTime.now());
        aluguel.setDataPagamento(LocalDateTime.now().minusDays(2));
        return aluguel;
    }

    public Aluguel getAluguelNoBancoParaTest(){
        Aluguel aluguel = new Aluguel();
        aluguel.setIdAluguel(11);
        aluguel.setIdLocacao(1);
        aluguel.setValorPago(1200.0);
        aluguel.setDataVencimento(LocalDateTime.now());
        aluguel.setDataPagamento(LocalDateTime.now().minusDays(2));
        return aluguel;
    }

    public Aluguel getAluguelPagamentoInvalidoParaTest(){
        Aluguel aluguel = new Aluguel();
        aluguel.setIdAluguel(1);
        aluguel.setIdLocacao(11);
        aluguel.setValorPago(800.0);
        aluguel.setDataVencimento(LocalDateTime.now());
        aluguel.setDataPagamento(LocalDateTime.now().minusDays(2));
        return aluguel;
    }

}
