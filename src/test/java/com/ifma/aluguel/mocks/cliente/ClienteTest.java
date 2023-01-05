package com.ifma.aluguel.mocks.cliente;

import com.ifma.aluguel.entidade.Cliente;
import com.ifma.aluguel.exception.MessageProperties;
import com.ifma.aluguel.repositorio.implementacoes.ClienteRepositoryImpl;
import com.ifma.aluguel.servico.ClienteServico;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteTest {

    @Mock
    private ClienteRepositoryImpl clienteRepository;

    @Mock
    private MessageProperties messageProperties;

    @InjectMocks
    private ClienteServico clienteServico;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void verificarEnvioEmail(){
        List<Cliente> clientesValido = new ClienteTestObj().getClientesAluguelAtrasado();

        when(clienteRepository.getClienteComAluguelAtrasado()).thenReturn(clientesValido);
        clienteServico.notificarAtrasados();
        verify(messageProperties, times(0)).getMensagemPadrao("erro.email.invalido");
    }

    @Test
    public void verificarEnvioEmailInvalido(){
        List<Cliente> clientesInvalido = new ClienteTestObj().getClientesAluguelAtrasadoErro();

        when(clienteRepository.getClienteComAluguelAtrasado()).thenReturn(clientesInvalido);
        clienteServico.notificarAtrasados();
        verify(messageProperties, times(1)).getMensagemPadrao("erro.email.invalido");
    }
}
