package com.ifma.aluguel.servico;

import com.ifma.aluguel.entidade.Cliente;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.exception.MessageProperties;
import com.ifma.aluguel.repositorio.ClienteRepository;
import com.ifma.aluguel.repositorio.implementacoes.ClienteRepositoryImpl;
import com.ifma.aluguel.repositorio.implementacoes.ImovelRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class ClienteServico {

    private ClienteRepository clienteRepository;

    public ClienteServico(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteServico(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        this.clienteRepository = new ClienteRepositoryImpl(emf.createEntityManager());
    }

    public boolean salvarCliente(Cliente cliente){
        Cliente clienteJaSalvo = buscarPorId(cliente.getIdCliente());
        if(Objects.nonNull(clienteJaSalvo)){
            throw new AluguelException(
                    MessageProperties.getMensagemPadrao("erro.existe.cliente"));
        }

        return clienteRepository.salvar(cliente);
    }

    public Cliente buscarPorId(Integer idCliente){
        return clienteRepository.getById(idCliente);
    }

    public Cliente buscarPorCpf(String cpf){
        return clienteRepository.getClienteByCpf(cpf);
    }

    public boolean atualizarCliente(Cliente cliente){
        return clienteRepository.atualizar(cliente);
    }

    public boolean removerCliente(Cliente cliente){
        return clienteRepository.deletar(cliente);
    }



}
