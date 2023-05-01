package agenciadeviajes;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservasH implements DescuentoSocio{
	/**

	La clase ReservasH representa una reserva de hotel realizada por un usuario,
	la cual contiene información sobre el usuario, el hotel, el número de reserva y la fecha de la reserva.
	También implementa la interfaz DescuentoSocio para aplicar descuentos a las reservas realizadas por los socios.
	*/
	
    private String dni;
    private String codH;
    private int numRH;
    private LocalDate fechaRH;
    
    public ReservasH() {
    	this.dni = "";
        this.codH = "";
        this.numRH= 0;
        this.fechaRH = null;
   	}

    // Constructor que recibe los parámetros necesarios para crear una reserva
    public ReservasH(String dni,  String codH, int numRH, LocalDate fechaRH) {
        this.dni = dni;
        this.codH = codH;
        this.numRH= numRH;
        this.fechaRH = fechaRH;
    }
    
	public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getCodH() {
		return codH;
	}

	public void setCodH(String codH) {
		this.codH = codH;
	}

    public void setNumRH(int numRH) {
        this.numRH = numRH;
    }
	public int getNumRH() {
		return numRH;
	}

	public LocalDate getFechaRH() {
		return fechaRH;
	}

	public void setFechaRH(LocalDate fechaRH) {
		this.fechaRH = fechaRH;
	}

	@Override
	public String toString() {
		return "ReservasH [dni=" + dni + ", codH=" + codH + ", numRH=" + numRH + ", fechaRH=" + fechaRH + "]";
	}
	
	public void print() {
		
		System.out.println("---Datos ReservaH---");
		System.out.println("Dni usuario:" + this.dni);
		System.out.println("Código del Hotel :" + this.codH);
		System.out.println("Número de reserva Hotel: " +this.numRH);
		System.out.println("Fecha de Reserva Hotel: " +this.fechaRH);
		
	}

	@Override
	public double aplicarDescuento(double precio) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


