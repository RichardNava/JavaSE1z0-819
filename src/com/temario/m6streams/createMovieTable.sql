drop table movies;
create table movies(
    id  INT NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    title VARCHAR (80) NOT NULL,
    director VARCHAR (40) NOT NULL,
    genre VARCHAR (40) NOT NULL,
    pegi VARCHAR (40) NOT NULL,
    launchyear INT NOT NULL,
    rating NUMERIC (10,2),
    awards BOOLEAN,
    watched BOOLEAN);

