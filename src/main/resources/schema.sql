CREATE TABLE tb_endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cep INT,
    logradouro VARCHAR(255),
    bairro VARCHAR(255),
    numero INT,
    complemento VARCHAR(255)
);

CREATE TABLE tb_cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(20),
    telefone VARCHAR(20),
    email VARCHAR(255),
    id_endereco INT,
    FOREIGN KEY (id_endereco) REFERENCES tb_endereco(id)
);