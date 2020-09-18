drop database MAQUINAS;
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
    sistemaOperacional varchar(45),
    Usuario_idUsuario int,
    foreign key(Usuario_idUsuario) references Usuario(idUsuario)
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

insert into Empresa values
	(null,'SixMinds','09505050','45646494161');
 
insert into Usuario values
	(null,'João','Analista','50xxxxxx','1'),
    (null,'Joana','Analista','50xxxxxx','1'),
    (null,'Yuiti','Gerente','50xxxxxx','1');
    



insert into Maquina values
	(null,"4", "4","IOT","15000","Windows",1),
    (null,"8", "4","Usuário","16000","Windows",1),
    (null,"16", "8","Servidor","16000","Windows",1);
   
select * from Maquina;
select * from RamLeituras;
select * from CPULeituras;
select * from DiscosLeitura;

truncate RamLeituras;
truncate DiscosLeitura;
truncate CPULeituras;
