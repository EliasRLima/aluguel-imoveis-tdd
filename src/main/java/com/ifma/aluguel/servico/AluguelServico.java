package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.exception.MessageProperties;
import com.ifma.aluguel.repositorio.AluguelRepository;
import com.ifma.aluguel.repositorio.implementacoes.AluguelRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;

public class AluguelServico {

    private AluguelRepository aluguelRepository;

    public AluguelServico(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public AluguelServico() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseTest");
        this.aluguelRepository = new AluguelRepositoryImpl(emf.createEntityManager());
    }

    public Aluguel buscarPorId(Integer idAluguel){
        return aluguelRepository.getById(idAluguel);
    }

    public List<Aluguel> buscarAlugueisPorModelo(Aluguel aluguelBase){
        return aluguelRepository.getAlugueisByCriterios(aluguelBase);
    }

    public boolean salvarAluguel(Aluguel aluguel){
        Aluguel aluguelJaExiste = buscarPorId(aluguel.getIdAluguel());
        if(Objects.nonNull(aluguelJaExiste)){
            throw new AluguelException(
                    MessageProperties.getMensagemPadrao("erro.existe.aluguel"));
        }

        verificarValorPagoAluguelValido(aluguel);
        return aluguelRepository.salvarAluguel(aluguel);
    }

    public boolean atualizarAluguel(Aluguel aluguel){
        verificarValorPagoAluguelValido(aluguel);

        return aluguelRepository.atualizarAluguel(aluguel);
    }

    public boolean deletarAluguel(Aluguel aluguel){
        return aluguelRepository.deletarAluguel(aluguel);
    }

    public Double calculaValorDeveSerPago(){
        return 0.0;
    }

    public void verificarValorPagoAluguelValido(Aluguel aluguel){
        Locacao locacao = aluguelRepository.buscarLocacaoDoAluguel(aluguel);
        if(Objects.nonNull(locacao))
            if(locacao.getValorAluguel() > aluguel.getValorPago()){
                throw new AluguelException(
                    MessageProperties.getMensagemPadrao("erro.valor_pago.invalido"));
        }
    }
}
