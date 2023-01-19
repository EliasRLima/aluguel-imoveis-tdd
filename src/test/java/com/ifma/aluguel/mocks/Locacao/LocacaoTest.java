package com.ifma.aluguel.mocks.Locacao;

import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.repositorio.LocacaoRepository;
import com.ifma.aluguel.servico.LocacaoServico;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocacaoTest {

    @Mock
    private LocacaoRepository locacaoRepository;

    @InjectMocks
    private LocacaoServico locacaoServico;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void verificaCalculoValorAluguelSemMulta(){
        Locacao locacao = new LocacaoObjTest().getLocacaoTest();
        when(locacaoRepository.getById(11)).thenReturn(locacao);

        double valor = locacaoServico.calculaValorDeveSerPago(11);
        assertTrue(valor==1200.0);
    }

    @Test
    public void verificaCalculoValorAluguelComMulta(){
        Locacao locacao = new LocacaoObjTest().getLocacaoAtrasadaTest();
        when(locacaoRepository.getById(11)).thenReturn(locacao);

        double valor = locacaoServico.calculaValorDeveSerPago(11);
        assertTrue(valor>1300.0);
    }
}
