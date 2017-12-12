/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
     private String mail;
    private String contraseña;
    private String nombre;
    List<Error> errores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public List<Error> getErrores() {
        return errores;
    }

    public Usuario(String mail, String contraseña, String nombre) {
        this.mail = mail;
        this.contraseña = contraseña;
        this.nombre = nombre;
        errores= new ArrayList<>();
    }
    

    public Usuario(String mail, String contraseña) {
        this.mail = mail;
        this.contraseña = contraseña;
        errores= new ArrayList<>();
    }
    
   

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public void AgregarError(Error error){    
        errores.add(error);
    }
    public boolean ExisteError(){
    return !errores.isEmpty();
    }
    
    
}
