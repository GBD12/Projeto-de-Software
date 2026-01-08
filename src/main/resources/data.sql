INSERT INTO tb_endereco (id, cep, logradouro, bairro, numero, complemento) VALUES
(1, 12345678, 'Rua das Flores', 'Jardim Primavera', 123, 'Apto 101'),
(2, 87654321, 'Avenida Central', 'Centro', 456, 'Bloco B'),
(3, 11223344, 'Rua das Palmeiras', 'Vila Nova', 789, 'Casa'),
(4, 55667788, 'Travessa do Sol', 'Parque das Nações', 101, ''),
(5, 99887766, 'Alameda dos Anjos', 'Jardim dos Sonhos', 202, 'Cobertura');

INSERT INTO tb_cliente (id, nome, cpf, telefone, email, id_endereco) VALUES
(1, 'João Silva', '123.456.789-00', '(11) 99999-1234', 'joao.silva@example.com', 1),
(2, 'Maria Oliveira', '987.654.321-00', '(21) 88888-5678', 'maria.oliveira@example.com', 2),
(3, 'Carlos Souza', '111.222.333-44', '(31) 77777-9101', 'carlos.souza@example.com', 3),
(4, 'Ana Ferreira', '555.666.777-88', '(41) 66666-1122', 'ana.ferreira@example.com', 4),
(5, 'Pedro Almeida', '999.888.777-66', '(51) 55555-3344', 'pedro.almeida@example.com', 5);