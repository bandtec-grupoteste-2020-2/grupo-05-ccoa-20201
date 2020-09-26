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

create table Componente(
	idComponente int primary key auto_increment,
    nomeComponente varchar(45),
    metrica varchar(45)
);


create table Leitura(
	idLeitura int primary key auto_increment,
    fkMaquina int,
    foreign key(fkMaquina) references Maquina(idMaquina),
    fkComponente int,
    foreign key(fkComponente) references Componente(idComponente),
    descricao varchar(45),
    valor decimal(4,2),
    tempoLeitura datetime,
    estado varchar(45)
);

insert into Componente(nomeComponente, metrica) values
	("CPU", "%"),
    ("Disco", "%"),
    ("Memória", "%"),
    ("MemóriaGB", "GB");


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
select * from Componente;
select * from leitura order by idLeitura desc;
select * from componente, leitura where fkComponente=idComponente;
truncate leitura;
