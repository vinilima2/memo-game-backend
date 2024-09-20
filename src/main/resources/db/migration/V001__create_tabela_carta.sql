CREATE TABLE carta(
    id BIGINT NOT NULL AUTO_INCREMENT,
    icone VARCHAR(80) NOT NULL,
    cor VARCHAR(50),
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET = UTF8;


INSERT INTO carta(icone, cor)
VALUES ('star-fill', 'yellow');

INSERT INTO carta(icone, cor)
VALUES ('moon-fill', 'darkgray');

INSERT INTO carta(icone, cor)
VALUES ('flower1', 'red');

INSERT INTO carta(icone, cor)
VALUES ('heart-fill', 'red');

INSERT INTO carta(icone, cor)
VALUES ('cup-straw', 'lightblue');

INSERT INTO carta(icone, cor)
VALUES ('tree-fill', 'green');

INSERT INTO carta(icone, cor)
VALUES ('fire', 'red');

INSERT INTO carta(icone, cor)
VALUES ('droplet-fill', 'lightblue');

INSERT INTO carta(icone, cor)
VALUES ('watch', 'black');

INSERT INTO carta(icone, cor)
VALUES ('balloon-fill', 'yellow');

INSERT INTO carta(icone, cor)
VALUES ('truck-front-fill', 'darkgray');

INSERT INTO carta(icone, cor)
VALUES ('car-front-fill', 'darkgray');

INSERT INTO carta(icone, cor)
VALUES ('airplane-fill', 'darkgray');

INSERT INTO carta(icone, cor)
VALUES ('scissors', 'darkgray');

INSERT INTO carta(icone, cor)
VALUES ('pencil-fill', 'red');

INSERT INTO carta(icone, cor)
VALUES ('mouse2-fill', 'lightblue');

INSERT INTO carta(icone, cor)
VALUES ('bicycle', 'black');

INSERT INTO carta(icone, cor)
VALUES ('train-front-fill', 'darkgray');