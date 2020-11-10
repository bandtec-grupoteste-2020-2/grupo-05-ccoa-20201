create database MAQUINAS;
use MAQUINAS;

create table Empresa(
    idEmpresa int primary key auto_increment,
    nomeEmpresa varchar(45),
    cep varchar(45),
    cnpj varchar(45)
);

create table Usuario(
    idUsuario int primary key auto_increment,
    nomeUsuario varchar(45),
    cargo varchar(45),
    cpf varchar(45) not null,
    Empresa_idEmpresa int,
    foreign key(Empresa_idEmpresa) references Empresa(idEmpresa)
);


create table Maquina(
	idMaquina int primary key auto_increment,
    ramTotal varchar(45),
    numeroNucleos varchar(45),
    tipoMaquina varchar(45),
    numeroSerial varchar(45),
    sistemaOperacional varchar(45)
    Usuario_idUsuario int,
    foreign key(Usuario_idUsuario) references Usuario(id_Usuario)
);

create table Componente(
	idComponente int primary key auto_increment,
    nomeComponente varchar(45),
    metrica varchar(45)
);

create table MaquinaComponente(
	idMaquinaComponente int primary key auto_increment,
    fkMaquina int,
    foreign key(fkMaquina) references Maquina(idMaquina),
    fkComponente int,
    foreign key(fkComponente) references Componente(idComponente),
    ativado bit,
    check (ativado = 0 or ativado = 1)
);

create table Leitura(
	idLeituras int primary key auto_increment,
    descricao varchar(45),
    valorLeitura decimal (7,2),
    tempoleitura datetime,
    fkMaquinaComponente int,
    foreign key(fkMaquinaComponente) references MaquinaComponente(idMaquinaComponente)
);

insert into MaquinaComponente (idMaquinaComponente, fkMaquina, fkComponente, Ativado) values 
	(1, 1, 0),
	(1, 2, 1), 
    (1, 3, 1),
    (1, 4, 1),
    (1, 5, 1),
    (2, 1, 1),
    (2, 2, 1), 
    (2, 3, 1),
    (2, 4, 1),
    (2, 5, 1),
    (3, 1, 1),
    (3, 2, 1),
    (3, 3, 1),
    (3, 4, 1),
    (3, 5, 1);

insert into Componente (idComponente, nomeComponente) values 
	('Disco Porcentagem', 'porcentagem'), 
    ('Disco Gb', 'Gb'),
    ('Memoria porcentagem', 'porcentagem'),
    ('Memoria Gb', 'Gb'),
    ('CPU porcentagem', 'porcentagem'),
    ('Temperatura ºC', 'ºC'),
    ('Clock Hz', 'Hz'),
    ('Rede kbps', 'kbps');

insert into Maquina values
	(null,"4", "4"),
    (null,"8", "4"),
    (null,"16", "8");
    
select * from Maquina;
select * from RamLeituras;
select * from CPULeituras;
select * from DiscosLeitura;

truncate RamLeituras;
truncate DiscosLeitura;
truncate CPULeituras;





