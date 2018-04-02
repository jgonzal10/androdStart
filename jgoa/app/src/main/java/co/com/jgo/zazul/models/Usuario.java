package co.com.jgo.zazul.models;

import java.util.ArrayList;


public class Usuario {

    private int codigo;
    private String nome;
    private String login;
    private String senha;
    private String cpf;
    private String endereco;
    private String complemento;
    private String cep;
    private String foto;
    private String matricula;
    private int id_orgao;
    private String nome_orgao;
    private String numero_idendidade;
    private String segmento;
    private int id_grupo;
    private int id_perfil;
    private String perfil;
    private int id_cidade;
    private String nome_cidade;
    private String uf;
    private String email;
    private String dataAtualizacao;
    private String modulos;

    private ArrayList<Device> devices;

    public Usuario() {
    }

//    public Usuario(String cpf, ArrayList devices) {
//        this.cpf = cpf;
//        this.devices = devices;
//    }

    public Usuario (int codigo , String nome , String login , String senha , String cpf , String endereco , String complemento,
                    String cep, String foto, String matricula, int id_orgao, String nome_orgao, String numero_idendidade,
                    int id_grupo , int id_perfil, String nome_cidade, String uf, String modulos) {

        this.codigo = codigo;
        this.nome = nome;
        this.login =  login;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cep = cep;
        this.foto = foto;
        this.matricula = matricula;
        this.numero_idendidade= numero_idendidade;
        this.id_grupo = id_grupo;
        this.id_perfil = id_perfil;
        this.modulos = modulos;
        this.id_orgao = id_orgao;
        this.nome_orgao = nome_orgao;
        this.nome_cidade = nome_cidade;
        this.uf = uf;
    }

    // GET'S
    public  int getcodigo() { return this.codigo; }
    public String getnome() {
        return this.nome;
    }
    public String getlogin() {
        return this.login;
    }
    public String getsenha() {
        return this.senha;
    }
    public String getcpf() {
        return this.cpf;
    }
    public String getendereco() {
        return this.endereco;
    }
    public String getcomplemento() {
        return this.complemento;
    }
    public String getcep() {
        return this.cep;
    }
    public String getfoto() {
        return this.foto;
    }
    public String getmatricula() {
        return this.matricula;
    }
    public String getnumero_idendidade() {
        return this.numero_idendidade;
    }
    public String getmodulos() {
        return this.modulos;
    }
    public int getid_grupo() {
        return this.id_grupo;
    }
    public int getId_cidade() {
        return this.id_cidade;
    }
    public int getid_perfil() {
        return this.id_perfil;
    }



    // SET'S
    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public void setlogin(String login) {
        this.login = login;
    }
    public void setsenha(String senha) {
        this.senha = senha;
    }
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }
    public void setendereco(String endereco) {
        this.endereco = endereco;
    }
    public void setcomplemento(String complemento) {
        this.complemento = complemento;
    }
    public void setcep(String cep) {
        this.cep = cep;
    }
    public void setfoto(String foto) {
        this.foto = foto;
    }
    public void setmatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setnumero_idendidade(String numero_idendidade) {   this.numero_idendidade = numero_idendidade;  }
    public void setid_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public void setid_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    public void setmodulos(String modulos) {
        this.modulos = modulos;
    }

    public int getIdOrgao() {
        return id_orgao;
    }

    public void setIdOrgao(int id_orgao) {
        this.id_orgao = id_orgao;
    }

    public String getNomeOrgao() {
        return nome_orgao;
    }

    public void setNomeOrgao(String nome_orgao) {
        this.nome_orgao = nome_orgao;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getNomeCidade() {
        return nome_cidade;
    }

    public void setNomeCidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}