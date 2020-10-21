CREATE DATABASE MAQUINAS;
use MAQUINAS;
-- drop database Maquinas;
create table Empresa(
    idEmpresa int primary key auto_increment,
    nomeEmpresa varchar(45),
    cep char(8),
    cnpj char(14)
);

create table Usuario(
    idUsuario int primary key auto_increment,
    nomeUsuario varchar(45),
    cargo varchar(45),
    cpf char(11) not null,
    Empresa_idEmpresa int,
    foreign key(Empresa_idEmpresa) references Empresa(idEmpresa)
);


create table Maquina(
	idMaquina int primary key auto_increment,
    ramTotal decimal(5,2),
    numeroNucleos varchar(45),
    tipoMaquina varchar(45),
    numeroSerial varchar(45),
    sistemaOperacional varchar(45),
    Usuario_idUsuario int,
    foreign key(Usuario_idUsuario) references Usuario(idUsuario)
);

create table Componente(
	idComponente int primary key auto_increment,
    nomeComponente varchar(45),
    metrica varchar(45)
);

create table MaquinaComponente(
	idMaquinaComponente int primary key auto_increment,
    fkMaquina int,
    foreign key (fkMaquina) references Maquina (idMaquina),
    fkComponente int,
    foreign key (fkComponente) references Componente (idComponente)
);

create table Leitura(
	idLeitura int primary key auto_increment,
    fkMaquinaComponente int,
    foreign key(fkMaquinaComponente) references MaquinaComponente (idMaquinaComponente),
    valor decimal(6,2),
    tempoLeitura datetime,
    descricao varchar(45)
);


insert into Componente(nomeComponente, metrica) values
	("CPU_uso", "%"),
	("CPU_temperatura", "°C"),
	("CPU_clock", "MHz"),
    -- ("CPU_potencia", "W"),
    ("Disco_uso", "%"),
    ("Disco_temperatura", "°C"),
    -- ("Disco", "%"),
    ("Memória_uso", "%"),
    ("Memória_uso_gb", "GB"),
    ("Memória_livre_gb", "GB");
    -- ("MemóriaGB", "GB");


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
   
select * from Empresa;
select * from Usuario;
select * from Maquina;
desc maquina;
select * from Componente;
select * from MaquinaComponente;

select * from leitura order by idLeitura desc limit 1;


select * from leitura where descricao = "CPU_0" order by idleitura desc limit 1;
select count(distinct(descricao)) from leitura where descricao like "CPU%";
select * from leitura;
select leitura.idLeitura, maquina.tipoMaquina, leitura.descricao, leitura.valor,componente.metrica, leitura.tempoLeitura from maquina, leitura, componente, maquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente order by idLeitura; 

insert into maquinacomponente (fkmaquina,fkcomponente)values
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(2,1),
(2,2),
(2,3),
(2,4),
(2,5),
(2,6),
(2,7),
(2,8),
(3,1),
(3,2),
(3,3),
(3,4),
(3,5),
(3,6),
(3,7),
(3,8);
truncate leitura;
