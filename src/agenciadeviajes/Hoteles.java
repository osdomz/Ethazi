package agenciadeviajes;

public class Hoteles {
	/**

	La clase Hoteles representa un hotel y sus características, incluyendo su código, nombre, dirección, número de estrellas,

	tiempo de estadía y precio por noche.
	*/
	
    private String codH;
    private String nombre;
    private String direccion;
    private int numEstrellas;
    private String tiempo;
    private double precio;

	public Hoteles() {
		this.codH = "";
		this.nombre = "";
		this.direccion = "";
		this.numEstrellas = 0;
		this.tiempo = "";
		this.precio = 0;
	}
	/**

	Constructor de copia de la clase Hoteles, crea un nuevo objeto Hoteles con los mismos valores de atributos que otro objeto Hoteles.
**/
    public Hoteles(Hoteles h) {
    	 this.codH = h.codH;
         this.nombre = h.nombre;
         this.direccion = h.direccion;
         this.numEstrellas = h.numEstrellas;
         this.tiempo = h.tiempo;
         this.precio = h.precio;
   }
    /**

    Constructor de la clase Hoteles, inicializa los atributos con los valores pasados como parámetros.
    @param codH código del hotel
    @param nombre nombre del hotel
    @param direccion dirección del hotel
    @param numEstrellas número de estrellas del hotel
    @param tiempo tiempo de estadía en el hotel
*/
    public Hoteles(String codH, String nombre, String direccion, int numEstrellas, String tiempo, double precio) {
        this.codH = codH;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numEstrellas = numEstrellas;
        this.tiempo = tiempo;
        this.precio = precio;
    }
    //metodos que retornan los valores de la clase
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
		return "Hoteles [codH=" + codH + ", nombre=" + nombre + ", direccion=" + direccion + ", numEstrellas="
				+ numEstrellas + ", tiempo=" + tiempo + ", precio=" + precio + "]";
	}
    
}
