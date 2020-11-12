package br.com.bandtec.projeto.desktop;

public class Usuario {

    private Integer idUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;
    private String cargo;
    private String cpf;
    private Integer Empresa_idEmpresa;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getEmpresa_idEmpresa() {
        return Empresa_idEmpresa;
    }

    public void setEmpresa_idEmpresa(Integer Empresa_idEmpresa) {
        this.Empresa_idEmpresa = Empresa_idEmpresa;
    }

}
