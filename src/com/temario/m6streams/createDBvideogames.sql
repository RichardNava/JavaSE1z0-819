drop table videogames;
drop sequence pid_seq restrict;
create table videogames(
    id  INT PRIMARY KEY,
    nombre VARCHAR (40) NOT NULL,
    genero VARCHAR (40) NOT NULL,
    valoracion NUMERIC (10,2),
    jugado BOOLEAN,
    version INT DEFAULT 1);
create sequence pid_seq as int start with 1 increment by 1 no cycle;