package com.ifma.aluguel.repositorio.implementacoes;

import com.ifma.aluguel.entidade.Aluguel;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class AluguelRepositoryImpl implements com.ifma.aluguel.repositorio.AluguelRepository {

    private EntityManager manager;

    public AluguelRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Aluguel getById(Integer idAluguel) {
        List<Aluguel> listaRetorno = manager.createQuery("from aluguel a where i.idAluguel = :idAluguel", Aluguel.class)
                .setParameter("idAluguel", idAluguel)
                .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public List<Aluguel> getAlugueisByCriterios(Aluguel aluguelBase) {
        String jsql = "from aluguel a " +
                      "where a.dataVencimento = COALESCE (:dataVencimento,  a.dataVencimento)" +
                      "and a.valorPago = COALESCE (:valorPago, a.valorPago) " +
                      "and  a.dataPagamento = COALESCE (:dataPagamento, a.dataPagamento) " +
                      "and a.obs = COALESCE (:obs, a.obs)";

        return manager.createQuery(jsql, Aluguel.class)
                .setParameter("dataVencimento", aluguelBase.getDataVencimento())
                .setParameter("valorPagoo", aluguelBase.getValorPago())
                .setParameter("dataPagamento", aluguelBase.getDataPagamento())
                .setParameter("obs", aluguelBase.getObs())
                .getResultList();
    }

    @Override
    public boolean salvarAluguel(Aluguel aluguel) {
        manager.persist(aluguel);
        return true;
    }

    @Override
    public boolean atualizarAluguel(Aluguel aluguel) {
        manager.merge(aluguel);
        return true;
    }

    @Override
    public boolean deletarAluguel(Aluguel aluguel) {
        manager.merge(aluguel);
        return true;
    }
}
