package agenciadeviajes;

import java.util.ArrayList;

public class Hoteles {
    private String codH;
    private String nombre;
    private String direccion;
    private String tipo;
    private int numEstrellas;
    private String tiempo;
    private double precio;

    private ArrayList<Hoteles> listaH = new ArrayList<Hoteles>();

    public Hoteles(String codH, String nombre, String direccion, String tipo, int numEstrellas, String tiempo, double precio) {
        this.codH = codH;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
        this.numEstrellas = numEstrellas;
        this.tiempo = tiempo;
        this.precio = precio;
    }

    public Hoteles() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Hoteles> getListaH() {
        return listaH;
    }

    public void setListaH(ArrayList<Hoteles> listaH) {
        this.listaH = listaH;
    }

    // Rellena la lista de hoteles con algunos hoteles predefinidos
    public void fillDataH() {
        listaH.add(new Hoteles("H1", "HOTEL DIAMANTE", "AV.3N", "CLASSIC", 3, "24H", 50.00));
        listaH.add(new Hoteles("H2", "HOTEL DULCES SUEÑOS", "AV.3N", "GOLD", 4, "24H", 70.00));
        listaH.add(new Hoteles("H3", "HOTEL CALIFORNIA", "AV.3N", "PLATINUM", 5, "24H", 100.00));
    }

    // Imprime la lista de hoteles
    public void imprimirListaHoteles() {
        for (Hoteles hotel : listaH) {
            System.out.println(hotel.toString());
        }
    }

    public String getCodH() {
        return codH;
    }

    public void setCodH(String codH) {
        this.codH = codH;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumEstrellas() {
        return numEstrellas;
    }

    public void setNumEstrellas(int numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Hoteles [codH=" + codH + ", nombre=" + nombre + ", direccion=" + direccion + ", tipo=" + tipo
                + ", numEstrellas=" + numEstrellas + ", tiempo=" + tiempo + ", precio=" + precio + "]";
    }
}
