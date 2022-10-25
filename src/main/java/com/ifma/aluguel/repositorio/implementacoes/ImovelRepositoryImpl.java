package com.ifma.aluguel.repositorio.implementacoes;

import com.ifma.aluguel.entidade.Imovel;
import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.repositorio.ImovelRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ImovelRepositoryImpl implements ImovelRepository {

    private EntityManager manager;

    public ImovelRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Imovel getById(Integer idImovel) {
        List<Imovel> listaRetorno = manager.createQuery("from Imovel i where i.idImovel = :idImovel", Imovel.class)
                                    .setParameter("idImovel", idImovel)
                                    .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public List<Imovel> getImoveisDisponiveisByCaracteristicas(Imovel imovelBase) {
        String query =  "from Imovel i " +
                "where i.tipoImovel = COALESCE (:tipoImovel, i.tipoImovel) " +
                "and i.endereco = COALESCE (:endereco, i.endereco) " +
                "and i.bairro = COALESCE (:bairro, i.bairro) " +
                "and i.cep = COALESCE (:cep, i.cep) " +
                "and i.metragem = COALESCE (:metragem, i.metragem) " +
                "and i.dormitorios = COALESCE (:dormitorios, i.dormitorios) " +
                "and i.banheiros = COALESCE (:banheiros, i.banheiros) " +
                "and i.suites = COALESCE (:suites, i.suites) " +
                "and i.vagasGaragem = COALESCE (:vagasGaragem, i.vagasGaragem) " +
                "and i.valorAluguelSugerido = COALESCE (:valorAluguelSugerido, i.valorAluguelSugerido) " +
                "and i.obs = COALESCE (:obs, i.obs) " +
                "and not exists (select 0 from Locacao l where l.idImovel = i.idImovel  and l.ativo = true)";

        List<Imovel> listaRetorno = manager.createQuery(query, Imovel.class)
                .setParameter("tipoImovel", imovelBase.getTipoImovel())
                .setParameter("endereco", imovelBase.getEndereco())
                .setParameter("bairro", imovelBase.getBairro())
                .setParameter("cep", imovelBase.getCep())
                .setParameter("metragem", imovelBase.getMetragem())
                .setParameter("dormitorios", imovelBase.getDormitorios())
                .setParameter("banheiros", imovelBase.getBanheiros())
                .setParameter("suites", imovelBase.getSuites())
                .setParameter("vagasGaragem", imovelBase.getVagasGaragem())
                .setParameter("valorAluguelSugerido", imovelBase.getValorAluguelSugerido())
                .setParameter("obs", imovelBase.getObs())
                .getResultList();

        return listaRetorno;
    }

    @Override
    public List<Imovel> getImoveisDisponiveisAbaixoDoValor(Double valorSugerido) {
        String query =  "from Imovel i " +
                        "where i.valorAluguelSugerido <= :valorAluguelSugerido " +
                        "and not exists (select 0 from Locacao l where l.idImovel = i.idImovel  and l.ativo = true)";

        List<Imovel> listaRetorno = manager.createQuery(query, Imovel.class)
                .setParameter("valorAluguelSugerido", valorSugerido)
                .getResultList();

        return listaRetorno;
    }



    @Override
    public Imovel salvar(Imovel imovel) {
        manager.persist(imovel);
        manager.refresh(imovel);
        return imovel;
    }

    @Override
    public  boolean atualizar(Imovel imovel){
        manager.merge(imovel);
        return true;
    }

    @Override
    public boolean deletar(Imovel imovel) {
        manager.remove(manager.contains(imovel) ? imovel : manager.merge(imovel));
        return true;
    }
}
