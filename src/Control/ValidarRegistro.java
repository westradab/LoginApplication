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
    
    public String verificarRegistro(Usuario usuario, String validarContrasenia){
        if(!verificarLongitudNombre(usuario.getNombre())){
            return("longitud nombre incorrecta");
        }
        if(!verificarLongitudPassword(usuario.getPassword())){
            return("Longitud contraseña incorrecta");
        }
        if(!verificarCoincidenciaContrasenia(usuario.getPassword(), validarContrasenia)){
            return("Las contraseñas no coinciden");
        }
        if(verificarUsuarioRegistrado(usuario)){
            return("Este usuario ya esta registrado");
        }
        sistema.getUsuarios().add(usuario);
        return("Usuario Registrado con exito");
    }
    
    public boolean verificarLongitudNombre(String nombre){
        return(nombre.length() > 1 && nombre.length() <= 6);
    }
    
    public boolean verificarLongitudPassword(String password){
        return(password.length() >= 3 && password.length() < 6);
    }
    
    public boolean verificarCoincidenciaContrasenia(String contrasenia, String validarContrasenia){
        return contrasenia.equals(validarContrasenia);
    }
    
    public boolean verificarUsuarioRegistrado(Usuario usuario){
        for(Usuario u : sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre())){
                return(true);
            }
        }
        return(false);
    }
}
