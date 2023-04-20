package agenciadeviajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReservasMain {

	public static void main(String[] args) {

		ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
		Clientes cliente1 = new Clientes("0ABCDEF01", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 25, "631726686","C_OSPINA@FPZORNOTZA.COM", 101);
		Clientes cliente2 = new Clientes("0ABCDEF04", "MARIA", "MARTINEZ", "GOMEZ", 32, "631726687","M_MARTINEZ@FPZORNOTZA.COM", 202);
		Clientes cliente3 = new Clientes("0ABCDEF05", "ANDRES", "RODRIGUEZ", "SUAREZ", 27, "631726688","A_RODRIGUEZ@FPZORNOTZA.COM", 303);
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente3);

		ArrayList<Socios> listaSocios = new ArrayList<Socios>();
		Socios socio1 = new Socios("12345678D", "CHRISTIAN", "OSPINA", "DOMINGUEZ", 21, "631726686","C_OSPINA@FPZORNOTZA.COM", 404);
		Socios socio2 = new Socios("12345678E", "BITTOR", "OSPINA", "DOMINGUEZ", 21, "631726686","C_OSPINA@FPZORNOTZA.COM", 505);
		Socios socio3 = new Socios("12345678F", "ARKA", "OSPINA", "DOMINGUEZ", 21, "631726686","C_OSPINA@FPZORNOTZA.COM", 606);
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
		Vuelos vuelo1 = new Vuelos("V1", "AVIANCA", "TURISTA", "ESPAÑA", "COLOMBIA", 600.00, null, null);
		Vuelos vuelo2 = new Vuelos("V2", "LATAM", "TURISTA", "ESPAÑA", "ARGENTINA", 650.00, null, null);
		Vuelos vuelo3 = new Vuelos("V3", "AIRLINE", "PRIMERA CLASE", "ESPAÑA", "PANAMA", 200.00, null, null);
		listaVuelos.add(vuelo1);
		listaVuelos.add(vuelo2);
		listaVuelos.add(vuelo3);

		ArrayList<ReservasH> listaReservasH = new ArrayList<ReservasH>();
		ReservasH rhbd = new ReservasH();

		ArrayList<ReservasV> listaReservasV = new ArrayList<ReservasV>();
		ReservasV rvbd = new ReservasV();

		try {
		    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes", "root", "");
		    System.out.println("Conexión Correcta.");
		    Statement st = conexion.createStatement();
		    
		    ResultSet rs = st.executeQuery("SELECT * FROM agencia_de_viajes.reservash;");
		    while (rs.next()) {
		        int numRH = rs.getInt("numRH");
		        String dni = rs.getString("dni");
		        String codH = rs.getString("codH");
		        LocalDate fechaRH = rs.getObject("fechaRH", LocalDate.class);
		        ReservasH reservasH = new ReservasH();
		        listaReservasH.add(reservasH);
		    }

		    rs = st.executeQuery("SELECT * FROM agencia_de_viajes.reservasv;");
		    while (rs.next()) {
		        int numRV = rs.getInt("numRV");
		        String dni = rs.getString("dni");
		        String codV = rs.getString("codV");
		        LocalDate fechaRV = rs.getObject("fechaRV", LocalDate.class);
		        ReservasV reservasV = new ReservasV();
		        listaReservasV.add(reservasV);
		    }
		    
		    // cierro el resultset
		    rs.close();
		    // cierro el statement despues de realizar la consulta
		    st.close();
		    // cierro la conexion
		    conexion.close();
		    
		    // Realizar acciones con las listas de reservas obtenidas
		    
		} catch (SQLException e) {
		    // si no se ha conectado correctamente
		    System.out.println("Error de conexión");
		    e.printStackTrace();
		}

		try (Scanner scanner = new Scanner(System.in)) {
			String dni = null;
			String tipoUsuario = null;
			boolean usuarioEncontrado = false;
			
			boolean modificadoh = false;
			boolean modificadov = false;
			boolean canceladoh = false;
			boolean canceladov = false;
			int posicion;

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

			System.out.println("Bienvenido al menú de reservas, " + tipoUsuario + " "
					+ obtenerNombreUsuario(tipoUsuario, dniVerificado, listaClientes, listaSocios));

			int opcion;

			do {
				System.out.println("\nSeleccione una opción:");
				System.out.println("1. Mostrar Hoteles disponibles");
				System.out.println("2. Mostrar Vuelos disponibles");
				System.out.println("3. Consultar reserva");
				System.out.println("4. Modificar reserva de Hotel");
				System.out.println("5. Modificar reserva de Vuelo");
				System.out.println("6. Anular reserva de Hotel");
				System.out.println("7. Anular reserva de Vuelos");
				System.out.println("8. Salir");

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

					// Crear una nueva reserva de hotel y agregarla a la lista de reservas de
					// hoteles
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
						System.out.println(
								"No se pudo crear la reserva, no se encontró el cliente o socio correspondiente al DNI ingresado.");
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
							socioElegido2 = s;
							System.out.println("Cliente encontrado: " + socioElegido2);
							break;
						}
					}

					if (clienteElegido2 == null && socioElegido2 == null) {
						System.out.println("DNI de usuario no encontrado.");
						break;
					}

					// Crear una nueva reserva de vuelos y agregarla a la lista de reservas de
					// vuelos
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
						System.out.println(
								"No se pudo crear la reserva, no se encontró el cliente o socio correspondiente al DNI ingresado.");
					}
					break;

				case 3:
					// Solicitar al usuario que ingrese el número de reserva
					System.out.print("Ingrese el número de reserva: ");
					int numReserva = scanner.nextInt();
					scanner.nextLine();

					// Buscar la reserva correspondiente al número ingresado en la lista de reservas
					// de vuelos
					ReservasV vueloEncontrado = null;
					for (ReservasV r : listaReservasV) {
						if (r.getNumRV() == numReserva) {
							vueloEncontrado = r;
							break;
						}
					}

					// Buscar la reserva correspondiente al número ingresado en la lista de reservas
					// de hoteles
					ReservasH hotelEncontrado = null;
					for (ReservasH r : listaReservasH) {
						if (r.getNumRH() == numReserva) {
							hotelEncontrado = r;
							break;
						}
					}

					// Si se encontró una reserva en la lista de reservas de vuelos, mostrar la
					// información correspondiente
					if (vueloEncontrado != null) {
						System.out.println("Reserva de vuelo encontrada:");
						System.out.println(vueloEncontrado);
					}
					// Si se encontró una reserva en la lista de reservas de hoteles, mostrar la
					// información correspondiente
					else if (hotelEncontrado != null) {
						System.out.println("Reserva de hotel encontrada:");
						System.out.println(hotelEncontrado);
					}
					// Si no se encontró una reserva en ninguna de las listas, mostrar un mensaje de
					// error
					else {
						System.out.println("Reserva no encontrada.");
					}
					break;

				case 4:
					// Mostrar la lista de reservas del usuario
					System.out.println("Lista de reservas de Hoteles:");
					for (ReservasH rh : listaReservasH) {
						if (rh.getClientes() != null && rh.getClientes().getDni().equals(dni)
								|| rh.getSocios() != null && rh.getSocios().getDni().equals(dniVerificado)) {
							System.out.println(rh);
						}
					}

					// Solicitar al usuario que ingrese el número de reserva a modificar
					System.out.print("Ingrese el número de reserva a modificar: ");
					int numRH = scanner.nextInt();
					scanner.nextLine();

					// Buscar la reserva correspondiente al número ingresado
					ReservasH reservaModificar = null;
					for (ReservasH rh : listaReservasH) {
						if (rh.getNumRH() == numRH) {
							reservaModificar = rh;
							break;
						}
					}

					// Verificar que la reserva existe y pertenece al usuario
					if (reservaModificar == null) {
						System.out.println("Número de reserva inválido.");
						break;
					} else if (reservaModificar.getClientes() != null
							&& !reservaModificar.getClientes().getDni().equals(dni)
							|| reservaModificar.getSocios() != null
									&& !reservaModificar.getSocios().getDni().equals(dniVerificado)) {
						System.out.println("La reserva no pertenece al usuario.");
						break;
					}

					// Mostrar la lista de hoteles disponibles
					System.out.println("Lista de hoteles disponibles:");
					for (Hoteles h : listaHoteles) {
						System.out.println(h);
					}

					// Solicitar al usuario que ingrese el código del nuevo hotel elegido
					System.out.print("Ingrese el código del nuevo hotel elegido: ");
					String codigoNuevoHotel = scanner.nextLine();

					// Verificar que el código de hotel ingresado es válido
					Hoteles nuevoHotelElegido = null;
					for (Hoteles h : listaHoteles) {
						if (h.getCodH() != null && h.getCodH().equals(codigoNuevoHotel)) {
							nuevoHotelElegido = h;
							break;
						}
					}
					if (nuevoHotelElegido == null) {
						System.out.println("Código de hotel inválido.");
						break;
					}

					// Modificar la reserva con el nuevo hotel elegido
					reservaModificar.setHoteles(nuevoHotelElegido);
					System.out.println("Reserva modificada satisfactoriamente.");
					modificadoh = true;

					break;

				case 5:
					// Mostrar la lista de reservas del usuario
					System.out.println("Lista de reservas de Vuelos:");
					for (ReservasV rv : listaReservasV) {
						if (rv.getClientes() != null && rv.getClientes().getDni().equals(dni)
								|| rv.getSocios() != null && rv.getSocios().getDni().equals(dniVerificado)) {
							System.out.println(rv);
						}
					}

					// Solicitar al usuario que ingrese el número de reserva a modificar
					System.out.print("Ingrese el número de reserva a modificar: ");
					int numRV = scanner.nextInt();
					scanner.nextLine();

					// Buscar la reserva correspondiente al número ingresado
					ReservasV reservaModificar2 = null;
					for (ReservasV rv : listaReservasV) {
						if (rv.getNumRV() == numRV) {
							reservaModificar2 = rv;
							break;
						}
					}

					// Verificar que la reserva existe y pertenece al usuario
					if (reservaModificar2 == null) {
						System.out.println("Número de reserva inválido.");
						break;
					} else if (reservaModificar2.getClientes() != null
							&& !reservaModificar2.getClientes().getDni().equals(dni)
							|| reservaModificar2.getSocios() != null
									&& !reservaModificar2.getSocios().getDni().equals(dniVerificado)) {
						System.out.println("La reserva no pertenece al usuario.");
						break;
					}

					// Mostrar la lista de hoteles disponibles
					System.out.println("Lista de Vuelos disponibles:");
					for (Vuelos v : listaVuelos) {
						System.out.println(v);
					}

					// Solicitar al usuario que ingrese el código del nuevo hotel elegido
					System.out.print("Ingrese el código del nuevo Vuelo elegido: ");
					String codigoNuevoVuelo2 = scanner.nextLine();

					// Verificar que el código de hotel ingresado es válido
					Vuelos nuevoVueloElegido2 = null;
					for (Vuelos v : listaVuelos) {
						if (v.getCodV() != null && v.getCodV().equals(codigoNuevoVuelo2)) {
							nuevoVueloElegido2 = v;
							break;
						}
					}
					if (nuevoVueloElegido2 == null) {
						System.out.println("Código de vuelo inválido.");
						break;
					}

					// Modificar la reserva con el nuevo hotel elegido
					reservaModificar2.setVuelos(nuevoVueloElegido2);
					System.out.println("Reserva modificada satisfactoriamente.");
					modificadov = true;

					break;

				case 6:
					System.out.print("Ingrese el número de reserva del Hotel a cancelar: ");
					int numReservaCancelar = scanner.nextInt();
					scanner.nextLine();

					// Buscar la reserva correspondiente al número ingresado en la lista de reservas
					// de hoteles
					ReservasH hotelCancelar = null;
					for (ReservasH r : listaReservasH) {
						if (r.getNumRH() == numReservaCancelar) {
							hotelCancelar = r;
							break;
						}
					}

					// Si se encontró la reserva en la lista de reservas de hoteles, cancelarla y
					// eliminarla de la lista
					if (hotelCancelar != null) {
						// Obtener el objeto Cliente o Socio correspondiente al DNI del usuario
						Clientes clienteCancelar = null;
						Socios socioCancelar = null;
						boolean esSocio = false;

						for (Clientes c : listaClientes) {
							if (c.getDni().equals(dni)) {
								clienteCancelar = c;
								System.out.println("Cliente encontrado: " + clienteCancelar);
								break;
							}
						}

						if (clienteCancelar == null) {
							for (Socios s : listaSocios) {
								if (s.getDni().equals(dniVerificado)) {
									socioCancelar = s;
									System.out.println("Socio encontrado: " + socioCancelar);
									esSocio = true;
									break;
								}
							}
						}

						// Eliminar la reserva de la lista de reservas de hoteles
						listaReservasH.remove(hotelCancelar);

						// Eliminar la reserva del objeto Cliente o Socio correspondiente
						if (esSocio) {
							socioCancelar.eliminarReservaH(hotelCancelar);
						} else {
							clienteCancelar.eliminarReservaH(hotelCancelar);
						}

						System.out.println("Reserva de hotel cancelada satisfactoriamente.");
					} else {
						System.out.println("Reserva de hotel no encontrada.");
						canceladoh = true;
					}
					break;

				case 7:
					System.out.print("Ingrese el número de reserva del Vuelo cancelar: ");
					int numReservaCancelar2 = scanner.nextInt();
					scanner.nextLine();

					// Buscar la reserva correspondiente al número ingresado en la lista de reservas
					// de hoteles
					ReservasV vueloCancelar = null;
					for (ReservasV rv : listaReservasV) {
						if (rv.getNumRV() == numReservaCancelar2) {
							vueloCancelar = rv;
							break;
						}
					}

					// Si se encontró la reserva en la lista de reservas de hoteles, cancelarla y
					// eliminarla de la lista
					if (vueloCancelar != null) {
						// Obtener el objeto Cliente o Socio correspondiente al DNI del usuario
						Clientes clienteCancelar = null;
						Socios socioCancelar = null;
						boolean esSocio = false;

						for (Clientes c : listaClientes) {
							if (c.getDni().equals(dni)) {
								clienteCancelar = c;
								System.out.println("Cliente encontrado: " + clienteCancelar);
								break;
							}
						}

						if (clienteCancelar == null) {
							for (Socios s : listaSocios) {
								if (s.getDni().equals(dniVerificado)) {
									socioCancelar = s;
									System.out.println("Socio encontrado: " + socioCancelar);
									esSocio = true;
									break;
								}
							}
						}

						// Eliminar la reserva de la lista de reservas de hoteles
						listaReservasV.remove(vueloCancelar);

						// Eliminar la reserva del objeto Cliente o Socio correspondiente
						if (esSocio) {
							socioCancelar.eliminarReservaV(vueloCancelar);
						} else {
							clienteCancelar.eliminarReservaV(vueloCancelar);
						}

						System.out.println("Reserva de hotel cancelada satisfactoriamente.");
					} else {
						System.out.println("Reserva de hotel no encontrada.");
						canceladov = true;
					}
					break;

				case 8:
					System.out.println("Gracias por elegirnos. Hasta luego.");
					break;
				default:
					System.out.println("Opción inválida, por favor seleccione otra");
				}
			} while (opcion != 8);
			scanner.close();

			if (modificadoh) {
			    try {
			        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes", "root", "");

			        // Borro todas las reservas de hotel existentes
			        Statement st = conexion.createStatement();
			        String consulta = "DELETE FROM reservash;";
			        st.executeUpdate(consulta);
			        st.close();

			        // Inserto las nuevas reservas de hotel
			        PreparedStatement ps = conexion.prepareStatement("INSERT INTO reservash (numRH, dni, codH, fechaRH) VALUES (?, ?, ?, ?)");
			        for (posicion = 0; posicion < listaReservasH.size(); posicion++) {
			            ReservasH rhbd1 = listaReservasH.get(posicion);
			            System.out.println("Insertando reserva: " + rhbd1);
			            ps.setInt(1, ReservasH.getNumRH());
			            ps.setString(2, rhbd1.getClientes().getDni());
			            ps.setString(3, rhbd1.getHoteles().getCodH());
			            ps.setDate(4, java.sql.Date.valueOf(rhbd1.getFechaRH()));
			            ps.executeUpdate();
			        }
			        ps.close();

			        System.out.println("Reservas de hotel actualizadas correctamente.");
			        conexion.close();
			    } catch (SQLException e) {
			        System.err.println("Error al actualizar las reservas de hotel: " + e.getMessage());
			    }
			}


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

	private static String obtenerNombreUsuario(String tipoUsuario, String dni, ArrayList<Clientes> listaClientes,
			ArrayList<Socios> listaSocios) {
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