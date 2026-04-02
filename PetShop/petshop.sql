create table pessoa (
	id serial primary key,
	nome varchar(64) not null,
	data_nascimento date not null
);

create table pet (
	id serial primary key,
	nome varchar(63) not null,
	data_nascimento date not null,
	raca varchar(31) not null,
	cor varchar(31) not null,
	porte varchar(15) not null,
	pessoa_id int not null,
		constraint fk_pet_pessoa foreign key(id) references pessoa(id)
		on delete cascade on update cascade
);