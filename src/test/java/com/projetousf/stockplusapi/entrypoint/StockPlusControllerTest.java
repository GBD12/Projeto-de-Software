package com.projetousf.stockplusapi.entrypoint;

import com.projetousf.stockplusapi.domain.Cliente;
import com.projetousf.stockplusapi.domain.Endereco;
import com.projetousf.stockplusapi.fixture.ClienteFixture;
import com.projetousf.stockplusapi.service.StockPlusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockPlusControllerTest {

    @Mock
    private StockPlusService stockPlusService;

    @InjectMocks
    private StockPlusController stockPlusController;

    @Test
    void testCadastraCliente() {
        Cliente cliente = ClienteFixture.createCliente();
        when(stockPlusService.createCliente(any(Cliente.class))).thenReturn(cliente);

        Cliente requestBody = new Cliente(null, "João Silva", "123.456.789-00", "(11) 99999-1234", "joao.silva@example.com",
                Endereco.builder()
                        .numero(284)
                        .bairro("Parque das Oliveiras")
                        .complemento("Casa")
                        .logradouro("Rua Teste 123")
                        .cep(13049137)
                        .build()
        );
        ResponseEntity<Cliente> responseEntity = stockPlusController.cadastraCliente(requestBody);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }

    @Test
    void testGetClientes() {
        List<Cliente> clientes = Arrays.asList(
                ClienteFixture.createCliente(),
                ClienteFixture.createClienteMaria());

        when(stockPlusService.findAllClientes()).thenReturn(clientes);

        ResponseEntity<List<Cliente>> responseEntity = stockPlusController.getClientes();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clientes, responseEntity.getBody());
    }

    @Test
    void testGetClienteById() {
        Cliente cliente = ClienteFixture.createCliente();
        when(stockPlusService.findClienteById(1)).thenReturn(cliente);

        ResponseEntity<Cliente> responseEntity = stockPlusController.getClientes(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }
}