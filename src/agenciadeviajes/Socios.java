package agenciadeviajes;

import java.io.Serializable;
import java.util.Scanner;

public class Socios extends Personas implements Serializable{
	
	/**
	 * La clase Socios representa a los socios de la agencia.
	 * Esta clase es una subclase de la clase Personas.
	 */
	private static final long serialVersionUID = 1L;
	private int numSocio;
	
	public Socios() {
    	super();
    	this.numSocio = 0;
    }
    public Socios(Socios s) {
    	super(s);
    	this.numSocio = s.numSocio;
    }
    
	public Socios(String dni, String nombre, String apellido1, String apellido2, int edad, String telefono, String email, int numSocio) {
		super(dni, nombre, apellido1, apellido2, edad, telefono, email);
		this.numSocio = numSocio;
	}

	
	public int getNumSocio() {
		return numSocio;
	}

	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}
	
	@Override
	public String toString() {
	    return "Socio  [Número de Socio: " + numSocio + "]";
	}

	@Override
	public void print() {
		System.out.println("DNI: " + this.getDni());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido1: " + this.getApellido1());
        System.out.println("Apellido2: " + this.getApellido2());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Teléfono: " + this.getTelefono());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Número de Socio: " + this.numSocio);
	}

}



