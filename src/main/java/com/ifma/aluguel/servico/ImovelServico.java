package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Imovel;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.exception.MessageProperties;
import com.ifma.aluguel.repositorio.ImovelRepository;
import com.ifma.aluguel.repositorio.implementacoes.ImovelRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;

public class ImovelServico {

    private ImovelRepository repository;

    public ImovelServico(ImovelRepository repository) {
        this.repository = repository;
    }

    public ImovelServico() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        this.repository = new ImovelRepositoryImpl(emf.createEntityManager());
    }


    public Imovel buscarPorId(Integer idImovel){
        return repository.getById(idImovel);
    }

    public List<Imovel> buscaDisponiveisPorModelo(Imovel imovelBase){
        return repository.getImoveisDisponiveisByCaracteristicas(imovelBase);
    }

    public List<Imovel> buscaDisponiveisAbaixoValor(Double valorDesejado){
        return repository.getImoveisDisponiveisAbaixoDoValor(valorDesejado);
    }

    public boolean salvarImovel(Imovel imovel){
        Imovel imovelJaExiste = buscarPorId(imovel.getIdImovel());
        if(Objects.nonNull(imovelJaExiste)){
            throw new AluguelException(
                    MessageProperties.getMensagemPadrao("erro.existe.imovel"));
        }
        return repository.salvar(imovel);
    }

    public boolean atualizarImovel(Imovel imovel){
        return repository.salvar(imovel);
    }

    public boolean removerImovel(Imovel imovel){
        return repository.deletar(imovel);
    }

}
