
package yuiti.projeto.individual.conectado.bd;
 class Leitura {
    private Integer idLeitura;
    private String descricao;
    private Double valor;
    private String metrica;
    private String tempoLeitura;

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMetrica() {
        return metrica;
    }

    public void setMetrica(String metrica) {
        this.metrica = metrica;
    }

    public String getTempoLeitura() {
        return tempoLeitura;
    }

    public void setTempoLeitura(String tempoLeitura) {
        this.tempoLeitura = tempoLeitura;
    }
    
}
