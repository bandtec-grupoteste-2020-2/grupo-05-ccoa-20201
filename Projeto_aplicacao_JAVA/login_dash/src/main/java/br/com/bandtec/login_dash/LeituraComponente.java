
package br.com.bandtec.login_dash;


public class LeituraComponente {
    private Integer idLeitura;
    private Integer idComponente;
    private String nomeComponente;
    private String descricao;
    private Integer idMaquinaComponente;
    private Integer ativado;
    private Double valor;

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdMaquinaComponente() {
        return idMaquinaComponente;
    }

    public void setIdMaquinaComponente(Integer idMaquinaComponente) {
        this.idMaquinaComponente = idMaquinaComponente;
    }

    public Integer getAtivado() {
        return ativado;
    }

    public void setAtivado(Integer ativado) {
        this.ativado = ativado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
}
