package com.ifma.aluguel.cliente;

import com.ifma.aluguel.entidade.Cliente;
import com.ifma.aluguel.repositorio.implementacoes.ClienteRepositoryImpl;
import com.ifma.aluguel.servico.ClienteServico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClienteTest {

    @Mock
    private ClienteRepositoryImpl clienteRepository;
    @InjectMocks
    private ClienteServico clienteServico;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void clienteCreatTest(){
        Cliente cliente = null;

        boolean retornoRepositorio = false;
        when(clienteRepository.salvar(cliente)).thenReturn(retornoRepositorio);
        boolean retornoServico = clienteServico.salvarCliente(cliente);

        assertEquals(retornoServico, retornoRepositorio);
    }

    @Test
    public void clienteReadTest(){
        Integer idCliente = 123;

        Cliente retornoClienteRepository = null;
        when(clienteRepository.getById(idCliente)).thenReturn(retornoClienteRepository);
        Cliente retornoClienteServico = clienteServico.buscarPorId(idCliente);

        assertEquals(retornoClienteServico, retornoClienteRepository);
    }

    @Test
    public void clienteUpdateTest(){
        Cliente cliente = null;

        boolean retornoRepositorio = false;
        when(clienteRepository.salvar(cliente)).thenReturn(retornoRepositorio);
        boolean retornoServico = clienteServico.atualizarCliente(cliente);

        assertEquals(retornoServico, retornoRepositorio);
    }

    @Test
    public void clienteDeleteTest(){
        Cliente cliente = null;

        boolean retornoRepositorio = false;
        when(clienteRepository.deletar(cliente)).thenReturn(retornoRepositorio);
        boolean retornoServico = clienteServico.removerCliente(cliente);

        assertEquals(retornoServico, retornoRepositorio);
    }

}
