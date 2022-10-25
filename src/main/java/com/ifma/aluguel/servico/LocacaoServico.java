package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.exception.MessageProperties;
import com.ifma.aluguel.repositorio.LocacaoRepository;
import com.ifma.aluguel.repositorio.implementacoes.LocacaoRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class LocacaoServico {

    private LocacaoRepository locacaoRepository;

    public LocacaoServico() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        this.locacaoRepository = new LocacaoRepositoryImpl(emf.createEntityManager());
    }

    public LocacaoServico(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public Double calculaValorDeveSerPago(Integer idLocacao) {
        Locacao locacao = locacaoRepository.getById(idLocacao);
        long diasAtraso = DAYS.between(locacao.getDataFim(), LocalDateTime.now());
        double multa = 0;
        double valorAluguel = locacao.getValorAluguel();

        if(diasAtraso > 0){
            multa = 0.33 * Integer.parseInt(diasAtraso+"");
            if(multa > valorAluguel*0.8){
                multa = valorAluguel*0.8;
            }
        }

        return valorAluguel + multa;
    }

    public Locacao getLocacaoById(Integer idLocacao){
        return locacaoRepository.getById(idLocacao);
    }

    public Locacao salvarLocacao(Locacao locacao){
        if(Objects.nonNull(locacao.getIdLocacao())){
            throw new AluguelException(
                    MessageProperties.getMensagemPadrao("erro.existe.locacao"));
        }

        return locacaoRepository.salvar(locacao);
    }

    public boolean atualizarLocacao(Locacao locacao){
        return locacaoRepository.atualizar(locacao);
    }

    public boolean deletarLocacao(Locacao locacao){
        return locacaoRepository.deletar(locacao);
    }

}
