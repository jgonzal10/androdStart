package co.com.jgo.zazul.models;

public class Device {

    private String sistema="ZONAAZUL";
    private String cliente="ZONAAZUL";

    private String pim;
    private String imei;
    private String versao = "1.0";
    private String url_rastreio="";
    private String url_infracao="";
    private String url_consultas="";
    private String url_tabelas="";

    public Device(String pim , String imei , String versao, String url_rastreio, String url_infracao, String url_consultas, String url_tabelas) {
        this.pim = pim;
        this.imei = imei;
        this.versao = versao;
        this.url_rastreio = url_rastreio;
        this.url_infracao = url_infracao;
        this.url_consultas = url_consultas;
        this.url_tabelas = url_tabelas;
    }

    public Device( ) { }

    public void setIdentification(String pim, String imei, String versao, String url_rastreio, String url_infracao, String url_consultas, String url_tabelas) {
        this.pim = pim;
        this.imei = imei;
        this.versao = versao;
        this.url_rastreio = url_rastreio;
        this.url_infracao = url_infracao;
        this.url_consultas = url_consultas;
        this.url_tabelas = url_tabelas;
    }

    // GET'S
    public String getpim() { return this.pim;}
    public String getimei() {
        return this.imei;
    }
    public String getversao() {
        return this.versao;
    }
    public String geturlrastreio() {
        return this.url_rastreio;
    }
    public String geturlinfracao() {
        return this.url_infracao;
    }
    public String geturlconsultas() {
        return this.url_consultas;
    }
    public String geturltabelas() {
        return this.url_tabelas;
    }

    // SET'S
    public void setPim(String pim) {
        this.pim = pim;
    }
    public void setImei(String imei) {
        this.imei = imei;
    }
    public void setVersao(String versao) {
        this.versao = versao;
    }
    public void setUrlRastreio(String url_rastreio) {
        this.url_rastreio = url_rastreio;
    }
    public void setUrlInfracao(String url_infracao) {
        this.url_infracao = url_infracao;
    }
    public void setUrlConsultas(String url_consultas) {
        this.url_consultas = url_consultas;
    }
    public void setUrlTabelas(String url_tabelas) {
        this.url_tabelas = url_tabelas;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}