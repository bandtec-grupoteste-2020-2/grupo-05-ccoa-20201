create database SixMinds;
use SixMinds;

create table Cliente
(
	idCliente int primary key auto_increment,
    Senha text,
    NomeCliente varchar (45),
    Email text,
    Telefone char (10),
    Celular char (11),
    CPF char (11),
    CNPJ char (14)
);

create table Plantacao
(
	idArea int primary key auto_increment,
    fkCliente int,
    foreign key (fkCliente) references Cliente(idCliente),
    Plano varchar (45),
    Bioma varchar (45),
    Cultivo varchar (45),
    CEP char (8)
);

create table CorpoSensor
(
	idSensor int primary key auto_increment,
    fkArea int,
    foreign key (fkArea) references Plantacao(idArea)
);


create table DadosSolo
(
	idDadosSolo int,
    fkSensor int,
    foreign key (fkSensor) references CorpoSensor(idSensor),
    primary key (fkSensor, idDadosSolo),
    DadoTempo datetime,
    Temperatura decimal (5,2),
    Umidade decimal (5,2)
);
    
create table DadosAr
(
	idDadosAr int,
    fkSensor int,
    foreign key (fkSensor) references CorpoSensor(idSensor),
    primary key (fkSensor, idDadosAr),
    DadoTempo datetime,
    Temperatura decimal (5,2),
    Umidade decimal (5,2)
);
 
    