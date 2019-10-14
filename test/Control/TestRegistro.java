/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wilde
 */
public class TestRegistro {
    
    public static ValidarRegistro validarRegistro = new ValidarRegistro();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String USUARIO_EXISTE = "Este usuario ya existe";
    private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
    private String PASSWORD_NO_COINCIDE = "Las contraseñas no coinciden";
    private String USUARIO_REGISTRADO = "Usuario registrado con exito";
    
    public TestRegistro() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();

        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");

        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);

        sistema.setUsuarios(usuarios);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testLongitudNombre(){
        Usuario u = new Usuario();
        String validarContrasenia;
        u.setNombre("g");
        u.setPassword("123456");
        validarContrasenia = "123456";
        assertEquals(validarRegistro.verificarRegistro(u, validarContrasenia), LONG_NOMBRE_INCORRECTA);
        
        u.setNombre("gustavo");
        u.setPassword("123456");
        validarContrasenia = "1234";
        assertEquals(validarRegistro.verificarRegistro(u, validarContrasenia), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testUsuarioExiste(){
        Usuario u = new Usuario();
        String validarContrasenia;
        u.setNombre("juan");
        u.setPassword("123456");
        validarContrasenia = "123456";
        assertEquals(validarRegistro.verificarRegistro(u, validarContrasenia), USUARIO_EXISTE);
    }
    
    @Test
    public void testLongitudPassword(){
        Usuario u = new Usuario();
        String validarContrasenia;
        u.setNombre("luis");
        u.setPassword("12");
        validarContrasenia = "1234";
        assertEquals(validarRegistro.verificarRegistro(u, validarContrasenia), LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("luis");
        u.setPassword("123456");
        validarContrasenia = "123456";
        assertEquals(validarRegistro.verificarRegistro(u, validarContrasenia), LONG_PASSWORD_INCORRECTA);
    }
    
   @Test
   public void testPasswordCoincide(){
        Usuario u = new Usuario();
        String validarContrasenia;
        u.setNombre("raul");
        u.setPassword("1234");
        validarContrasenia = "123";
        assertEquals(validarRegistro.verificarRegistro(u, validarContrasenia), PASSWORD_NO_COINCIDE);
   }
   
   @Test
   public void testTodoCorrecto(){
        Usuario u = new Usuario();
        String validarContrasenia;
        u.setNombre("raul");
        u.setPassword("1234");
        validarContrasenia = "1234";
        assertEquals(validarRegistro.verificarRegistro(u, validarContrasenia), USUARIO_REGISTRADO);
   }
}
