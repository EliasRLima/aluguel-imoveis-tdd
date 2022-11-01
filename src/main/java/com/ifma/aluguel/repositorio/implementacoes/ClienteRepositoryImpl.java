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
        List<Cliente> listaRetorno = manager.createQuery("from Cliente i where i.idCliente = :idCliente", Cliente.class)
                                     .setParameter("idCliente", idCliente)
                                     .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {
        List<Cliente> listaRetorno = manager.createQuery("from Cliente i where i.cpf = :cpf", Cliente.class)
                .setParameter("cpf", cpf)
                .getResultList();

        return listaRetorno.size() > 0 ? listaRetorno.get(0) : null;
    }

    public List<Cliente> getClienteComAluguelAtrasado(){
        List<Cliente> listaRetorno = manager.createQuery("from Cliente i " +
                        "where exists (select 0 " +
                                      "from Locacao l, Aluguel a " +
                                      "where l.idCliente = i.idCliente " +
                                      "and l.idLocacao = a.idLocacao " +
                                      "and a.dataVencimento < CURRENT_TIMESTAMP()" +
                                      "and a.dataPagamento is null)", Cliente.class)
                .getResultList();

        return listaRetorno;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        manager.persist(cliente);
        manager.refresh(cliente);
        return cliente;
    }

    @Override
    public boolean atualizar(Cliente cliente){
        manager.merge(cliente);
        return true;
    }

    @Override
    public boolean deletar(Cliente cliente) {
        manager.remove(cliente);
        return true;
    }
}
