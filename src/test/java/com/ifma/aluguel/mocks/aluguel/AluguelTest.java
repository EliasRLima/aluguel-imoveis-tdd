package com.ifma.aluguel.mocks.aluguel;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.repositorio.AluguelRepository;
import com.ifma.aluguel.servico.AluguelServico;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AluguelTest {

    @Mock
    private AluguelRepository aluguelRepository;

    @InjectMocks
    private AluguelServico aluguelServico;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void verificaPagamentoInvalido(){
        Aluguel aluguel = new AluguelObjTest().getAluguelParaTest();
        Locacao locacaoDoAluguel = new AluguelObjTest().getLocacaoDoAluguelParaTest();
        when(aluguelRepository.buscarLocacaoDoAluguel(aluguel)).thenReturn(locacaoDoAluguel);

        Throwable thrown = catchThrowable(() -> aluguelServico.atualizarAluguel(aluguel));

        assertThat(thrown).isInstanceOf(AluguelException.class)
                .hasMessageContaining("O valor não é o suficiente para pagar o aluguel.");
    }

}
