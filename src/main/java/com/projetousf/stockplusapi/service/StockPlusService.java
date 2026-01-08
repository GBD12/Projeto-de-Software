package com.projetousf.stockplusapi.service;

import com.projetousf.stockplusapi.domain.Cliente;
import com.projetousf.stockplusapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPlusService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente createCliente(Cliente novoCliente) {
        return clienteRepository.save(novoCliente);
    }

    public Cliente findClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }
}