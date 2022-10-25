package com.ifma.aluguel.imovel;

import com.ifma.aluguel.entidade.Imovel;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.repositorio.implementacoes.ImovelRepositoryImpl;
import com.ifma.aluguel.servico.ImovelServico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.*;

public class ImovelTest {


    private ImovelRepositoryImpl imovelRepository;
    private ImovelServico imovelService;
    private EntityManager manager;
    private static EntityManagerFactory emf;

    @Before
    public void inicio(){
        emf = Persistence.createEntityManagerFactory("databaseTest");
        manager = emf.createEntityManager();
        manager.getTransaction().begin();

        imovelRepository = new ImovelRepositoryImpl(manager);
        imovelService = new ImovelServico(imovelRepository);
    }

    @After
    public void fim() {
        manager.getTransaction().rollback();
        emf.close();
    }

    @Test
    public void imovelCreatTest(){
        Imovel imovel = new ImovelObjTest().getImovelNovoTest();

        boolean criarPeloService = imovelService.salvarImovel(imovel);
        assertTrue(criarPeloService);

        Imovel imovelJaExistente = new ImovelObjTest().getImovelExistenteTest();
        Throwable thrown = catchThrowable(() -> imovelService.salvarImovel(imovelJaExistente));

        assertThat(thrown).isInstanceOf(AluguelException.class)
                .hasMessageContaining("O imovel informado já existe, considere verificar o identificado ou utilizar o metodo de atualizar.");
    }

    @Test
    public void imovelReadTest(){
        Imovel imovelNovo = new ImovelObjTest().getImovelNovoTest();
        Imovel imovelJaExistente = new ImovelObjTest().getImovelExistenteTest();

        assertTrue(Objects.isNull(imovelService.buscarPorId(imovelNovo.getIdImovel())));
        assertTrue(Objects.nonNull(imovelService.buscarPorId(imovelJaExistente.getIdImovel())));

        Imovel imovelDisponivel = new ImovelObjTest().getImovelExistenteSemLocacaoTest();
        List<Imovel> imoveis = imovelService.buscaDisponiveisAbaixoValor(imovelDisponivel.getValorAluguelSugerido());
        assertFalse(imoveis.isEmpty());
    }

    @Test
    public void imovelUpdateTest(){
        Imovel imovelNovo = new ImovelObjTest().getImovelNovoTest();
        boolean retornoService = imovelService.salvarImovel(imovelNovo);
        assertTrue(retornoService);
        imovelNovo.setTipoImovel("Chalé");
        retornoService = imovelService.atualizarImovel(imovelNovo);
        assertTrue(retornoService);

    }

    @Test
    public void imovelDeleteTest(){
        Imovel imovel = new ImovelObjTest().getImovelExistenteTest();
        boolean retornoService = imovelService.removerImovel(imovel);

        assertTrue(retornoService);
        assertNull(imovelService.buscarPorId(imovel.getIdImovel()));
    }

    @Test
    public void buscaEmBairroPorTipoEstandoDisponivelTest(){
        Imovel imovelModelo = new Imovel();
        imovelModelo.setTipoImovel("Apartamento");
        imovelModelo.setBairro("bairro 2");
        List<Imovel> retornoService = imovelService.buscaDisponiveisPorModelo(imovelModelo);

        assertFalse(retornoService.isEmpty());
    }

    @Test
    public void buscaLimiteDeValorTest(){
        Double valorLimite = 10000.0;
        List<Imovel> retornoService = imovelService.buscaDisponiveisAbaixoValor(valorLimite);

        assertFalse(retornoService.isEmpty());
    }

}
