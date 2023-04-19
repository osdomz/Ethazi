package agenciadeviajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservasH {
	
    private static int numRH = 0; // Inicializar numRH a 0
    private LocalDate fechaRH;
    //private String dni;
    //private String codH;
    private Clientes clientes; // Cambiar a Cliente en lugar de ArrayList<Cliente>
    private Socios socios; // Cambiar a Socio en lugar de ArrayList<Socio>
    private Hoteles hoteles; // Cambiar a Hotel en lugar de ArrayList<Hotel>

    private static List<ReservasH> reservash = new ArrayList<>();

    // Constructor que recibe los parámetros necesarios para crear una reserva
    public ReservasH(Clientes cliente, Socios socio, Hoteles hotel) {
        this.clientes = cliente;
        this.socios = socio;
        this.hoteles = hotel;
        ReservasH.numRH = (int) (Math.random() * 1000) + 1; // Generar un número aleatorio entre 1 y 1000
        this.fechaRH = LocalDate.now();
        //this.dni = cliente.getDni(); // Obtener el DNI del cliente
        //this.codH = hotel.getCodH(); // Obtener el código del hotel
    }

	// Método getter para el atributo numRH
    public static int getNumRH() {
        return numRH;
    }

    // Método getter para el atributo fechaRH
    public LocalDate getFechaRH() {
        return fechaRH;
    }
    
    public void setFechaRH(LocalDate now) {		
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
    public void setCodH(Hoteles nuevoHotelElegido) {
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
        return "Reserva [numRH=" + numRH + ", fechaRH=" + fechaRH + ", dni=" + dni + ", codH=" + hoteles.getCodH() + "]";
    }

    

	public static List<ReservasH> getReservasH() {
		return reservash;
	}

	public void setReservasH(List<ReservasH> reservash) {
	    this.reservash = reservash;
	}
	public void setHoteles(Hoteles nuevoHotelElegido) {
	    this.hoteles = nuevoHotelElegido;
	}
	public void eliminarReservaH(ReservasH reserva) {
	    this.reservash.remove(reserva);
	    reserva.setClientes(null);
	    reserva.setSocios(null);
	    reserva.setCodH(null);
	}

	
}

    // Método getter para el atributo codH
//    public String getCodH() {
 //       return codH;
  //  }



   

