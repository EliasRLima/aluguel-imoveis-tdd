package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.repositorio.AluguelRepository;
import com.ifma.aluguel.repositorio.implementacoes.AluguelRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AluguelServico {

    private AluguelRepository aluguelRepository;

    public AluguelServico(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public AluguelServico() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aluguelManager");
        this.aluguelRepository = new AluguelRepositoryImpl(emf.createEntityManager());
    }

    public Aluguel buscarPorId(Integer idAluguel){
        return aluguelRepository.getById(idAluguel);
    }

    public List<Aluguel> buscarAlugueisPorModelo(Aluguel aluguelBase){
        return aluguelRepository.getAlugueisByCriterios(aluguelBase);
    }

    public boolean salvarAluguel(Aluguel aluguel){
        return aluguelRepository.salvarAluguel(aluguel);
    }

    public boolean atualizarAluguel(Aluguel aluguel){
        return aluguelRepository.atualizarAluguel(aluguel);
    }

    public boolean deletarAluguel(Aluguel aluguel){
        return aluguelRepository.deletarAluguel(aluguel);
    }

}
