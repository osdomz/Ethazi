package agenciadeviajes;

import java.time.LocalDate;

public class Vuelos {
	/**

	La clase Hoteles representa un vuelo y sus características, incluyendo su código, aerolinea, origen, destino, precio, fecha de salida y fecha de llegada
	*/
    private String codV;
    private String aerolinea;
    private String clase;
    private String origen;
    private String destino;
    private double precio;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    
    public Vuelos() {
   	 	this.codV = "";
        this.aerolinea = "";
        this.origen = "";
        this.destino = "";
        this.clase = "";
        this.precio = 0;
        this.fechaSalida = null;
        this.fechaLlegada = null;
   }

	public Vuelos(Vuelos v) {
		this.codV = v.codV;
		this.aerolinea = v.aerolinea;
		this.origen = v.origen;
		this.destino = v.destino;
		this.clase = v.clase;
		this.precio = v.precio;
		this.fechaSalida = v.fechaSalida;
		this.fechaLlegada = v.fechaLlegada;
	}
    

    public Vuelos(String codV, String aerolinea, String origen, String destino, String clase, double precio, LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.codV = codV;
        this.aerolinea = aerolinea;    
        this.origen = origen;
        this.destino = destino;
        this.clase = clase;
        this.precio = precio;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
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

