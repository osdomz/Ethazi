package agenciadeviajes;

/**
 * La clase Clientes representa a los clientes de la agencia.
 * Esta clase es una subclase de la clase Personas.
 */
public class Clientes extends Personas {

    private int numCliente;

    /**
     * Constructor por defecto de la clase Clientes.
     * Inicializa el número de cliente en 0.
     */
    public Clientes() {
        super();
        this.numCliente = 0;
    }

    /**
     * Constructor de copia de la clase Clientes.
     * @param c El objeto a copiar.
     */
    public Clientes(Clientes c) {
        super(c);
        this.numCliente = c.numCliente;
    }

    /**
     * Constructor de la clase Clientes.
     * @param dni El DNI del cliente.
     * @param nombre El nombre del cliente.
     * @param apellido1 El primer apellido del cliente.
     * @param apellido2 El segundo apellido del cliente.
     * @param edad La edad del cliente.
     * @param telefono El teléfono del cliente.
     * @param email El correo electrónico del cliente.
     * @param numCliente El número de cliente.
     */
    public Clientes(String dni, String nombre, String apellido1, String apellido2, int edad, String telefono,
            String email, int numCliente) {
        super(dni, nombre, apellido1, apellido2, edad, telefono, email);
        this.numCliente = numCliente;
    }

    /**
     * Devuelve el número de cliente.
     * @return El número de cliente.
     */
    public int getNumCliente() {
        return numCliente;
    }

    /**
     * Establece el número de cliente.
     * @param numCliente El número de cliente.
     */
    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    /**
     * Devuelve una cadena de caracteres que representa el objeto.
     * @return Una cadena de caracteres que representa el objeto.
     */
    @Override
    public String toString() {
        return "Cliente [numCliente=" + numCliente + "]";
    }

    /**
     * Imprime los datos del cliente en la consola.
     */
    @Override
    public void print() {
        System.out.println("DNI: " + this.getDni());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido1: " + this.getApellido1());
        System.out.println("Apellido2: " + this.getApellido2());
        System.out.println("Edad : " + this.getEdad());
        System.out.println("Teléfono: " + this.getTelefono());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Numero de Cliente: " + this.numCliente);
    }

}



