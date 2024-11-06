-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS Escola;
USE Escola;

-- Tabela Professor
CREATE TABLE Professor (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    departamento VARCHAR(100) NOT NULL
);

-- Tabela Curso
CREATE TABLE Curso (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargaHoraria INT NOT NULL,
    idProfessor INT,
    FOREIGN KEY (idProfessor) REFERENCES Professor(id)
);

-- Tabela Aluno
CREATE TABLE Aluno (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    dataNascimento DATE NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    idCurso INT,
    FOREIGN KEY (idCurso) REFERENCES Curso(id)
);
