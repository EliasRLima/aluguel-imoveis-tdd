package com.ifma.aluguel.servico;

import com.ifma.aluguel.api.EmailApi;
import com.ifma.aluguel.entidade.Cliente;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.exception.MessageProperties;
import com.ifma.aluguel.repositorio.ClienteRepository;
import com.ifma.aluguel.repositorio.implementacoes.ClienteRepositoryImpl;
import com.ifma.aluguel.repositorio.implementacoes.ImovelRepositoryImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
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

    public Cliente salvarNovoCliente(Cliente cliente){
        if(Objects.nonNull(cliente.getIdCliente())){
            throw new AluguelException(
                    MessageProperties.getMensagemPadrao("erro.existe.cliente"));
        }

        return clienteRepository.salvar(cliente);
    }

    public void notificarAtrasados(){
        List<Cliente> atrasados = clienteRepository.getClienteComAluguelAtrasado();
        atrasados.forEach(atrasado -> {
            try{
                EmailApi.sendEmail(atrasado.getEmail(), "Seu aluguel esta atrasado, evite despejo e multas.");
            }catch (Exception e){
                System.out.println("Error ao enviar email para " + atrasado.getEmail());
            }
        });

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
