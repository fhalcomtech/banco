create extension pgcrypto;
\connect banco
create schema banco;
alter schema banco owner to banco;

create table banco.persona(
                              id serial not null,
                              identificacion varchar(30) not null unique,
                              nombre varchar(200),
                              genero varchar(100),
                              edad smallint,
                              direccion varchar(300),
                              telefono varchar(50),
                              primary key (id)
);

insert into banco.persona
(identificacion, nombre, genero, edad, direccion, telefono)
values
    ('0923970503', 'Fidel Lascano', 'masculino', 30, 'Trinitaria', '0923970503');

insert into banco.persona
(identificacion, nombre, genero, edad, direccion, telefono)
values
    ('0923970504', 'Juan Herrera', 'masculino', 30, 'Trinitaria', '0981522065');
commit;

create type banco.estado_cliente as enum('activo', 'inactivo');

create table banco.cliente(
                              id serial not null,
                              clave varchar(30),
                              estado banco.estado_cliente default 'inactivo',
                              persona_id integer unique,
                              primary key (id),
                              constraint fk_persona
                                  foreign key(persona_id)
                                      references banco.persona(id)
);

insert into banco.cliente(clave, persona_id)
values ('clave1',1);

insert into banco.cliente(clave, persona_id)
values ('clave2',2);
commit;

create type banco.tipo_cuenta as enum('ahorro', 'corriente');
create type banco.estado_cuenta as enum('activo', 'inactivo');

create table banco.cuenta(
                             numero varchar(20) not null,
                             tipo banco.tipo_cuenta not null,
                             saldo numeric(10,2) not null default 0,
                             estado banco.estado_cuenta not null default 'inactivo',
                             constraint pk_cuenta primary key (numero)
);

insert into banco.cuenta(numero, tipo, saldo) values ('0123456789','ahorro',100.10);
insert into banco.cuenta(numero, tipo, saldo) values ('1122446689','ahorro',555.55);
commit;

create table banco.cuenta_cliente(
                                     id serial not null,
                                     cliente_id Integer not null,
                                     cuenta_numero varchar(20) not null,
                                     primary key (id),

                                     constraint fk_cuenta_cliente
                                         foreign key(cliente_id)
                                             references banco.cliente(id),

                                     constraint fk_cuenta_numero
                                         foreign key(cuenta_numero)
                                             references banco.cuenta(numero)
);

insert into banco.cuenta_cliente(cliente_id, cuenta_numero) values (1,'0123456789');
insert into banco.cuenta_cliente(cliente_id, cuenta_numero) values (2,'1122446689');
commit;

create type banco.tipo_movimiento as enum('ingreso', 'egreso');
create table banco.movimiento(
                                 id serial not null,
                                 fecha timestamp default CURRENT_TIMESTAMP not null,
                                 tipo banco.tipo_movimiento not null ,
                                 valor numeric(10,2) not null,
                                 saldo numeric(10,0) not null,
                                 cuenta_id varchar(20) not null,
                                 primary key (id),

                                 constraint fk_cuenta_move
                                     foreign key(cuenta_id)
                                         references banco.cuenta(numero)
);

insert into banco.movimiento(tipo, valor, saldo, cuenta_id)
values ('ingreso', 10.00, 110.10,'0123456789');

insert into banco.movimiento(tipo, valor, saldo, cuenta_id)
values ('egreso', 100.00, 455.55,'0123456789');