
DROP DATABASE IF EXISTS MAQUINAS;
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
    email varchar(45),
    senha varchar(45),
    cargo varchar(45),
    cpf char(11) not null,
    Empresa_idEmpresa int,
    foreign key(Empresa_idEmpresa) references Empresa(idEmpresa));


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
    foreign key (fkComponente) references Componente (idComponente),
    ativado bit,
    minimo double(6,2),
    maximo double(6,2)
);

create table Leitura(
	idLeitura int primary key auto_increment,
    fkMaquinaComponente int,
    foreign key(fkMaquinaComponente) references MaquinaComponente (idMaquinaComponente),
    valor decimal(6,2),
    tempoLeitura datetime,
    descricao varchar(45)-- ,
  --  idchamado_jira varchar(7)
);

create table Clima (
idClima int primary key auto_increment,
dia date,
minimo int,
maximo int
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
    (null,'João','joão@joão.com','123','Analista','50xxxxxx','1'),
    (null,'Joana','joana@ig.com','123','Analista','50xxxxxx','1'),
    (null,'Yuiti','thiago@japao.com','123','Gerente','50xxxxxx','1');
    
insert into Maquina values
	(null,"4", "4","IOT","15000","Windows",1),
    (null,"8", "4","Usuário","16000","Windows",1),
    (null,"16", "8","Servidor","16000","Windows",1);


insert into MaquinaComponente (fkMaquina,fkComponente, ativado,minimo,maximo) values
(1,1,0,5,30),-- CPU uso 
(1,2,0,35,50),-- CPU temperatura
(1,3,0,2000,4000), -- CPU Clock
(1,4,1,40,90),-- Disco %
(1,5,1,30,40),-- Disco tempartura
(1,6,1,20,60),-- Memoria uso %
(1,7,1,2,8),-- Memoria uso em GB
(1,8,1,2,8),-- Memoria livrem em GB
(2,1,1,10,40),
(2,2,1,35,50),
(2,3,1,2000,4000),
(2,4,0,30,80),
(2,5,0,30,40),
(2,6,1,20,60),
(2,7,1,1,4),
(2,8,1,1,4),
(3,1,1,20,80),
(3,2,1,35,80),
(3,3,1,2000,6000),
(3,4,1,50,95),
(3,5,1,30,60),
(3,6,0,30,80),
(3,7,0,4,10),
(3,8,0,4,10);

select * from Empresa;
select * from Usuario;
select * from Maquina;
desc Maquina;
select * from Componente;
select * from MaquinaComponente;
select * from Leitura order by idLeitura desc ;
-- alter table MaquinaComponente add column ativado bit;
-- update MaquinaComponente set ativado = 1 where idMaquinaComponente>=1;
update  Maquina set numeroNucleos=6 where idMaquina=2;
update  Maquina set ramTotal=16 where idMaquina=2;
select * from Leitura where descricao like "CPU%" order by idLeitura desc limit 6;
select count(distinct(descricao)) from Leitura where descricao like "CPU%";
select * from Leitura;
select count(distinct(descricao)) as nucleos from Leitura where descricao like "Core%";
select * from Leitura where descricao like "Core%" order by idLeitura desc limit 6;
-- todas as Leituras
select Leitura.idLeitura, Maquina.tipoMaquina, Leitura.descricao, Leitura.valor, Componente.metrica
from Maquina, Leitura, Componente, MaquinaComponente 
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3
order by idLeitura ; 
-- Leituras apenas dos núcleos, e da máquina 1
select Leitura.idLeitura, Maquina.tipoMaquina, Leitura.descricao, Leitura.valor, Componente.metrica
from Maquina, Leitura, Componente, MaquinaComponente 
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=1 and descricao like "Core%" and metrica = '%'
order by idLeitura ; 
-- Leitura com a temperatura maximo e minima do dia, so pega as informações no qual pegou também as informações da temperatura do mesmo dia. Esse é o que usado para criar os CSV
select Leitura.idLeitura, Maquina.tipoMaquina, Leitura.descricao, Leitura.valor, Componente.metrica, CAST(tempoLeitura AS DATE) as dataLeitura
from Maquina, Leitura, Componente, MaquinaComponente, Clima
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente  and dia=CAST(tempoLeitura AS DATE)
order by idLeitura ; 
-- faz uma média das Leitura do dia, 
select  Maquina.tipoMaquina, Leitura.descricao, round(avg(Leitura.valor),2) as media, Componente.metrica, CAST(tempoLeitura AS DATE) as dataLeitura,minimo,maximo
from Maquina, Leitura, Componente, MaquinaComponente, Clima
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=1 and descricao like "Core%" and metrica = '%' and dia=CAST(tempoLeitura AS DATE)
group by CAST(tempoLeitura AS DATE); 
select valor as media
from Maquina, Leitura, Componente, MaquinaComponente 
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=2 and descricao like "Core%" and metrica = '%'
order by idLeitura desc ;
-- truncate Leitura;
select * from  Clima;
select * from Componente;