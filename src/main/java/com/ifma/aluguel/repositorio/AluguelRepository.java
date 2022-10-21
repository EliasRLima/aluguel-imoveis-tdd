package com.ifma.aluguel.repositorio;

import com.ifma.aluguel.entidade.Aluguel;

import java.util.List;

public interface AluguelRepository {

    public Aluguel getById(Integer idAluguel);

    public List<Aluguel> getAlugueisByCriterios(Aluguel aluguelBase);

    public boolean salvarAluguel(Aluguel aluguel);

    public boolean atualizarAluguel(Aluguel aluguel);

    public boolean deletarAluguel(Aluguel aluguel);

}
