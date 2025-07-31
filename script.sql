create table tarefas (
	id serial primary key,
	nome_tarefa varchar(250) not null,
	desc_tarefa varchar(250) not null,
	data_limite DATE,
	prioridade varchar(250),
	status varchar(250),
	usuario_id int REFERENCES usuario(id)
	ON DELETE CASCADE ON UPDATE CASCADE 
)

create table usuario (
	id serial primary key,
	nome varchar(250) not null,
	idade integer not null,
	email varchar(250) not null
)

select * from usuario
select * from tarefas
drop table tarefas