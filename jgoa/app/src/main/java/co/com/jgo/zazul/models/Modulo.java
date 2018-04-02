package co.com.jgo.zazul.models;

import java.util.ArrayList;

public class Modulo {

    private int avatar;
    private String nickname;
    private int background;
    private int codigo,imagem,cor;
    private String nome;
    private ArrayList<String> interests = new ArrayList<>();


    public Modulo()  {

    }

    public Modulo(int codigo, String nome, int imagem, int cor ) {
        this.codigo = codigo ;
        this.nome = nome ;
        this.imagem = imagem;
        this.cor = cor;
    }

    public Modulo(int avatar, String nickname, int background) {

        this.avatar = avatar;
        this.nickname = nickname;
        this.background = background;
    }

    public Modulo(int avatar, String nickname, int background, ArrayList<String> interests) {

        this.avatar = avatar;
        this.nickname = nickname;
        this.background = background;
        this.interests = interests;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public int getBackground() {
        return background;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getImagem() {
        return imagem;
    }

    public int getCor() {
        return cor;
    }


    //public Context getApplicationContext() {
    // return this.getApplicationContext();
    // }

    public void  setAvatar( int avatar) {  this.avatar= avatar; }

    public void setNickname( String nickname) {
        this.nickname= nickname;
    }

    public void setBackground( int background) { this.background =  background; }

    public void  setCodigo( int codigo) {  this.codigo= codigo; }

    public void setNome( String nome) {
        this.nome= nome;
    }

    public void setImagem( int imagem) {
        this.imagem= imagem;
    }

    public void setCor( int cor) {
        this.cor= cor;
    }




}