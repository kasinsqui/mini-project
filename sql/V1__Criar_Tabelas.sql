-->BD nome: Time time<--
CREATE TABLE login(
    id SERIAL NOT NULL PRIMARY KEY,
    login TEXT NOT NULL,
    senha  TEXT NOT NULL
);

CREATE TABLE prioridade(
    id SERIAL NOT NULL PRIMARY KEY,
    nome TEXT NOT NULL
);

CREATE TABLE produto(
    id SERIAL NOT NULL PRIMARY KEY,
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL
);

CREATE TABLE usuario(
    id  SERIAL NOT NULL PRIMARY KEY,
    nome TEXT NOT NULL,
    cargo CHAR NOT NULL,
    login_id INT,
    
    CONSTRAINT fk_usuarioLogin FOREIGN KEY (login_id) REFERENCES login(id)
);

CREATE TABLE os(
    id SERIAL NOT NULL PRIMARY KEY,
    produto_id INT NOT NULL,
    user_id INT NOT NULL,
    user_id1 INT,
    prioridade_id INT NOT NULL,
    titulo TEXT NOT NULL,
    descricao TEXT NOT NULL,

    CONSTRAINT fk_osProduto FOREIGN KEY (produto_id) REFERENCES produto(id),
    CONSTRAINT fk_osUsuario FOREIGN KEY (user_id) REFERENCES usuario(id),
    CONSTRAINT fk_osUsuario1 FOREIGN KEY (user_id1) REFERENCES usuario(id),
    CONSTRAINT fk_osPrioridade FOREIGN KEY (prioridade_id) REFERENCES prioridade(id)
);
