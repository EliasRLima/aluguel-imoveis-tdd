package com.ifma.aluguel.repositorio;

import com.ifma.aluguel.entidade.Imovel;

import java.util.List;

public interface ImovelRepository {

    public Imovel getById(Integer idImovel);

    public List<Imovel> getImoveisByCaracteristicas(Imovel imovelBase);

    public boolean salvar(Imovel imovel);

    public boolean deletar(Imovel imovel);
}
