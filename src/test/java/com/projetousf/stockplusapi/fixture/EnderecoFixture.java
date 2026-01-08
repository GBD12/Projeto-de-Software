package com.projetousf.stockplusapi.fixture;

import com.projetousf.stockplusapi.domain.Endereco;

public class EnderecoFixture {

    public static Endereco createEnderecoJoao() {
        return Endereco.builder()
                .numero(284)
                .bairro("Parque das Oliveiras")
                .complemento("Casa")
                .logradouro("Rua Teste 123")
                .cep(13049137)
                .build();
    }

    public static Endereco createEnderecoMaria() {
        return Endereco.builder()
                .numero(543)
                .bairro("Jardim testes 1")
                .complemento("Casa")
                .logradouro("Rua Teste 10000")
                .cep(13049227)
                .build();
    }
}