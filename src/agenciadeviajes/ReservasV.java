package agenciadeviajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservasV {
    
    private int numRV;
    private LocalDate fechaRV;
    private String dni;
    private String codV;
    
    private static List<ReservasV> reservasv = new ArrayList<>();

    
    public ReservasV(int numRV, LocalDate fechaRV, String dni, String codV) {
        this.numRV = numRV;
        this.fechaRV = fechaRV;
        this.dni = dni;
        this.codV = codV;
        reservasv.add(this);

    }

	public ReservasV(ArrayList<ReservasV> listaReservasV) {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "ReservasV [numRV=" + numRV + ", fechaRV=" + fechaRV + ", dni=" + dni + ", codV=" + codV + "]";
	}
	public List<ReservasV> consultarReservasClienteV(String dni) {
	    List<ReservasV> reservasCliente = new ArrayList<>();
	    for (ReservasV reservav : reservasv) {
	        if (reservav.getDni().equals(dni)) {
	            reservasCliente.add(reservav);
	        }
	    }
	    return reservasCliente;
	}
	
	public List<ReservasV> consultarReservasSocioV(String dni) {
	    List<ReservasV> reservasSocio = new ArrayList<>();
	    for (ReservasV reservav : reservasv) {
	        if (reservav.getDni().equals(dni)) {
	            reservasSocio.add(reservav);
	        }
	    }
	    return reservasSocio;
	}
	
	public void anularReservaV(int numReserva) {
	    for (ReservasV reservav : reservasv) {
	        if (reservav.getNumRV() == numReserva) {
	            reservasv.remove(reservav);
	            break;
	        }
	        
	    }
	} 
}
   