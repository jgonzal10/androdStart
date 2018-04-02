package co.com.jgo.zazul.models;


import java.util.ArrayList;
import java.util.List;

public class Perfil {

    private int codigo;
    private String nome;
    private  int codigousuario ;
    private List<String> modulos = new ArrayList<>();



    public Perfil () {

    }

    public Perfil(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // GET'S
    public int getcodigo() { return this.codigo;
    }
    public String getnome() { return this.nome; }
    public int getcodigousuario() { return this.codigousuario; }


    // SET'S
    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }


}