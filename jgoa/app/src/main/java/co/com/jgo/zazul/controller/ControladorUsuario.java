package co.com.jgo.zazul.controller;


import co.com.jgo.zazul.models.Usuario;

/**
 * Created by jgo on 04/07/2017.
 */

public class ControladorUsuario {
    private static final ControladorUsuario controladorUsuario = new ControladorUsuario();

    private Usuario usuario;

    public static synchronized ControladorUsuario getInstance() { return controladorUsuario; }

    private ControladorUsuario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
//        this.usuario.setsenha(null);
    }
}
