package com.ifma.aluguel.repositorio;

import com.ifma.aluguel.entidade.Aluguel;
import com.ifma.aluguel.entidade.Locacao;

import java.util.List;

public interface AluguelRepository {

    public Aluguel getById(Integer idAluguel);

    public Locacao buscarLocacaoDoAluguel(Aluguel aluguel);

    public List<Aluguel> getAlugueisByCriterios(Aluguel aluguelBase);

    public List<Aluguel> getAlugueisPagos();

    public List<Aluguel> getAlugueisPagosNaDataVencimento();

    public boolean salvarAluguel(Aluguel aluguel);

    public boolean atualizarAluguel(Aluguel aluguel);

    public boolean deletarAluguel(Aluguel aluguel);


}
