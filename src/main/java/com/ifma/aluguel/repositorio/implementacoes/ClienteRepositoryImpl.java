package com.ifma.aluguel.repositorio.implementacoes;

import com.ifma.aluguel.entidade.Cliente;
import com.ifma.aluguel.repositorio.ClienteRepository;
import com.ifma.aluguel.servico.ClienteServico;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {

    private EntityManager manager;

    public ClienteRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }
    @Override
    public Cliente getById(Integer idCliente) {
        List<Cliente> listaRetorno = manager.createQuery("from cliente i where i.idCliente = :idCliente", Cliente.class)
                                     .setParameter("idCliente", idCliente)
                                     .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public Cliente getClienteByCpf(Integer cpf) {
        List<Cliente> listaRetorno = manager.createQuery("from cliente i where i.cpf = :cpf", Cliente.class)
                .setParameter("cpf", cpf)
                .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public boolean salvar(Cliente cliente) {
        manager.persist(cliente);
        return true;
    }

    @Override
    public boolean atualizar(Cliente cliente){
        manager.merge(cliente);
        return true;
    }

    @Override
    public boolean deletar(Cliente cliente) {
        manager.merge(cliente);
        return false;
    }
}
