package com.projetousf.stockplusapi.fixture;

import com.projetousf.stockplusapi.domain.Cliente;

public class ClienteFixture {

    public static Cliente createCliente() {
        return Cliente.builder()
                .id(1)
                .nome("João Silva")
                .cpf("123.456.789-00")
                .telefone("(11) 99999-1234")
                .email("joao.silva@example.com")
                .endereco(EnderecoFixture.createEnderecoJoao())
                .build();
    }

    public static Cliente createClienteWithNullId() {
        return Cliente.builder()
                .nome("João Silva")
                .cpf("123.456.789-00")
                .telefone("(11) 99999-1234")
                .email("joao.silva@example.com")
                .endereco(EnderecoFixture.createEnderecoJoao())
                .build();
    }

    public static Cliente createClienteMaria() {
        return Cliente.builder()
                .id(2)
                .nome("Maria Oliveira")
                .cpf("987.654.321-00")
                .telefone("(21) 88888-5678")
                .email("maria.oliveira@example.com")
                .endereco(EnderecoFixture.createEnderecoMaria())
                .build();
    }
}