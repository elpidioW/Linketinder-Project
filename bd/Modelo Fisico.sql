CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    cep VARCHAR(8) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    pais VARCHAR(50) NOT NULL
);

CREATE TABLE candidato (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    descricao TEXT,
    senha VARCHAR(100) NOT NULL,
    id_endereco INT NOT NULL,

    CONSTRAINT fk_candidato_endereco
        FOREIGN KEY (id_endereco) REFERENCES endereco(id)
);

CREATE TABLE empresa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cnpj VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    descricao TEXT,
    senha VARCHAR(100) NOT NULL,
    id_endereco INT NOT NULL,

    CONSTRAINT fk_empresa_endereco
        FOREIGN KEY (id_endereco) REFERENCES endereco(id)
);

CREATE TABLE vaga (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT,
    ativa BOOLEAN NOT NULL DEFAULT TRUE,
    id_endereco INT NOT NULL,
    id_empresa INT NOT NULL,

    CONSTRAINT fk_vaga_endereco
        FOREIGN KEY (id_endereco) REFERENCES endereco(id),

    CONSTRAINT fk_vaga_empresa
        FOREIGN KEY (id_empresa) REFERENCES empresa(id) ON DELETE CASCADE
);

CREATE TABLE competencia (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE candidato_competencia (
    id_candidato INT,
    id_competencia INT,

    PRIMARY KEY (id_candidato, id_competencia),

    CONSTRAINT fk_cc_candidato
        FOREIGN KEY (id_candidato) REFERENCES candidato(id) ON DELETE CASCADE,

    CONSTRAINT fk_cc_competencia
        FOREIGN KEY (id_competencia) REFERENCES competencia(id) ON DELETE CASCADE
);

CREATE TABLE vaga_competencia (
    id_vaga INT,
    id_competencia INT,

    PRIMARY KEY (id_vaga, id_competencia),

    CONSTRAINT fk_vc_vaga
        FOREIGN KEY (id_vaga) REFERENCES vaga(id) ON DELETE CASCADE,

    CONSTRAINT fk_vc_competencia
        FOREIGN KEY (id_competencia) REFERENCES competencia(id) ON DELETE CASCADE
);

CREATE TABLE interacao (
    id SERIAL PRIMARY KEY,
    id_candidato INT NOT NULL,
    id_vaga INT NOT NULL,
    origem CHAR(1) NOT NULL,
    tipo CHAR(1) NOT NULL,

    CONSTRAINT fk_interacao_candidato
        FOREIGN KEY (id_candidato) REFERENCES candidato(id) ON DELETE CASCADE,

    CONSTRAINT fk_interacao_vaga
        FOREIGN KEY (id_vaga) REFERENCES vaga(id) ON DELETE CASCADE,

    CONSTRAINT chk_origem
        CHECK (origem IN ('C', 'E')),

    CONSTRAINT chk_tipo
        CHECK (tipo IN ('L', 'D')),

    CONSTRAINT unq_interacao
        UNIQUE (id_candidato, id_vaga, origem)
);
COMMENT ON COLUMN interacao.origem IS 'C = candidato, E = empresa';
COMMENT ON COLUMN interacao.tipo IS 'L = like, D = dislike';

CREATE TABLE match (
    id_vaga INT,
    id_candidato INT,

    PRIMARY KEY (id_vaga, id_candidato),

    CONSTRAINT fk_match_vaga
        FOREIGN KEY (id_vaga) REFERENCES vaga(id) ON DELETE CASCADE,

    CONSTRAINT fk_match_candidato
        FOREIGN KEY (id_candidato) REFERENCES candidato(id) ON DELETE CASCADE
);