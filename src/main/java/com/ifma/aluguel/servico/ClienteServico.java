package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Cliente;
import com.ifma.aluguel.repositorio.ClienteRepository;
import com.ifma.aluguel.repositorio.implementacoes.ClienteRepositoryImpl;
import com.ifma.aluguel.repositorio.implementacoes.ImovelRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteServico {

    private ClienteRepository clienteRepository;

    public ClienteServico(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteServico(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("clienteManager");
        this.clienteRepository = new ClienteRepositoryImpl(emf.createEntityManager());
    }

    public boolean salvarCliente(Cliente cliente){
        return clienteRepository.salvar(cliente);
    }

    public Cliente buscarPorId(Integer idCliente){
        return clienteRepository.getById(idCliente);
    }

    public Cliente buscarPorCpf(Integer cpf){
        return clienteRepository.getClienteByCpf(cpf);
    }

    public boolean atualizarCliente(Cliente cliente){
        return clienteRepository.atualizar(cliente);
    }

    public boolean removerCliente(Cliente cliente){
        return clienteRepository.deletar(cliente);
    }



}
