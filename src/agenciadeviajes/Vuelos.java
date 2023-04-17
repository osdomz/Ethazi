package agenciadeviajes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vuelos {
    private String codV;
    private String aerolinea;
    private String clase;
    private String origen;
    private String destino;
    private double precio;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    
    public ArrayList<Vuelos> listaV;
    
    public Vuelos(ArrayList<Vuelos> listaV) {
    	 this.listaV = new ArrayList<Vuelos>();        // Agregar los hoteles a la lista aquí
    }
    
    public void fillDataV() {
    	listaV.add(new Vuelos ("V1", "AVIANCA", "TURISTA", "ESPAÑA", "COLOMBIA", 600.00, null, null));
    	listaV.add(new Vuelos ("V2", "LATAM", "TURISTA", "ESPAÑA", "ARGENTINA", 650.00, null, null));
    	listaV.add(new Vuelos ("V3", "AIRLINE", "PRIMERA CLASE", "ESPAÑA", "PANAMA", 200.00, null, null));
       
        }

    public Vuelos(String codV, String aerolinea, String clase, String origen, String destino, double precio, LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.codV = codV;
        this.aerolinea = aerolinea;
        this.clase = clase;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fechaSalida = LocalDate.now();
        this.fechaLlegada = LocalDate.now();
    }

	public String getCodV() {
		return codV;
	}

	public void setCodV(String codV) {
		this.codV = codV;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDate fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	@Override
	public String toString() {
		return "Vuelo [codV=" + codV + ", aerolinea=" + aerolinea + ", clase=" + clase + ", origen=" + origen
				+ ", destino=" + destino + ", precio=" + precio + ", fechaSalida=" + fechaSalida + ", fechaLlegada="
				+ fechaLlegada + "]";
	}

}

