create table dept(
    id serial primary key,
    nome varchar(64) not null
);

create table func(
    id serial primary key,
    id_dept int not null,
        constraint fk_func_dept foreign key(id_dept) references dept(id)
        on delete cascade on update cascade,
    nome varchar(64) not null,
    nascimento date not null,
    salario double precision not null
);

insert into dept(nome) values
    ('TI'), ('RH'), ('Financeiro');

/*

create table pessoa (
    id serial primary key,
    nome varchar(64) not null,
    cpf varchar(14) not null unique,
    email varchar(64) not null unique,
    contato varchar(64) not null
);

create table evento (
    id serial primary key,
    nome varchar(64) not null,
    data_inicio date not null,
    data_termino date not null
);

create table participante (
    id_pessoa int not null,
		constraint fk_participante_pessoa foreign key(id_pessoa) references pessoa(id)
        on delete cascade on update cascade,
    id_evento int not null,
		constraint fk_participante_evento foreign key(id_evento) references evento(id)
        on delete cascade on update cascade,
    primary key (id_pessoa, id_evento)
);

insert into pessoa(nome, cpf, email, contato) values
    ('AUGUSTO ALEX CAIXETA SILVA', '123.456.789-00', 'augusto.caixeta@estudante.iftm.edu.br', '(34) 9 8854-9615'),
    ('BRUNO DE CARVALHO FERREIRA', '001-234-567-89', 'bruno.carvalho@estudante.iftm.edu.br', '(34) 9 9957-1617'),
    ('DIEGO CARDOSO DA SILVA', '123.321.456-78', 'diego.cardoso@estudante.iftm.edu.br', '(34) 9 9805-1122');

insert into evento(nome, data_inicio, data_termino) values
    ('MINI MARATONA DE PROGRAMAÇÃO', '2025-09-30', '2025-09-30'),
    ('ARTETERAPIA', '2025-09-28', '2025-09-28'),
    ('INTELIGÊNCIA ARTIFICIAL', '2025-09-28', '2025-09-28');

*/