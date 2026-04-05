INSERT INTO endereco (cep, cidade, estado, pais) VALUES
('74000000', 'Goiania', 'GO', 'Brasil'),
('01000000', 'Sao Paulo', 'SP', 'Brasil'),
('20000000', 'Rio de Janeiro', 'RJ', 'Brasil'),
('30000000', 'Belo Horizonte', 'MG', 'Brasil'),
('70000000', 'Brasilia', 'DF', 'Brasil'),
('80000000', 'Curitiba', 'PR', 'Brasil'),
('90000000', 'Porto Alegre', 'RS', 'Brasil'),
('40000000', 'Salvador', 'BA', 'Brasil');

INSERT INTO competencia (nome) VALUES
('Java'),
('Python'),
('SQL'),
('JavaScript'),
('React'),
('Node.js'),
('Docker'),
('AWS');

INSERT INTO candidato (nome, sobrenome, data_nascimento, email, cpf, descricao, senha, id_endereco) VALUES
('Joao', 'Silva', '1995-05-10', 'joao@email.com', '11111111111', 'Backend Java', '123', 1),
('Maria', 'Souza', '1998-03-22', 'maria@email.com', '22222222222', 'Frontend React', '123', 2),
('Pedro', 'Oliveira', '1990-07-15', 'pedro@email.com', '33333333333', 'Fullstack', '123', 3),
('Ana', 'Costa', '1993-11-30', 'ana@email.com', '44444444444', 'DevOps', '123', 4),
('Lucas', 'Pereira', '2000-01-05', 'lucas@email.com', '55555555555', 'Junior Python', '123', 5);

INSERT INTO empresa (nome, cnpj, email, descricao, senha, id_endereco) VALUES
('Tech Solutions', '11111111000101', 'tech@email.com', 'Empresa de tecnologia', '123', 2),
('Inova Sistemas', '22222222000102', 'inova@email.com', 'Software corporativo', '123', 3),
('Cloud Corp', '33333333000103', 'cloud@email.com', 'Infraestrutura cloud', '123', 4),
('Web Agency', '44444444000104', 'web@email.com', 'Agencia digital', '123', 1),
('Data Minds', '55555555000105', 'data@email.com', 'Dados e IA', '123', 5);

INSERT INTO vaga (nome, descricao, id_endereco, id_empresa, ativa) VALUES
('Backend Java', 'API com Spring', 2, 1, true),
('Frontend React', 'Interface web', 1, 4, true),
('Fullstack Node', 'Node + React', 3, 2, true),
('DevOps Engineer', 'CI/CD e cloud', 4, 3, true),
('Analista Python', 'Dados e automacao', 5, 5, true);

INSERT INTO candidato_competencia VALUES
(1, 1),
(1, 3),
(2, 4),
(2, 5),
(3, 1),
(3, 4),
(3, 6),
(4, 7),
(4, 8),
(5, 2);

INSERT INTO vaga_competencia VALUES
(1, 1),
(1, 3),
(2, 4),
(2, 5),
(3, 4),
(3, 6),
(4, 7),
(4, 8),
(5, 2);


INSERT INTO interacao (id_candidato, id_vaga, origem, tipo) VALUES
-- Candidato curte vaga
(1, 1, 'C', 'L'),
(2, 2, 'C', 'L'),
(3, 3, 'C', 'L'),
(4, 4, 'C', 'L'),
(5, 5, 'C', 'L'),
-- Candidato dá dislike
(1, 2, 'C', 'D'),
-- Empresa curte candidato
(1, 1, 'E', 'L'),
(2, 2, 'E', 'L'),
(3, 3, 'E', 'L'),
-- Empresa rejeita
(4, 5, 'E', 'D');

INSERT INTO match (id_vaga, id_candidato) VALUES
(1, 1),
(2, 2),
(3, 3);