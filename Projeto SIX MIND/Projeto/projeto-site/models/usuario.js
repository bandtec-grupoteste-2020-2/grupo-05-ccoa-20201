'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		id: {
			field: 'idUsuario',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nome: {
			field: 'NomeCompleto',
			type: DataTypes.STRING,
			allowNull: false
		},
		cpf: {
			field: 'CPF',
			type: DataTypes.STRING,
			allowNull: false
		},
		rg: {
			field: 'RG',
			type: DataTypes.STRING,
			allowNull: false
		},
		plano: {
			field: 'Plano',
			type: DataTypes.STRING,
			allowNull: false
		},
		uf: {
			field: 'Estado',
			type: DataTypes.STRING,
			allowNull: false
		},
		city: {
			field: 'Cidade',
			type: DataTypes.STRING,
			allowNull: true
		},
		cep: {
			field: 'CEP',
			type: DataTypes.STRING,
			allowNull: false
		},
		login: {
			field: 'Email',
			type: DataTypes.STRING,
			allowNull: false
		},
		senha: {
			field: 'Senha',
			type: DataTypes.STRING,
			allowNull: false
		},
	}, 
	{
		tableName: 'usuario', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};
