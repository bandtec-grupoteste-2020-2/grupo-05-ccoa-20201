
package yuiti.projeto.individual.conectado.bd;


public class Maquina {
    private Integer idMaquina;
    private Double ramTotal;
    private Integer numeroNucleos;
    private String tipoMaquina;
    private Integer numeroSerial;
    private String sistemaOperacional;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Double getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(Double ramTotal) {
        this.ramTotal = ramTotal;
    }

    public Integer getNumeroNucleos() {
        return numeroNucleos;
    }

    public void setNumeroNucleos(Integer numeroNucleos) {
        this.numeroNucleos = numeroNucleos;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public Integer getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(Integer numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }
    
    
}
