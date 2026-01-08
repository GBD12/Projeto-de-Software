package com.projetousf.stockplusapi.service;

import com.projetousf.stockplusapi.domain.Cliente;
import com.projetousf.stockplusapi.fixture.ClienteFixture;
import com.projetousf.stockplusapi.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockPlusServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private StockPlusService stockPlusService;

    @Test
    void testFindAll() {
        List<Cliente> clientes = Arrays.asList(
                ClienteFixture.createCliente(),
                ClienteFixture.createClienteMaria()
        );
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = stockPlusService.findAllClientes();

        assertEquals(2, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Cliente cliente = ClienteFixture.createCliente();
        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

        Cliente result = stockPlusService.findClienteById(1);

        assertEquals(cliente, result);
        verify(clienteRepository, times(1)).findById(1);
    }

    @Test
    void testFindByIdNotFound() {
        when(clienteRepository.findById(1)).thenReturn(Optional.empty());

        Cliente result = stockPlusService.findClienteById(1);

        assertNull(result);
        verify(clienteRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        Cliente cliente = ClienteFixture.createClienteWithNullId();
        Cliente savedCliente = ClienteFixture.createCliente();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(savedCliente);

        Cliente result = stockPlusService.createCliente(cliente);

        assertEquals(savedCliente, result);
        verify(clienteRepository, times(1)).save(cliente);
    }
}
