package com.ifma.aluguel.repositorio;

import com.ifma.aluguel.entidade.Imovel;

import java.util.List;

public interface ImovelRepository {

    public Imovel getById(Integer idImovel);

    public List<Imovel> getImoveisDisponiveisByCaracteristicas(Imovel imovelBase);

    public List<Imovel> getImoveisDisponiveisAbaixoDoValor(Double valorSugerido);

    public Imovel salvar(Imovel imovel);

    public boolean atualizar(Imovel imovel);

    public boolean deletar(Imovel imovel);
}
