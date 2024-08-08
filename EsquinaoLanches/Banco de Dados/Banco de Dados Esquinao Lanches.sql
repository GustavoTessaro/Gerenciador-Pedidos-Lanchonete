create database if not exists BancoDeDadosEsquinaoLanches;

use BancoDeDadosEsquinaoLanches;

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    Ecadastrado VARCHAR(255),
    telefone VARCHAR(20),
    infoPedido TEXT,
    totalGasto FLOAT
);

CREATE TABLE Lanche (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    ingredientes TEXT,
    preco FLOAT
);

CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    dataCadastro DATE
);
