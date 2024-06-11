package com.ejercicio_3.clases;

public class Usuario {

    private String nombre;
    private String telefono;
    private String correoElectronico;

    public Usuario(String correoElectronico, String nombre, String telefono) {
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }



    public String getTelefono() {
        return telefono;
    }



    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    @Override
    public String toString() {
        return " Nombre = " + nombre + "\n" +
         " Telefono = " + telefono + "\n" +
         " correoElectronico = " + correoElectronico;
    }
    
   
}
