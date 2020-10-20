/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.login_dash;

/**
 *
<<<<<<< Updated upstream
 * @author SixMinds
 */
public class Usuario {
    private Integer IdUsario;
    private String nomeUsuario;
=======
 * @author User
 */
public class Usuario {
    private Integer idUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;
>>>>>>> Stashed changes
    private String cargo;
    private String cpf;
    private Integer Empresa_idEmpresa;

<<<<<<< Updated upstream
    public Usuario(Integer IdUsario, String nomeUsuario, String cargo, String cpf, Integer Empresa_idEmpresa) {
        this.IdUsario = IdUsario;
        this.nomeUsuario = nomeUsuario;
        this.cargo = cargo;
        this.cpf = cpf;
        this.Empresa_idEmpresa = Empresa_idEmpresa;
    }

    public Integer getIdUsario() {
        return IdUsario;
=======
//    public Usuario(Integer idUsuario, String nomeUsuario, String cargo, String cpf, Integer Empresa_idEmpresa) {
//        this.idUsuario = idUsuario;
//        this.nomeUsuario = nomeUsuario;
//        this.cargo = cargo;
//        this.cpf = cpf;
//        this.Empresa_idEmpresa = Empresa_idEmpresa;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
>>>>>>> Stashed changes
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

<<<<<<< Updated upstream
=======
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

>>>>>>> Stashed changes
    public String getCargo() {
        return cargo;
    }

<<<<<<< Updated upstream
=======
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

>>>>>>> Stashed changes
    public String getCpf() {
        return cpf;
    }

<<<<<<< Updated upstream
    public Integer getEmpresa_idEmpresa() {
        return Empresa_idEmpresa;
    }
=======
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getEmpresa_idEmpresa() {
        return Empresa_idEmpresa;
    }

    public void setEmpresa_idEmpresa(Integer Empresa_idEmpresa) {
        this.Empresa_idEmpresa = Empresa_idEmpresa;
    }
    
>>>>>>> Stashed changes
    
}
