package agenciadeviajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReservasMain {

    public static void main(String[] args) {

    	ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
    	Clientes cliente1 = new Clientes("12345678A", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 25, "631726686", "C_OSPINA@FPZORNOTZA.COM", 101);
    	Clientes cliente2 = new Clientes("12345678B", "MARIA", "MARTINEZ", "GOMEZ", 32, "631726687", "M_MARTINEZ@FPZORNOTZA.COM", 202);
    	Clientes cliente3 = new Clientes("12345678C", "ANDRES", "RODRIGUEZ", "SUAREZ", 27, "631726688", "A_RODRIGUEZ@FPZORNOTZA.COM", 303);
    	listaClientes.add(cliente1);
    	listaClientes.add(cliente2);
    	listaClientes.add(cliente3);
    	
    	ArrayList<Socios> listaSocios = new ArrayList<Socios>();
    	Socios socio1 = new Socios("12345678D", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 21, "631726686", "C_OSPINA@FPZORNOTZA.COM", 404);
    	Socios socio2 = new Socios("12345678E", "BITTOR", "OSPINA", "DOMINGUEZ", 21, "631726686", "C_OSPINA@FPZORNOTZA.COM", 505);
    	Socios socio3 = new Socios("12345678F", "ARKA", "OSPINA", "DOMINGUEZ", 21, "631726686", "C_OSPINA@FPZORNOTZA.COM", 606);
    	listaSocios.add(socio1);
    	listaSocios.add(socio2);
    	listaSocios.add(socio3);
    	
    	ArrayList<Hoteles> listaHoteles = new ArrayList<Hoteles>();
    	Hoteles hotel1 = new Hoteles("H1", "HOTEL DIAMANTE", "AV.3N", "CLASSIC", 3, "24H", 50.00);
    	Hoteles hotel2 = new Hoteles("H2", "HOTEL DULCES SUEÑOS", "AV.3N", "GOLD", 4, "24H", 70.00);
    	Hoteles hotel3 = new Hoteles("H3", "HOTEL CALIFORNIA", "AV.3N", "PLATINUM", 5, "24H", 100.00);
        listaHoteles.add(hotel1);
        listaHoteles.add(hotel2);
        listaHoteles.add(hotel3);

    	ArrayList<Vuelos> listaVuelos = new ArrayList<Vuelos>();
    	Vuelos vuelo1 = new Vuelos ("V1", "AVIANCA", "TURISTA", "ESPAÑA", "COLOMBIA", 600.00, null, null);
    	Vuelos vuelo2 = new Vuelos ("V2", "LATAM", "TURISTA", "ESPAÑA", "ARGENTINA", 650.00, null, null);
    	Vuelos vuelo3 = new Vuelos ("V3", "AIRLINE", "PRIMERA CLASE", "ESPAÑA", "PANAMA", 200.00, null, null);
    	listaVuelos.add(vuelo1);
    	listaVuelos.add(vuelo2);
    	listaVuelos.add(vuelo3);
    	

    	ArrayList <ReservasH>listaReservasH = new ArrayList<ReservasH>();

    	ArrayList<ReservasV> listaReservasV = new ArrayList<ReservasV>();

    	//clientes.fillDataC();
    	//socios.fillDataS();
    	//vuelos.fillDataV();
    	//hoteles.fillDataH();
    	
	

    	try (Scanner scanner = new Scanner(System.in)) {
    	    String dni = null;
    	    String tipoUsuario = null;
    	    boolean usuarioEncontrado = false;


    	    // Solicitar al usuario que ingrese su DNI hasta que se ingrese un valor válido
    	    do {
    	        try {
    	            System.out.print("Ingrese su DNI para ingresar al menú: ");
    	            String input = scanner.nextLine();
    	            if (!input.matches("[0-9]+[A-Z]")) {
    	                throw new IllegalArgumentException();
    	            }
    	            dni = input.toUpperCase();
    	            tipoUsuario = verificarDni(dni, listaClientes, listaSocios);
    	            if (tipoUsuario == null) {
    	                System.out.println("DNI no encontrado, por favor intente de nuevo");
    	            } else {
    	                usuarioEncontrado = true;
    	            }
    	        } catch (IllegalArgumentException e) {
    	            System.out.println("Error: Debe ingresar su DNI con la letra en mayúscula y sin espacios.");
    	        }
    	    } while (!usuarioEncontrado);

    	    // Variable para almacenar el DNI verificado
    	    String dniVerificado = dni;

    	    System.out.println("Bienvenido al menú de reservas, " + tipoUsuario + " " + obtenerNombreUsuario(tipoUsuario, dniVerificado, listaClientes, listaSocios));

    	    int opcion;


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
    	                if (c.getDni().equals(dni)) {
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
    	        case 2:
    	            // Mostrar la lista de vuelos disponibles
    	            System.out.println("Lista de vuelos disponibles:");
    	            for (Vuelos v : listaVuelos) {
    	                System.out.println(v);
    	            }

    	            // Solicitar al usuario que ingrese el código del vuelo elegido
    	            System.out.print("Ingrese el código del vuelo elegido: ");
    	            String codigoVuelo = scanner.nextLine();

    	            // Verificar que el código de vuelo ingresado es válido
    	            Vuelos vueloElegido = null;
    	            for (Vuelos v : listaVuelos) {
    	                if (v.getCodV() != null && v.getCodV().equals(codigoVuelo)) {
    	                    vueloElegido = v;
    	                    break;
    	                }
    	            }
    	            if (vueloElegido == null) {
    	                System.out.println("Código de vuelo inválido.");
    	                break;
    	            }

    	            // Obtener el objeto Cliente o Socio correspondiente al DNI del usuario
    	            Clientes clienteElegido2 = null;
    	            Socios socioElegido2 = null;
    	            for (Clientes c : listaClientes) {
    	                if (c.getDni().equals(dni)) {
    	                    clienteElegido2 = c;
    	                    System.out.println("Cliente encontrado: " + clienteElegido2);
    	                    break;
    	                }
    	            }
    	            for (Socios s : listaSocios) {
    	                if (s.getDni().equals(dniVerificado)) {
    	                    socioElegido = s;
    	                    break;
    	                }
    	            }

    	            if (clienteElegido2 == null && socioElegido2 == null) {
    	                System.out.println("DNI de usuario no encontrado.");
    	                break;
    	            }

    	         // Crear una nueva reserva de vuelos y agregarla a la lista de reservas de vuelos
    	            if (clienteElegido2 != null || socioElegido2 != null) {
    	                ReservasV nuevaReservaV = new ReservasV(clienteElegido2, socioElegido2, vueloElegido);
    	                nuevaReservaV.setFechaRV(LocalDate.now()); // Asignar la fecha actual como fecha de reserva
    	                ((List<ReservasV>) listaReservasV).add(nuevaReservaV);

    	                // Agregar la reserva al objeto Cliente o Socio correspondiente
    	                if (clienteElegido2 != null) {
    	                    clienteElegido2.agregarReserva(nuevaReservaV);
    	                } else {
    	                    socioElegido2.agregarReserva(nuevaReservaV);
    	                }

    	                System.out.println("Reserva de Vuelo creada satisfactoriamente.");
    	                System.out.println("Número de reserva generado: " + ReservasV.getNumRV());
    	            } else {
    	                System.out.println("No se pudo crear la reserva, no se encontró el cliente o socio correspondiente al DNI ingresado.");
    	            }
    	            break;

    	        case 3:
    	            // Solicitar al usuario que ingrese el número de reserva
    	            System.out.print("Ingrese el número de reserva: ");
    	            int numReserva = scanner.nextInt();
    	            scanner.nextLine();

    	            // Buscar la reserva correspondiente al número ingresado en la lista de reservas de vuelos
    	            ReservasV vueloEncontrado = null;
    	            for (ReservasV r : listaReservasV) {
    	                if (r.getNumRV() == numReserva) {
    	                    vueloEncontrado = r;
    	                    break;
    	                }
    	            }

    	            // Buscar la reserva correspondiente al número ingresado en la lista de reservas de hoteles
    	            ReservasH hotelEncontrado = null;
    	            for (ReservasH r : listaReservasH) {
    	                if (r.getNumRH() == numReserva) {
    	                    hotelEncontrado = r;
    	                    break;
    	                }
    	            }

    	            // Si se encontró una reserva en la lista de reservas de vuelos, mostrar la información correspondiente
    	            if (vueloEncontrado != null) {
    	                System.out.println("Reserva de vuelo encontrada:");
    	                System.out.println(vueloEncontrado);
    	            } 
    	            // Si se encontró una reserva en la lista de reservas de hoteles, mostrar la información correspondiente
    	            else if (hotelEncontrado != null) {
    	                System.out.println("Reserva de hotel encontrada:");
    	                System.out.println(hotelEncontrado);
    	            } 
    	            // Si no se encontró una reserva en ninguna de las listas, mostrar un mensaje de error
    	            else {
    	                System.out.println("Reserva no encontrada.");
    	            }
    	            break;


			   
			        case 4:
			        	
			        break;
			        
			        case 5:
			        	
				    break;
			            
			        case 6:
			            System.out.println("Saliendo de la aplicación...");
			            break;
			        default:
			            System.out.println("Opción inválida, por favor seleccione otra");
			    }
			} while (opcion != 6);
		}
    }

	private static String verificarDni(String dni, ArrayList<Clientes> listaClientes, ArrayList<Socios> listaSocios) {

		for (Clientes listadoClientes : listaClientes) {
			if (listadoClientes.getDni().equals(dni)) {
				return "cliente";
			}
		}
		for (Socios listadoSocios : listaSocios) {
			if (listadoSocios.getDni().equals(dni)) {
				return "socio";
			}
		}
		return dni;
	}
    
    private static String obtenerNombreUsuario(String tipoUsuario, String dni, ArrayList<Clientes> listaClientes, ArrayList<Socios> listaSocios) {
        if (tipoUsuario.equals("cliente")) {
            for (Clientes listadoClientes : listaClientes) {
                if (listadoClientes.getDni().equals(dni)) {
                    return listadoClientes.getNombre();
                }
            }
        } else if (tipoUsuario.equals("socio")) {
            for (Socios listadoSocios : listaSocios) {
                if (listadoSocios.getDni().equals(dni)) {
                    return listadoSocios.getNombre();
                }
            }
        }
        return null;
    }
}