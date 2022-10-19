package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Imovel;
import com.ifma.aluguel.repositorio.ImovelRepository;
import com.ifma.aluguel.repositorio.implementacoes.ImovelRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ImovelServico {

    private ImovelRepository repository;

    public ImovelServico(ImovelRepository repository) {
        this.repository = repository;
    }

    public ImovelServico() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imovelManager");
        this.repository = new ImovelRepositoryImpl(emf.createEntityManager());
    }


    public Imovel buscarPorId(Integer idImovel){
        return repository.getById(idImovel);
    }

    public List<Imovel> buscaPorCriterios(Imovel imovelBase){
        return repository.getImoveisByCaracteristicas(imovelBase);
    }

    public boolean salvarImovel(Imovel imovel){
        return repository.salvar(imovel);
    }

    public boolean atualizarImovel(Imovel imovel){
        return repository.salvar(imovel);
    }

    public boolean removerImovel(Imovel imovel){
        return repository.deletar(imovel);
    }

}
