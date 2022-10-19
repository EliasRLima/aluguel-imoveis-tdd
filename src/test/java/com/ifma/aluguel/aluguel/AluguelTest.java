package com.ifma.aluguel.aluguel;

import com.ifma.aluguel.entidade.Aluguel;
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
        when(aluguelRepository.salvar(aluguel)).thenReturn(resultadoRepositorio);
        boolean resultadoServico = aluguelServico.salvar(aluguel);

        assertEquals(resultadoServico, resultadoRepositorio);
    }

    @Test
    public void aluguelReadTest(){
        Integer idAluguel = 123;

        Aluguel aluguelResultadoRepositorio = null;
        when(aluguelRepository.getById(idAluguel)).thenReturn(aluguelResultadoRepositorio);
        Aluguel aluguelResultadoServico = aluguelServico.buscarAluguelPorId(idAluguel);

        assertEquals(aluguelResultadoServico, aluguelResultadoRepositorio);
    }

    @Test
    public void aluguelUpdateTest(){
        Aluguel aluguel = null;

        boolean resultadoRepositorio = false;
        when(aluguelRepository.update(aluguel)).thenReturn(resultadoRepositorio);
        boolean resultadoServico = aluguelServico.atualizarAluguel(aluguel);

        assertEquals(resultadoServico, resultadoRepositorio);
    }

    @Test
    public void aluguelDeleteTest(){
        Aluguel aluguel = null;

        boolean resultadoRepositorio = false;
        when(aluguelRepository.delete(aluguel)).thenReturn(resultadoRepositorio);
        boolean resultadoServico = aluguelServico.removerAluguel(aluguel);

        assertEquals(resultadoServico, resultadoRepositorio);
    }

}
