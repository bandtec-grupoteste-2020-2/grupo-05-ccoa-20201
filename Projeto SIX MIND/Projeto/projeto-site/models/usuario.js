'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		id: {
			field: 'idCliente',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nome: {
			field: 'nomeCliente',
			type: DataTypes.VARCHAR,
			allowNull: false
		},
		senha: {
			field: 'senha',
			type: DataTypes.TEXT,
			allowNull: false
		},
		email: {
			field: 'email',
			type: DataTypes.TEXT,
			allowNull: false
		},
		telefone: {
			field: 'telefone',
			type: DataTypes.CHAR,
			allowNull: false
		},
		celular: {
			field: 'celular',
			type: DataTypes.CHAR,
			allowNull: false
		},
		CPF: {
			field: 'CPF',
			type: DataTypes.CHAR,
			allowNull: true
		},
		CNPJ: {
			field: 'CNPJ',
			type: DataTypes.CHAR,
			allowNull: false
		},
	}, 
	{
		tableName: 'Cliente', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};
