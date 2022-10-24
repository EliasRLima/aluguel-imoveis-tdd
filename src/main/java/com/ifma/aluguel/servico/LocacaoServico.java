package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.repositorio.LocacaoRepository;
import com.ifma.aluguel.repositorio.implementacoes.LocacaoRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class LocacaoServico {

    private LocacaoRepository locacaoRepository;

    public LocacaoServico(LocacaoRepository locacaoRepository) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        this.locacaoRepository = new LocacaoRepositoryImpl(emf.createEntityManager());
    }

    public Double calculaValorDeveSerPago(Integer idLocacao) {
        Locacao locacao = locacaoRepository.getById(idLocacao);
        int diasAtraso = LocalDateTime.now().compareTo(locacao.getDataFim());
        double multa = 0;
        double valorAluguel = locacao.getValorAluguel();

        if(diasAtraso > 0){
            multa = 0.33 * diasAtraso;
            if(multa > valorAluguel*0.8){
                multa = valorAluguel*0.8;
            }
        }

        return valorAluguel + multa;
    }
}
