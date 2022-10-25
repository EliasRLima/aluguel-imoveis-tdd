package com.ifma.aluguel.cliente;

import com.ifma.aluguel.entidade.Cliente;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.repositorio.implementacoes.ClienteRepositoryImpl;
import com.ifma.aluguel.servico.ClienteServico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.*;


public class ClienteTest {

    private EntityManager manager;
    private static EntityManagerFactory emf;
    private ClienteRepositoryImpl clienteRepository;
    private ClienteServico clienteServico;

    @Before
    public void inicio(){
        emf = Persistence.createEntityManagerFactory("databaseTest");
        manager = emf.createEntityManager();
        manager.getTransaction().begin();

        clienteRepository = new ClienteRepositoryImpl(manager);
        clienteServico = new ClienteServico(clienteRepository);
    }

    @After
    public void fim() {
        manager.getTransaction().rollback();
        emf.close();
    }

    @Test
    public void clienteCreatTest(){

        Cliente cliente = clienteServico.salvarNovoCliente(new ClienteObjTest().getClienteNovoTest());

        assertNotNull(cliente.getIdCliente());

        Cliente clienteJaExistente = new ClienteObjTest().getClienteExistenteTest();
        Throwable thrown = catchThrowable(() -> clienteServico.salvarNovoCliente(clienteJaExistente));

        assertThat(thrown).isInstanceOf(AluguelException.class)
                .hasMessageContaining("O cliente informado possui o identificador, considere utilizar o metodo de atualizar ou remova o identificador para salvar como um novo.");

    }

    @Test
    public void clienteReadTest(){

        Cliente clienteById = clienteRepository.getById(11);
        Cliente clienteByCpf = clienteRepository.getClienteByCpf(clienteById.getCpf());
        assertEquals(clienteById.getNomeCliente(), clienteByCpf.getNomeCliente());

        Cliente clienteNovo = new ClienteObjTest().getClienteNovoTest();
        assertTrue(Objects.isNull(clienteRepository.getById(clienteNovo.getIdCliente())));
    }

    @Test
    public void clienteUpdateTest(){
        Cliente cliente = new ClienteObjTest().getClienteNovoTest();
        boolean retornoServico = clienteServico.atualizarCliente(cliente);

        assertTrue(retornoServico);
    }

    @Test
    public void clienteDeleteTest(){
        Cliente cliente = clienteServico.buscarPorId(11);
        assertTrue(Objects.nonNull(cliente));

        boolean retornoServico = clienteServico.removerCliente(cliente);
        assertTrue(retornoServico);
        assertTrue(Objects.isNull(clienteRepository.getById(cliente.getIdCliente())));
    }

}
