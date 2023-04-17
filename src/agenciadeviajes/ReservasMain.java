package agenciadeviajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReservasMain {

    public static void main(String[] args) {

    	ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
    	Clientes clientes = new Clientes(listaClientes);

    	ArrayList<Socios> listaSocios = new ArrayList<Socios>();
    	Socios socios = new Socios(listaSocios);

    	Hoteles hoteles = new Hoteles();
    	ArrayList<Hoteles> listaHoteles = hoteles.getListaH();

    	ArrayList<Vuelos> listaVuelos = new ArrayList<Vuelos>();
    	Vuelos vuelos = new Vuelos(listaVuelos);

    	ReservasH listaReservasH = new ReservasH(clientes, socios, hoteles);

    	ArrayList<ReservasV> listaReservasV = new ArrayList<ReservasV>();
    	ReservasV reservasV = new ReservasV(listaReservasV);

    	clientes.fillDataC();
    	socios.fillDataS();
    	vuelos.fillDataV();
    	hoteles.fillDataH();
    	
	

    	try (Scanner scanner = new Scanner(System.in)) {
    	    String dni = null;
    	    String tipoUsuario = null;

    	    // Solicitar al usuario que ingrese su DNI hasta que se ingrese un valor válido
    	    do {
    	        try {
    	            System.out.print("Ingrese su DNI para ingresar al menú: ");
    	            String input = scanner.nextLine();
    	            if (!input.matches("[0-9]+[A-Z]")) {
    	                throw new IllegalArgumentException();
    	            }
    	            dni = input.toUpperCase();
    	            tipoUsuario = verificarDni(dni);
    	            if (tipoUsuario == null) {
    	                System.out.println("DNI no encontrado, por favor intente de nuevo");
    	            }
    	        } catch (IllegalArgumentException e) {
    	            System.out.println("Error: Debe ingresar su DNI con la letra en mayúscula y sin espacios.");
    	        }
    	    } while (tipoUsuario == null);

    	    // Variable para almacenar el DNI verificado
    	    String dniVerificado = dni;

    	    System.out.println("Bienvenido al menú de reservas, " + tipoUsuario + " " + obtenerNombreUsuario(tipoUsuario, dniVerificado));

    	    int opcion;
    	    boolean usuarioEncontrado = false;

    	    do {
    	        System.out.println("\nSeleccione una opción:");
    	        System.out.println("1. Mostrar Hoteles disponibles");
    	        System.out.println("2. Mostrar Vuelos disponibles");
    	        System.out.println("3. Consultar reserva");
    	        System.out.println("4. Modificar reserva");
    	        System.out.println("5. Anular reserva");
    	        System.out.println("6. Salir");

    	        opcion = scanner.nextInt();
    	        scanner.nextLine();
    	        

    	        switch (opcion) {

    	        case 1:
    	            // Mostrar la lista de hoteles disponibles
    	            System.out.println("Lista de hoteles disponibles:");
    	            for (Hoteles h : listaHoteles) {
    	                System.out.println(h);
    	            }

    	            // Solicitar al usuario que ingrese el código del hotel elegido
    	            System.out.print("Ingrese el código del hotel elegido: ");
    	            String codigoHotel = scanner.nextLine();

    	            // Verificar que el código de hotel ingresado es válido
    	            Hoteles hotelElegido = null;
    	            for (Hoteles h : listaHoteles) {
    	                if (h.getCodH() != null && h.getCodH().equals(codigoHotel)) {
    	                    hotelElegido = h;
    	                    break;
    	                }
    	            }
    	            if (hotelElegido == null) {
    	                System.out.println("Código de hotel inválido.");
    	                break;
    	            }

    	            // Obtener el objeto Cliente o Socio correspondiente al DNI del usuario
    	            Clientes clienteElegido = null;
    	            Socios socioElegido = null;
    	            for (Clientes c : listaClientes) {
    	                if (c.getDni().equals(dniVerificado)) {
    	                    clienteElegido = c;
    	                    System.out.println("Cliente encontrado: " + clienteElegido);
    	                    break;
    	                }
    	            }
    	            for (Socios s : listaSocios) {
    	                if (s.getDni().equals(dniVerificado)) {
    	                    socioElegido = s;
    	                    break;
    	                }
    	            }
    	            if (clienteElegido == null && socioElegido == null) {
    	                System.out.println("DNI de usuario no encontrado.");
    	                break;
    	            }

    	            // Crear una nueva reserva de hotel y agregarla a la lista de reservas de hoteles
    	            if (clienteElegido != null || socioElegido != null) {
    	                ReservasH nuevaReservaH = new ReservasH(clienteElegido, socioElegido, hotelElegido);
    	                nuevaReservaH.setFechaRH(LocalDate.now()); // Asignar la fecha actual como fecha de reserva
    	                ((List<ReservasH>) listaReservasH).add(nuevaReservaH);

    	                // Agregar la reserva al objeto Cliente o Socio correspondiente
    	                if (clienteElegido != null) {
    	                    clienteElegido.agregarReserva(nuevaReservaH);
    	                } else {
    	                    socioElegido.agregarReserva(nuevaReservaH);
    	                }

    	                System.out.println("Reserva de hotel creada satisfactoriamente.");
    	                System.out.println("Número de reserva generado: " + ReservasH.getNumRH());
    	            } else {
    	                System.out.println("No se pudo crear la reserva, no se encontró el cliente o socio correspondiente al DNI ingresado.");
    	            }
    	           break;
    	        case 3:
			      
			    
			        break;

			        
			    	case 4:
			    	break;
			   
			        case 5:
			            
			            break;
			        case 6:
			        
			            break;
			            
			        case 7:
			            System.out.println("Saliendo de la aplicación...");
			            break;
			        default:
			            System.out.println("Opción inválida, por favor seleccione otra");
			    }
			} while (opcion != 7);
		}
    }

    private static String verificarDni(String dni) {

    	for (Clientes listaClientes : Clientes.listaClientes) {
            if (listaClientes.getDni().equals(dni)) {
                return "cliente";
            }
        }
        for (Socios listaSocios : Socios.listaSocios) {
            if (listaSocios.getDni().equals(dni)) {
                return "socio";
            }
        }
        return dni;
    }
    
    private static String obtenerNombreUsuario(String tipoUsuario, String dni) {
        if (tipoUsuario.equals("cliente")) {
            for (Clientes listaClientes : Clientes.listaClientes) {
                if (listaClientes.getDni().equals(dni)) {
                    return listaClientes.getNombre();
                }
            }
        } else if (tipoUsuario.equals("socio")) {
            for (Socios listaSocios : Socios.listaSocios) {
                if (listaSocios.getDni().equals(dni)) {
                    return listaSocios.getNombre();
                }
            }
        }
        return null;
    }

}