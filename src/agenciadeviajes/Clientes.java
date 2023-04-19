package agenciadeviajes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Clientes extends Personas {
	
	private List<ReservasH> reservasH = new ArrayList<>();
    private List<ReservasV> reservasV = new ArrayList<>();

    private int numCliente;

    //static ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();

    /*public void fillDataC() {
        listaClientes.add(new Clientes("1234C", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 25, "631726686", "C_OSPINA@FPZORNOTZA.COM", 1));
        listaClientes.add(new Clientes("1235C", "MARIA", "MARTINEZ", "GOMEZ", 32, "631726687", "M_MARTINEZ@FPZORNOTZA.COM", 2));
        listaClientes.add(new Clientes("1236C", "ANDRES", "RODRIGUEZ", "SUAREZ", 27, "631726688", "A_RODRIGUEZ@FPZORNOTZA.COM", 3));
    }*/

    public Clientes(String dni, String nombre, String apellido1, String apellido2, int edad, String telefono, String email, int numCliente) {
        super(dni, nombre, apellido1, apellido2, edad, telefono, email);
        this.numCliente = numCliente;
    }
/*
    public Clientes(ArrayList<Clientes> arrayList) {
        listaClientes = new ArrayList<Clientes>(arrayList);
    }
*/
    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    @Override
    public String toString() {
        return "Cliente [numCliente=" + numCliente + "]";
    }

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

    @Override
    public void leer(Scanner sc) {
        System.out.println("Introduce tu dni");
        this.setDni(sc.nextLine());
        System.out.println("Introduce tu nombre");
        this.setNombre(sc.nextLine());
        System.out.println("Introduce tu primer apellido");
        this.setApellido1(sc.nextLine());
        System.out.println("Introduce tu segundo apellido");
        this.setApellido2(sc.nextLine());
        System.out.println("Introduce tu edad");
        this.setEdad(sc.nextInt());
        while (this.getEdad() <= 17) {
            System.out.println("ERROR, tu edad debe ser mayor a 18");
            System.out.println("Introduce de nuevo");
            this.setEdad(sc.nextInt());
        }
        sc.nextLine(); // Agregamos esta línea para consumir el salto de línea pendiente
        System.out.println("Introduce tu numero de teléfono");
        this.setTelefono(sc.nextLine());
        System.out.println("Introduce tu email");
        this.setEmail(sc.nextLine());
        System.out.println("Introduce tu numero de Cliente");
        this.numCliente = sc.nextInt();
    }

/*    public static ArrayList<Clientes> getListaClientes() {
        return listaClientes;
    }
*/
    public void agregarReserva(ReservasH reservash) {
        reservasH.add(reservash);
    }
    public void agregarReserva(ReservasV reservasv) {
        reservasV.add(reservasv);
    }
	public void eliminarReservaH(ReservasH hotelCancelar) {
	    reservasH.remove(reservasH);
		
	}
	public void eliminarReservaV(ReservasV vueloCancelar) {
	    reservasV.remove(reservasV);
		
	}

}



