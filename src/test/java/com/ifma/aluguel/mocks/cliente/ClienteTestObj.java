package com.ifma.aluguel.mocks.cliente;

import com.ifma.aluguel.entidade.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteTestObj {

    public List<Cliente> getClientesAluguelAtrasado(){
        Cliente cliente = new Cliente();
        cliente.setEmail("inventado@email.com");
        Cliente cliente2 = new Cliente();
        cliente2.setEmail("inventado2@email.com");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);
        return clientes;
    }

    public List<Cliente> getClientesAluguelAtrasadoErro(){
        Cliente cliente = new Cliente();
        cliente.setEmail("invalido.email.com");
        Cliente cliente2 = new Cliente();
        cliente2.setEmail("valido@email.com");

        List<Cliente> clientes = getClientesAluguelAtrasado();
        clientes.add(cliente);
        clientes.add(cliente2);
        return clientes;

    }
}
