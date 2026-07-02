CREATE TABLE livros (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano_publicacao INTEGER NOT NULL,
    editora VARCHAR(255) NOT NULL,
    quantidade_exemplares INTEGER NOT NULL,
    status VARCHAR(50) NOT NULL
);