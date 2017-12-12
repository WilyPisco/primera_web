/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class ConexionDAO {
    public Usuario Existe( Usuario u){
        
    if(u.getMail().equalsIgnoreCase("wilyrps93@gmail.com")){        
        if(u.getContraseña().equalsIgnoreCase("1234")){
            return new Usuario(u.getMail(),u.getContraseña(),"WILMER");
        }
        else{
            Usuario nuevoUsuario=new Usuario(u.getMail(),u.getContraseña(),"WILMER");
            nuevoUsuario.AgregarError(new Error(100,"Contraseña Incorrecta"));
            return nuevoUsuario;
        }
    }else{
        Usuario nuevoUsuario=new Usuario(u.getMail(),u.getContraseña(),"WILMER");
            nuevoUsuario.AgregarError(new Error(100,"Correo Electronico Incorrecto"));
            return nuevoUsuario;
        }
       
    }
}
