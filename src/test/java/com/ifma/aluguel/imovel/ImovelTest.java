package com.ifma.aluguel.imovel;

import com.ifma.aluguel.entidade.Imovel;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ImovelTest {

    @Mock
    private ImovelRepository imovelRepository;

    @InjectMocks
    private ImovelService imovelService;

    @Test
    public void imovelCreatTest(){
        Imovel imovel = null;

        boolean criarPeloRepository = false;
        when(imovelRepository.salvar(imovel)).thenReturn(criarPeloRepository);
        boolean criarPeloService = imovelService.salvar(imovel);

        assertEquals(criarPeloService, criarPeloRepository);
    }

    @Test
    public void imovelReadTest(){
        Integer idImovel = 123;

        Imovel imovelRetornoRepositorio = null;
        when(imovelRepository.buscar(idImovel)).thenReturn(imovelRetornoRepositorio);
        Imovel imovelRetornoService = imovelService.buscar(idImovel);

        assertEquals(imovelRetornoService, imovelRetornoRepositorio);
    }

    @Test
    public void imovelUpdateTest(){
        Imovel imovelAtualizado = null;

        boolean retornoRepository = true;
        when(imovelRepository.atualizar(imovelAtualizado)).thenReturn(retornoRepository);
        boolean retornoService = imovelService.atualizar(imovelAtualizado);

        assertEquals(retornoService, retornoRepository);
    }

    @Test
    public void imovelDeleteTest(){
        Integer idImovel = 123;

        boolean retornoRepository = true;
        when(imovelRepository.deletar(idImovel)).thenReturn(retornoRepository);
        boolean retornoService = imovelService.remover(idImovel);

        assertEquals(retornoService, retornoRepository);
    }

    @Test
    public void buscaEmBairroPorTipoEstandoDisponivelTest(){

    }

    @Test
    public void buscaLimiteDeValorTest(){

    }

}
