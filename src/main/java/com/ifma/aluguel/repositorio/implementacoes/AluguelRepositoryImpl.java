package com.ifma.aluguel.repositorio.implementacoes;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.entidade.Locacao;

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
        List<Aluguel> listaRetorno = manager.createQuery("from Aluguel a where a.idAluguel = :idAluguel", Aluguel.class)
                .setParameter("idAluguel", idAluguel)
                .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public Locacao buscarLocacaoDoAluguel(Aluguel aluguel) {
        List<Locacao> listaRetorno = manager.createQuery("from Locacao a where a.idLocacao = :idLocacao", Locacao.class)
                .setParameter("idLocacao", aluguel.getIdLocacao())
                .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public List<Aluguel> getAlugueisByCriterios(Aluguel aluguelBase) {
        String jsql = "from Aluguel a " +
                      "where a.dataVencimento = COALESCE (:dataVencimento,  a.dataVencimento)" +
                      "and a.valorPago = COALESCE (:valorPago, a.valorPago) " +
                      "and  a.dataPagamento = COALESCE (:dataPagamento, a.dataPagamento) " +
                      "and a.obs = COALESCE (:obs, a.obs)";

        return manager.createQuery(jsql, Aluguel.class)
                .setParameter("dataVencimento", aluguelBase.getDataVencimento())
                .setParameter("valorPago", aluguelBase.getValorPago())
                .setParameter("dataPagamento", aluguelBase.getDataPagamento())
                .setParameter("obs", aluguelBase.getObs())
                .getResultList();
    }

    @Override
    public List<Aluguel> getAlugueisPagos() {
        String jsql = "from Aluguel a " +
                      "where a.valorPago > 0 ";

        return manager.createQuery(jsql, Aluguel.class).getResultList();
    }

    @Override
    public List<Aluguel> getAlugueisPagosNaDataVencimento() {
        String jsql = "from Aluguel a " +
                      "where a.valorPago > 0 " +
                      "and a.dataVencimento = a.dataPagamento ";

        return manager.createQuery(jsql, Aluguel.class).getResultList();
    }

    @Override
    public boolean salvarAluguel(Aluguel aluguel) {
        manager.merge(aluguel);
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
