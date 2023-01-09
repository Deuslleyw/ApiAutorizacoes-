
    create table procedimentos (
       id  bigserial not null,
        permitido varchar(3) not null,
        idade int4 not null,
        cod_procedimento int4 not null,
        sexo varchar(1) not null,
        primary key (id)
    );

    alter table procedimentos 
       add constraint cod_procedimento unique (cod_procedimento, idade, sexo);

    create table procedimentos (
       id  bigserial not null,
        permitido varchar(3) not null,
        idade int4 not null,
        cod_procedimento int4 not null,
        sexo varchar(1) not null,
        primary key (id)
    );

    alter table procedimentos 
       add constraint cod_procedimento unique (cod_procedimento, idade, sexo);

    create table procedimentos (
       id  bigserial not null,
        permitido varchar(3) not null,
        idade int4 not null,
        cod_procedimento int4 not null,
        sexo varchar(1) not null,
        primary key (id)
    );

    alter table procedimentos 
       add constraint cod_procedimento unique (cod_procedimento, idade, sexo);

    create table procedimentos (
       id  bigserial not null,
        permitido varchar(3) not null,
        idade int4 not null,
        cod_procedimento int4 not null,
        sexo varchar(1) not null,
        primary key (id)
    );

    alter table procedimentos 
       add constraint cod_procedimento unique (cod_procedimento, idade, sexo);
