package com.ifma.aluguel.integracao.locacao;

import com.ifma.aluguel.entidade.Locacao;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.repositorio.implementacoes.LocacaoRepositoryImpl;
import com.ifma.aluguel.servico.LocacaoServico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class LocacaoTest {

    private LocacaoRepositoryImpl locacaoRepository;
    private LocacaoServico locacaoService;
    private EntityManager manager;
    private static EntityManagerFactory emf;

    @Before
    public void inicio(){
        emf = Persistence.createEntityManagerFactory("databaseTest");
        manager = emf.createEntityManager();
        manager.getTransaction().begin();

        locacaoRepository = new LocacaoRepositoryImpl(manager);
        locacaoService = new LocacaoServico(locacaoRepository);
    }

    @After
    public void fim() {
        manager.getTransaction().rollback();
        emf.close();
    }

    @Test
    public void locacaoCreatTest(){

        Locacao salvarLocacao = locacaoService.salvarLocacao(new LocacaoObjTest().getLocacaoNovoTest());
        assertNotNull(salvarLocacao.getIdLocacao());

        Locacao salvarLocacaoRepository = locacaoRepository.salvar(new LocacaoObjTest().getLocacaoNovoTest());
        assertNotNull(salvarLocacaoRepository.getIdLocacao());


        Locacao salvarLocacaoJaExistente = new LocacaoObjTest().getLocacaoExistenteTest();
        Throwable thrown = catchThrowable(() -> locacaoService.salvarLocacao(salvarLocacaoJaExistente));
        assertThat(thrown).isInstanceOf(AluguelException.class).hasMessageContaining("A locacao informada possui o identificador, considere utilizar o metodo de atualizar ou remova o identificador para salvar como um novo.");

    }

    @Test
    public void locacaoReadTest(){
        Locacao locacaoJaExistente = new LocacaoObjTest().getLocacaoExistenteTest();
        Locacao locacaoDoBanco = locacaoService.getLocacaoById(locacaoJaExistente.getIdLocacao());

        assertEquals(locacaoDoBanco.getValorAluguel(), locacaoJaExistente.getValorAluguel());

        Locacao locacaoIdNulo = locacaoService.getLocacaoById(0);
        assertNull(locacaoIdNulo);

        Locacao locacaoDoRepository = locacaoRepository.getById(locacaoJaExistente.getIdLocacao());
        assertEquals(locacaoDoBanco.getValorAluguel(), locacaoDoRepository.getValorAluguel());

        Locacao locacaoDoRepositoryNula = locacaoRepository.getById(0);
        assertNull(locacaoDoRepositoryNula);
    }

    @Test
    public void locacaoUpdateTest(){
        Locacao novaLocacao = locacaoService.getLocacaoById(11);

        novaLocacao.setValorAluguel(1300.0);
        boolean atualizar = locacaoService.atualizarLocacao(novaLocacao);
        assertTrue(atualizar);
        Locacao locacaoDoBanco = locacaoService.getLocacaoById(novaLocacao.getIdLocacao());
        assertEquals(locacaoDoBanco.getValorAluguel(), novaLocacao.getValorAluguel());

        novaLocacao.setValorAluguel(1400.0);
        boolean atualizarRepositorio = locacaoRepository.atualizar(novaLocacao);
        assertTrue(atualizarRepositorio);
        locacaoDoBanco = locacaoRepository.getById(novaLocacao.getIdLocacao());
        assertEquals(locacaoDoBanco.getValorAluguel(), novaLocacao.getValorAluguel());
    }

    @Test
    public void locacaoDeleteTest(){
        Locacao locacaoDoBanco = locacaoService.getLocacaoById(11);
        assertNotNull(locacaoDoBanco);

        boolean remover = locacaoService.deletarLocacao(locacaoDoBanco);
        assertTrue(remover);

        locacaoDoBanco = locacaoService.getLocacaoById(11);
        assertNull(locacaoDoBanco);
    }

    @Test
    public void verificaCalculoValorAluguelSemMulta(){
        double valor = locacaoService.calculaValorDeveSerPago(11);
        assertTrue(valor==1200.0);
    }

    @Test
    public void verificaCalculoValorAluguelComMulta(){
        double valor = locacaoService.calculaValorDeveSerPago(13);
        assertTrue(valor>1300.0);
    }
}
