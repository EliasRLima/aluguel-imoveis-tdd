package com.ifma.aluguel.repositorio.implementacoes;

import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.repositorio.LocacaoRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class LocacaoRepositoryImpl implements LocacaoRepository {

    private EntityManager manager;

    public LocacaoRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Locacao getById(Integer idLocacao) {
        List<Locacao> listaRetorno = manager.createQuery("from locacao a where i.idLocacao = :idLocacao", Locacao.class)
                .setParameter("idLocacao", idLocacao)
                .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

}
