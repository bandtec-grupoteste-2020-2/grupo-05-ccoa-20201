/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.login_dash;

/**
 *
 * @author SixMinds
 */
public class Usuario {
    private Integer IdUsario;
    private String nomeUsuario;
    private String cargo;
    private String cpf;
    private Integer Empresa_idEmpresa;

    public Usuario(Integer IdUsario, String nomeUsuario, String cargo, String cpf, Integer Empresa_idEmpresa) {
        this.IdUsario = IdUsario;
        this.nomeUsuario = nomeUsuario;
        this.cargo = cargo;
        this.cpf = cpf;
        this.Empresa_idEmpresa = Empresa_idEmpresa;
    }

    public Integer getIdUsario() {
        return IdUsario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getEmpresa_idEmpresa() {
        return Empresa_idEmpresa;
    }
    
}
