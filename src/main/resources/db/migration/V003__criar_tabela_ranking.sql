CREATE TABLE ranking(
    id BIGINT NOT NULL AUTO_INCREMENT,
    pontuacao BIGINT NOT NULL,
    posicao INT,
    usuario_id BIGINT,
    primary key (id),
    CONSTRAINT `fk_usuario_ranking` FOREIGN KEY (usuario_id) REFERENCES usuario (id)
) ENGINE=InnoDB DEFAULT CHARSET = UTF8;