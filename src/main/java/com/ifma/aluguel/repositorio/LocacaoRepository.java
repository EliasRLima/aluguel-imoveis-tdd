package com.ifma.aluguel.repositorio;

import com.ifma.aluguel.entidade.Locacao;

public interface LocacaoRepository {

    public Locacao getById(Integer idLocacao);

    public Locacao salvar(Locacao locacao);

    public boolean atualizar(Locacao locacao);

    public boolean deletar(Locacao locacao);
}
