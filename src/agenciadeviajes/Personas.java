package agenciadeviajes;

import java.util.Scanner;

public abstract class Personas {
	/**

	La clase abstracta Personas representa a una persona con su información básica
	como DNI, nombre, apellidos, edad, teléfono y correo electrónico.
	Esta clase cuenta con constructores para inicializar los atributos, métodos para
	acceder y modificar dichos atributos, y un método abstracto para imprimir información
	específica de la persona (implementado en las clases hijas).
	*/
	
    protected String dni;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected int edad;
    protected String telefono;
    protected String email;
    
    public Personas () {
    	 
    }
    public Personas(Personas p) {
    	 this.dni = p.dni;
         this.nombre = p.nombre;
         this.apellido1 = p.apellido1;
         this.apellido2 = p.apellido2;
         this.edad = p.edad;
         this.telefono = p.telefono;
         this.email = p.email;
    }

    public Personas(String dni, String nombre, String apellido1, String apellido2, int edad, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "Personas [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", edad=" + edad + ", telefono=" + telefono + ", email=" + email + "]";
	}
	public abstract void print();

}
    


