package com.ifma.aluguel.cliente;

import com.ifma.aluguel.entidade.Cliente;

public class ClienteObjTest {

    public Cliente getClienteNovoTest(){
        Cliente cliente = new Cliente();
        cliente.setNomeCliente("Joana Testada");
        cliente.setEmail("joana@email");
        cliente.setCpf("12332132145");
        return cliente;
    }

    public Cliente getClienteExistenteTest(){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(11);
        cliente.setNomeCliente("Joana Testada");
        cliente.setEmail("joana@email");
        cliente.setCpf("12332132145");
        return cliente;
    }
}
