package com.ifma.aluguel.aluguel;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.repositorio.implementacoes.AluguelRepositoryImpl;
import com.ifma.aluguel.servico.AluguelServico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AluguelTest {

    @Mock
    private AluguelRepositoryImpl aluguelRepository;

    @InjectMocks
    private AluguelServico aluguelServico;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void aluguelCreatTest(){
        Aluguel aluguel = null;

        boolean resultadoRepositorio = false;
        when(aluguelRepository.salvarAluguel(aluguel)).thenReturn(resultadoRepositorio);
        boolean resultadoServico = aluguelServico.salvarAluguel(aluguel);

        assertEquals(resultadoServico, resultadoRepositorio);
    }

    @Test
    public void aluguelReadTest(){
        Integer idAluguel = 123;

        Aluguel aluguelResultadoRepositorio = null;
        when(aluguelRepository.getById(idAluguel)).thenReturn(aluguelResultadoRepositorio);
        Aluguel aluguelResultadoServico = aluguelServico.buscarPorId(idAluguel);

        assertEquals(aluguelResultadoServico, aluguelResultadoRepositorio);
    }

    @Test
    public void aluguelUpdateTest(){
        Aluguel aluguel = null;

        boolean resultadoRepositorio = false;
        when(aluguelRepository.atualizarAluguel(aluguel)).thenReturn(resultadoRepositorio);
        boolean resultadoServico = aluguelServico.atualizarAluguel(aluguel);

        assertEquals(resultadoServico, resultadoRepositorio);
    }

    @Test
    public void aluguelDeleteTest(){
        Aluguel aluguel = null;

        boolean resultadoRepositorio = false;
        when(aluguelRepository.deletarAluguel(aluguel)).thenReturn(resultadoRepositorio);
        boolean resultadoServico = aluguelServico.deletarAluguel(aluguel);

        assertEquals(resultadoServico, resultadoRepositorio);
    }

}
