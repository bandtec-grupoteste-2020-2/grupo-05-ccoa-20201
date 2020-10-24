
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

create table Clima (
idclima int primary key auto_increment,
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

select * from Empresa;
select * from Usuario;
select * from Maquina;
desc maquina;
select * from Componente;
select * from MaquinaComponente;
select * from leitura order by idLeitura desc ;
alter table maquinacomponente add column ativado bit;
update MaquinaComponente set ativado = 1 where idmaquinacomponente>=1;
update  maquina set numeroNucleos=6 where idmaquina=2;
update  maquina set ramTotal=16 where idmaquina=2;
select * from leitura where descricao like "CPU%" order by idleitura desc limit 6;
select count(distinct(descricao)) from leitura where descricao like "CPU%";
select * from leitura;
select count(distinct(descricao)) as nucleos from leitura where descricao like "Core%";
select * from leitura where descricao like "Core%" order by idleitura desc limit 6;
-- todas as leituras
select leitura.idLeitura, maquina.tipoMaquina, leitura.descricao, leitura.valor, componente.metrica
from maquina, leitura, componente, maquinaComponente 
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idmaquina=3
order by idLeitura ; 
-- leituras apenas dos núcleos, e da máquina 1
select leitura.idLeitura, maquina.tipoMaquina, leitura.descricao, leitura.valor, componente.metrica
from maquina, leitura, componente, maquinaComponente 
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idmaquina=1 and descricao like "Core%" and metrica = '%'
order by idLeitura ; 
-- leitura com a temperatura maximo e minima do dia, so pega as informações no qual pegou também as informações da temperatura do mesmo dia. Esse é o que usado para criar os CSV
select leitura.idLeitura, maquina.tipoMaquina, leitura.descricao, leitura.valor, componente.metrica, CAST(tempoleitura AS DATE) as dataleitura,minimo,maximo
from maquina, leitura, componente, maquinaComponente ,clima
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idmaquina=1  and dia=CAST(tempoleitura AS DATE)
order by idLeitura ; 
-- faz uma média das leitura do dia, 
select  maquina.tipoMaquina, leitura.descricao, round(avg(leitura.valor),2) as media, componente.metrica, CAST(tempoleitura AS DATE) as dataleitura,minimo,maximo
from maquina, leitura, componente, maquinaComponente,clima
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idmaquina=1 and descricao like "Core%" and metrica = '%' and dia=CAST(tempoleitura AS DATE)
group by CAST(tempoleitura AS DATE); 
select valor as media
from maquina, leitura, componente, maquinaComponente 
where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idmaquina=2 and descricao like "Core%" and metrica = '%'
order by idLeitura desc ;
truncate leitura;
select * from  Clima;
