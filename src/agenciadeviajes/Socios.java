package agenciadeviajes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Socios extends Personas {
	
	private List<ReservasH> reservasH = new ArrayList<>();
    private List<ReservasV> reservasV = new ArrayList<>();
	
	private int numSocio;
	
    static ArrayList<Socios> listaSocios = new ArrayList<>();
    
    public void fillDataS() {
        listaSocios.add(new Socios ("1234S", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 21, "631726686", "C_OSPINA@FPZORNOTZA.COM", 4));
        listaSocios.add(new Socios ("1234S", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 22, "631726686", "C_OSPINA@FPZORNOTZA.COM", 5));
        listaSocios.add(new Socios ("1234S", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 23, "631726686", "C_OSPINA@FPZORNOTZA.COM", 6));
    }
    
	public Socios(String dni, String nombre, String apellido1, String apellido2, int edad, String telefono, String email, int numSocio) {
		super(dni, nombre, apellido1, apellido2, edad, telefono, email);
		this.numSocio = numSocio;
	}
	public Socios (ArrayList<Socios> arrayList) {
        listaSocios = new ArrayList<Socios>(arrayList);
    }
	
	public int getNumSocio() {
		return numSocio;
	}

	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}
	
	@Override
	public String toString() {
	    return super.toString() + "[Número de Socio: " + numSocio + "]";
	}

	@Override
	public void print() {
		System.out.println("DNI: " + this.getDni());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido1: " + this.getApellido1());
        System.out.println("Apellido2: " + this.getApellido2());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Teléfono: " + this.getTelefono());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Número de Socio: " + this.getNumSocio());
	}

	@Override
	public void leer(Scanner sc) {
		System.out.println("Introduce tu dni");
		this.dni = sc.nextLine();
		System.out.println("Introduce tu nombre");
		this.nombre = sc.nextLine();
		System.out.println("Introduce tu primer apellido");
		this.apellido1 = sc.nextLine();
		System.out.println("Introduce tu segundo apellido");
		this.apellido2 = sc.nextLine();
		System.out.println("Introduce tu edad");
		this.edad = sc.nextInt();
		sc.nextLine(); // consume newline character
		while(this.edad < 0) {
		    System.out.println("ERROR, tu edad debe ser mayor a 0");
		    System.out.println("Introduce de nuevo");
		    this.edad = sc.nextInt();
		    sc.nextLine(); // consume newline character
		}
		System.out.println("Introduce tu numero de teléfono");
		this.telefono = sc.nextLine();
		System.out.println("Introduce tu email");
		this.email = sc.nextLine();
		System.out.println("Introduce tu numero de Cliente");
        this.numSocio = sc.nextInt();
    }

    public static ArrayList<Socios> getListaSocios() {
        return listaSocios;
    }

    public void agregarReserva(ReservasH reservash) {
        reservasH.add(reservash);
    }
    public void agregarReserva(ReservasV reservasv) {
        reservasV.add(reservasv);
    }
}



