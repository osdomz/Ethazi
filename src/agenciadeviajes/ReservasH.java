package agenciadeviajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservasH {
	
    private static int numRH = 0; // Inicializar numRH a 0
    private LocalDate fechaRH;
    private String dni;
    private String codH;
    private Clientes clientes; // Cambiar a Cliente en lugar de ArrayList<Cliente>
    private Socios socios; // Cambiar a Socio en lugar de ArrayList<Socio>
    private Hoteles hoteles; // Cambiar a Hotel en lugar de ArrayList<Hotel>

    // Constructor que recibe los parámetros necesarios para crear una reserva
    public ReservasH(Clientes cliente, Socios socio, Hoteles hotel) {
        this.clientes = cliente;
        this.socios = socio;
        this.hoteles = hotel;
        ReservasH.numRH++; // Incrementar numRH en 1
        this.fechaRH = LocalDate.now();
        this.dni = cliente.getDni(); // Obtener el DNI del cliente
        this.codH = hotel.getCodH(); // Obtener el código del hotel
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
		// TODO Auto-generated method stub
		
	}

    // Método getter para el atributo cliente
    public Clientes getCliente() {
        return clientes;
    }

    // Método getter para el atributo dni
    public void getDni(String dni) {
        this.dni = dni;
    }
    public void setCodH(String codH2) {
		// TODO Auto-generated method stub
		
	}

    // Método getter para el atributo codH
    public String getCodH() {
        return codH;
    }

    // Lista de reservas
    public static List<ReservasH> reservash = new ArrayList<>();

    // Agregar reserva a la lista de reservas
    public void agregarReserva(ReservasH reservash) {
        ((List<ReservasH>) reservash).add(reservash);
    }

    @Override
    public String toString() {
        return "ReservasH [numRH=" + numRH + ", fechaRH=" + fechaRH + ", dni=" + dni + ", codH=" + codH + "]";
    }
	
}

