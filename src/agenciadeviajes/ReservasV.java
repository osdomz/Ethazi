package agenciadeviajes;

import java.time.LocalDate;

public class ReservasV implements DescuentoSocio{
	/**

	La clase ReservasV representa una reserva de vuelo realizada por un usuario,
	la cual contiene información sobre el usuario, el vuelo, el número de reserva y la fecha de la reserva.
	También implementa la interfaz DescuentoSocio para aplicar descuentos a las reservas realizadas por los socios.
	*/
    
	private String dni;
	private String codV;
	private int numRV;
    private LocalDate fechaRV;
    
    public ReservasV() {
    	this.dni = "";
        this.codV = "";
        this.numRV= 0;
        this.fechaRV = null;
   	}

    // Constructor que recibe los parámetros necesarios para crear una reserva
    public ReservasV(String dni, String codV, int numRV, LocalDate fechaRV) {
    	this.dni = dni;
        this.codV = codV;
        this.numRV = numRV;
        this.fechaRV = fechaRV;
 
    }

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodV() {
		return codV;
	}

	public void setCodV(String codV) {
		this.codV = codV;
	}

	public int getNumRV() {
		return numRV;
	}

	public void setNumRV(int numRV) {
		this.numRV = numRV;
	}

	public LocalDate getFechaRV() {
		return fechaRV;
	}

	public void setFechaRV(LocalDate fechaRV) {
		this.fechaRV = fechaRV;
	}

	@Override
	public String toString() {
		return "ReservasV [dni=" + dni + ", codV=" + codV + ", numRV=" + numRV + ", fechaRV=" + fechaRV + "]";
	}

	@Override
	public double aplicarDescuento(double precio) {
		// TODO Auto-generated method stub
		return 0;
	}

}
   