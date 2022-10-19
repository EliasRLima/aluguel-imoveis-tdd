package com.ifma.aluguel.repositorio;


import com.ifma.aluguel.entidade.Cliente;

import java.util.List;

public interface ClienteRepository {

    public Cliente getById(Integer idCliente);

    public Cliente getClienteByCpf(Integer cpf);

    public boolean salvar(Cliente cliente);

    public boolean atualizar(Cliente cliente);

    public boolean deletar(Cliente cliente);
}
