package com.ifma.aluguel.imovel;

import com.ifma.aluguel.entidade.Imovel;
import com.ifma.aluguel.repositorio.implementacoes.ImovelRepositoryImpl;
import com.ifma.aluguel.servico.ImovelServico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ImovelTest {

    @Mock
    private ImovelRepositoryImpl imovelRepository;

    @InjectMocks
    private ImovelServico imovelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void imovelCreatTest(){
        Imovel imovel = null;

        boolean criarPeloRepository = false;
        when(imovelRepository.salvar(imovel)).thenReturn(criarPeloRepository);
        boolean criarPeloService = imovelService.salvarImovel(imovel);

        assertEquals(criarPeloService, criarPeloRepository);
    }

    @Test
    public void imovelReadTest(){
        Integer idImovel = 123;

        Imovel imovelRetornoRepositorio = null;
        when(imovelRepository.getById(idImovel)).thenReturn(imovelRetornoRepositorio);
        Imovel imovelRetornoService = imovelService.buscarPorId(idImovel);

        assertEquals(imovelRetornoService, imovelRetornoRepositorio);
    }

    @Test
    public void imovelUpdateTest(){
        Imovel imovelAtualizado = null;

        boolean retornoRepository = true;
        when(imovelRepository.salvar(imovelAtualizado)).thenReturn(retornoRepository);
        boolean retornoService = imovelService.atualizarImovel(imovelAtualizado);

        assertEquals(retornoService, retornoRepository);
    }

    @Test
    public void imovelDeleteTest(){
        Imovel imovel = null;

        boolean retornoRepository = true;
        when(imovelRepository.deletar(imovel)).thenReturn(retornoRepository);
        boolean retornoService = imovelService.removerImovel(imovel);

        assertEquals(retornoService, retornoRepository);
    }

    @Test
    public void buscaEmBairroPorTipoEstandoDisponivelTest(){
        Imovel imovelModelo = new Imovel();
        imovelModelo.setTipoImovel("Apartamento");
        imovelModelo.setBairro("Centro");

        List<Imovel> retornoRepository = null;
        when(imovelRepository.getImoveisDisponiveisByCaracteristicas(imovelModelo)).thenReturn(retornoRepository);
        List<Imovel> retornoService = imovelService.buscaDisponiveisPorModelo(imovelModelo);

        assertEquals(retornoService, retornoRepository);
    }

    @Test
    public void buscaLimiteDeValorTest(){
        Double valorLimite = 10000.0;

        List<Imovel> retornoRepository = null;
        when(imovelRepository.getImoveisDisponiveisAbaixoDoValor(valorLimite)).thenReturn(retornoRepository);
        List<Imovel> retornoService = imovelService.buscaDisponiveisAbaixoValor(valorLimite);

        assertEquals(retornoService, retornoRepository);
    }

}
