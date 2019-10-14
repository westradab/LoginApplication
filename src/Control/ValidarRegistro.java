/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author ESTRADA
 */
public class ValidarRegistro {

    private Sistema sistema = FramePrincipal.sistema;

    public ValidarRegistro() {
    }

    public String verificarRegistro(Usuario usuario, String validarContrasenia) {
        if (!verificarLongitudNombre(usuario.getNombre())) {
            return ("Longitud nombre incorrecta");
        }
        if (verificarUsuarioExiste(usuario)) {
            return ("Este usuario ya existe");
        }
        if (!verificarLongitudPassword(usuario.getPassword())) {
            return ("Longitud contraseña incorrecta");
        }
        if (!verificarPasswordCoincide(usuario.getPassword(), validarContrasenia)) {
            return ("Las contraseñas no coinciden");
        }
        sistema.getUsuarios().add(usuario);
        return ("Usuario registrado con exito");
    }

    public boolean verificarLongitudNombre(String nombre) {
        return (nombre.length() > 1 && nombre.length() <= 6);
    }
    
    public boolean verificarUsuarioExiste(Usuario usuario) {
        for (Usuario u : sistema.getUsuarios()) {
            if (u.getNombre().equals(usuario.getNombre())) {
                return (true);
            }
        }
        return (false);
    }
    
    public boolean verificarLongitudPassword(String password) {
        return (password.length() >= 3 && password.length() < 6);
    }

    public boolean verificarPasswordCoincide(String contrasenia, String validarContrasenia) {
        return contrasenia.equals(validarContrasenia);
    }

}
