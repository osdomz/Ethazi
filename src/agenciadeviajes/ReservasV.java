package agenciadeviajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservasV {
    
	private static int numRV = 0; // Inicializar numRH a 0
    private LocalDate fechaRV;
    //private String dni;
    //private String codH;
    private Clientes clientes; // Cambiar a Cliente en lugar de ArrayList<Cliente>
    private Socios socios; // Cambiar a Socio en lugar de ArrayList<Socio>
    private Vuelos vuelos; // Cambiar a Hotel en lugar de ArrayList<Hotel>
    
   private static List<ReservasV> reservasv = new ArrayList<>();

    
    public ReservasV(Clientes cliente, Socios socio, Vuelos vuelo) {
    	this.clientes = cliente;
        this.socios = socio;
        this.vuelos = vuelo;
        ReservasV.numRV = (int) (Math.random() * 1000) + 1; // Generar un número aleatorio entre 1 y 1000
        this.fechaRV = LocalDate.now();
        //this.dni = cliente.getDni(); // Obtener el DNI del cliente
        //this.codH = hotel.getCodH(); // Obtener el código del hotel

    }

	/*public ReservasV(ArrayList<ReservasV> listaReservasV) {
		// TODO Auto-generated constructor stub
	}*/

	public ReservasV() {
		// TODO Auto-generated constructor stub
	}

	public static int getNumRV() {
		return numRV;
	}

	public LocalDate getFechaRV() {
		return fechaRV;
	}

	public void setFechaRV(LocalDate fechaRV) {
	}
	// Método getter para el atributo cliente
    public Clientes getClientes() {
        return clientes;
    }
    public void setClientes(Clientes cliente) {
    	
    }
 // Método getter para el atributo socio
    public Socios getSocios() {
        return socios;
    }
    public void setSocios(Socios socio) {
    	
    }

    // Método getter para el atributo dni
    //public void getDni(String dni) {
     //   this.dni = dni;
    //}
    public void setCodV(Vuelos nuevoVueloElegido) {
		// TODO Auto-generated method stub
		
	}
	

    @Override
    public String toString() {
        String dni = "";
        if (clientes instanceof Clientes) {
            dni = ((Clientes) clientes).getDni();
        } else if (socios instanceof Socios) {
            dni = ((Socios) socios).getDni();
        }
        return "Reserva [numRV=" + numRV + ", fechaRH=" + fechaRV + ", dni=" + dni + ", codV=" + vuelos.getCodV() + "]";
    }

	public static List<ReservasV> getReservasv() {
		return reservasv;
	}

	public static void setReservasv(List<ReservasV> reservasv) {
		ReservasV.reservasv = reservasv;
	}
	public void setVuelos(Vuelos nuevoVueloElegido) {
	    this.vuelos = nuevoVueloElegido;
	}
	public void eliminarReservaV(ReservasV reserva) {
	    this.reservasv.remove(reserva);
	    reserva.setClientes(null);
	    reserva.setSocios(null);
	    reserva.setCodV(null);
	}
}
   