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

create table RamLeituras(
	idLeituraRam int primary key auto_increment,
    ramPorcentagem varchar(45),
    ramUsadaGb int,
    tempoLeitura varchar(45),
    fkMaquina int,
    foreign key(fkMaquina) references Maquina(idMaquina)
);

create table DiscosLeitura(
	idLeituraDisco int primary key auto_increment,
    discoNome varchar(45),
    discoPercentual varchar(45),
    tempoLeitura varchar(45),
    fkMaquina int,
    foreign key(fkMaquina) references Maquina(idMaquina)
);

create table CPULeituras(
	idLeituraCPU int primary key auto_increment,
    nomeCPU varchar(45),
    CPUPorcentagem varchar(45),
    tempoLeitura varchar(45),
    fkMaquina int,
    foreign key(fkMaquina) references Maquina(idMaquina)
);

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
