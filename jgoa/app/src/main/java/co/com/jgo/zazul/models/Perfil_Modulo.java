package co.com.jgo.zazul.models;



public class Perfil_Modulo {


    private int codigo_perfil;
    private int codigo_modulo;


    public Perfil_Modulo () {

    }

    public Perfil_Modulo(int codigo_perfil, int codigo_modulo) {
        this.codigo_perfil = codigo_perfil;
        this.codigo_modulo = codigo_modulo;
    }

    // GET'S
    public int getcodigo_perfil() { return this.codigo_perfil; }

    public int getcodigo_modulo() { return this.codigo_modulo; }


    // SET'S
    public void setcodigo_perfil(int codigo_perfil) {
        this.codigo_perfil = codigo_perfil;
    }
    public void setcodigo_modulo(int codigo_modulo) {
        this.codigo_modulo = codigo_modulo;
    }






}