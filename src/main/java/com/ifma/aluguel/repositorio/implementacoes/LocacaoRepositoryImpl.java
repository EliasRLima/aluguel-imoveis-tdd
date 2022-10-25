package com.ifma.aluguel.repositorio.implementacoes;

import com.ifma.aluguel.entidade.Imovel;
import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.repositorio.LocacaoRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class LocacaoRepositoryImpl implements LocacaoRepository {

    private EntityManager manager;

    public LocacaoRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Locacao getById(Integer idLocacao) {
        List<Locacao> listaRetorno = manager.createQuery("from Locacao a where a.idLocacao = :idLocacao", Locacao.class)
                .setParameter("idLocacao", idLocacao)
                .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public Locacao salvar(Locacao locacao) {
        manager.persist(locacao);
        manager.refresh(locacao);
        return locacao;
    }

    @Override
    public boolean atualizar(Locacao locacao) {
        manager.merge(locacao);
        return true;
    }

    @Override
    public boolean deletar(Locacao locacao) {
        manager.remove(locacao);
        return true;
    }

}
