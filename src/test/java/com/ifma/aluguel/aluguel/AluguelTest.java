package com.ifma.aluguel.aluguel;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.repositorio.implementacoes.AluguelRepositoryImpl;
import com.ifma.aluguel.servico.AluguelServico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class AluguelTest {

    private EntityManager manager;
    private static EntityManagerFactory emf;
    private AluguelRepositoryImpl aluguelRepository;
    private AluguelServico aluguelServico;

    @Before
    public void inicio(){
        emf = Persistence.createEntityManagerFactory("databaseTest");
        manager = emf.createEntityManager();
        manager.getTransaction().begin();

        aluguelRepository = new AluguelRepositoryImpl(manager);
        aluguelServico = new AluguelServico(aluguelRepository);
    }

    @After
    public void fim() {
        manager.getTransaction().rollback();
        emf.close();
    }

    @Test
    public void componentesTestNaoEstaoNull(){
        assertThat(aluguelRepository).isNotNull();
    }

    @Test
    public void aluguelCreatTest(){
        Aluguel aluguel = new AluguelObjTest().getNovoAluguelParaTest();

        boolean resultadoServico = aluguelServico.salvarAluguel(aluguel);
        assertTrue(resultadoServico);

        Aluguel aluguelJaSalvo = new AluguelObjTest().getAluguelNoBancoParaTest();
        Throwable thrown = catchThrowable(() -> aluguelServico.salvarAluguel(aluguelJaSalvo));

        assertThat(thrown).isInstanceOf(AluguelException.class)
                .hasMessageContaining("O aluguel informado já existe, considere verificar o identificado ou utilizar o metodo de atualizar.");

    }

    @Test
    public void aluguelReadTest(){
        Aluguel aluguel = new AluguelObjTest().getAluguelParaTest();

        assertTrue(Objects.isNull(aluguelRepository.getById(123)));
        assertFalse(Objects.isNull(aluguelRepository.getById(11)));

        Aluguel aluguelResultadoServico = aluguelServico.buscarPorId(11);
        assertTrue(Objects.nonNull(aluguelResultadoServico));
    }

    @Test
    public void aluguelUpdateTest(){
        Aluguel aluguel = new AluguelObjTest().getAluguelParaTest();

        boolean resultadoServico = aluguelServico.atualizarAluguel(aluguel);

        assertTrue(resultadoServico);
    }

    @Test
    public void aluguelDeleteTest(){
        Aluguel aluguel = new AluguelObjTest().getAluguelParaTest();
        boolean resultadoServico = aluguelServico.deletarAluguel(aluguel);

        assertTrue(resultadoServico);
    }

    @Test
    public void verificaPagamentoValido(){
        Aluguel aluguel = new AluguelObjTest().getAluguelParaTest();

        boolean resultadoServico = aluguelServico.atualizarAluguel(aluguel);

        assertTrue(resultadoServico);
    }

    @Test
    public void verificaPagamentoInvalido(){
        Aluguel aluguel = new AluguelObjTest().getAluguelPagamentoInvalidoParaTest();
        Throwable thrown = catchThrowable(() -> aluguelServico.atualizarAluguel(aluguel));

        assertThat(thrown).isInstanceOf(AluguelException.class)
                .hasMessageContaining("O valor não é o suficiente para pagar o aluguel.");
    }



}
