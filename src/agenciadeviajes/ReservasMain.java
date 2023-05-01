package agenciadeviajes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ReservasMain {
	/**
	 * La clase ReservasMain es la clase principal que maneja el sistema de reservas
	 * de hoteles y vuelos para clientes y socios.
	 */

	private static final Logger LOGGER = Logger.getLogger(ReservasMain.class.getName());
	private static FileHandler fileHandler = null;

	public static void configurarLogger() {
		try {
			fileHandler = new FileHandler("registro_errores.log");
			LOGGER.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			LOGGER.setLevel(Level.ALL);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error al crear el archivo de registro", e);
		}
	}

	public static void main(String[] args) {
		configurarLogger();

		try {
			ArrayList<Clientes> aClientes = new ArrayList<Clientes>();

			ArrayList<Socios> aSocios = new ArrayList<Socios>();

			ArrayList<Hoteles> aHoteles = new ArrayList<Hoteles>();

			ArrayList<Vuelos> aVuelos = new ArrayList<Vuelos>();

			ArrayList<ReservasH> aReservasH = new ArrayList<ReservasH>();

			ArrayList<ReservasV> aReservasV = new ArrayList<ReservasV>();

			FileInputStream fis;
			ObjectInputStream ois;
			try {
				fis = new FileInputStream("socios.dat");
				ois = new ObjectInputStream(fis);

				ois.close();
				fis.close();
				System.out.println("Conexión con fichero correcta");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} /**
				 * Este método se utiliza para leer los datos de los socios desde un archivo de
				 * datos llamado "socios.dat" y cargarlos en la lista de socios. El archivo de
				 * datos debe existir previamente en el directorio del proyecto.
				 */

			boolean agregadorh = false;
			boolean agregadorv = false;
			boolean modificadorh = false;
			boolean modificadorv = false;
			boolean eliminadorh = false;
			boolean eliminadorv = false;
			int opcion = 0;

			try {

				ResultSet rs;
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes", "root",
						"");
				JOptionPane.showMessageDialog(null, "Conexión Correcta.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				Statement st = conexion.createStatement();

				// Consultar los datos de los clientes en la base de datos y añadirlos al
				// ArrayList correspondiente
				rs = st.executeQuery(
						"SELECT personas.*, clientes.numCliente FROM personas JOIN clientes ON personas.dni = clientes.dni");
				while (rs.next()) {
					String dni = rs.getString("dni");
					String nombre = rs.getString("nombre");
					String apellido1 = rs.getString("apellido1");
					String apellido2 = rs.getString("apellido2");
					int edad = rs.getInt("edad");
					String telefono = rs.getString("telefono");
					String email = rs.getString("email");
					int numCliente = rs.getInt("numCliente");

					// Crear objeto Cliente con la información obtenida
					Clientes cliente = new Clientes(dni, nombre, apellido1, apellido2, edad, telefono, email,
							numCliente);

					// Agregar el cliente a la lista
					aClientes.add(cliente);
				}
				// Consultar los datos de los socios en la base de datos y añadirlos al
				// ArrayList correspondiente

				rs = st.executeQuery(
						"SELECT personas.*, socios.numSocio FROM personas JOIN socios ON personas.dni = socios.dni");
				while (rs.next()) {
					String dni = rs.getString("dni");
					String nombre = rs.getString("nombre");
					String apellido1 = rs.getString("apellido1");
					String apellido2 = rs.getString("apellido2");
					int edad = rs.getInt("edad");
					String telefono = rs.getString("telefono");
					String email = rs.getString("email");
					int numSocio = rs.getInt("numSocio");

					// Crear objeto Cliente con la información obtenida
					Socios socio = new Socios(dni, nombre, apellido1, apellido2, edad, telefono, email, numSocio);

					// Agregar el cliente a la lista
					aSocios.add(socio);
				}
				// Consultar los datos de los hoteles en la base de datos y añadirlos al
				// ArrayList correspondiente

				rs = st.executeQuery("SELECT * FROM agencia_de_viajes.hoteles;");
				while (rs.next()) {
					aHoteles.add(new Hoteles(rs.getString("codH"), rs.getString("nombre"), rs.getString("direccion"),
							rs.getInt("numEstrellas"), rs.getString("tiempo"), rs.getDouble("precio")));
				}
				// Consultar los datos de los vuelos en la base de datos y añadirlos al
				// ArrayList correspondiente

				rs = st.executeQuery("SELECT * FROM agencia_de_viajes.vuelos;");
				while (rs.next()) {
					LocalDate fechaSalida = rs.getDate("fechaSalida").toLocalDate();
					LocalDate fechaLlegada = rs.getDate("fechaLlegada").toLocalDate();
					aVuelos.add(new Vuelos(rs.getString("codV"), rs.getString("aerolinea"), rs.getString("origen"),
							rs.getString("destino"), rs.getString("clase"), rs.getDouble("precio"), fechaSalida,
							fechaLlegada));
				}
				// Consultar los datos de las reservas de los hoteles en la base de datos y
				// añadirlos al ArrayList correspondiente

				rs = st.executeQuery("SELECT * FROM agencia_de_viajes.reservash;");
				while (rs.next()) {
					aReservasH.add(new ReservasH(rs.getString("dni"), rs.getString("codH"), rs.getInt("numRH"),
							rs.getDate("fechaRH").toLocalDate()));
				}
				// Consultar los datos de las reservas de vuelos en la base de datos y añadirlos
				// al ArrayList correspondiente

				rs = st.executeQuery("SELECT * FROM agencia_de_viajes.reservasv;");
				while (rs.next()) {
					aReservasV.add(new ReservasV(rs.getString("dni"), rs.getString("codV"), rs.getInt("numRV"),
							rs.getDate("fechaRV").toLocalDate()));
				}

				// cierro el resultset
				rs.close();
				// cierro el statement despues de realizar la consulta
				st.close();
				// cierro la conexion
			} catch (SQLException e) {
				// si no se ha conectado correctamente
				System.out.println("Error de conexión");
				throw new RuntimeException(
						" ===== No se pudo establecer la conexión con la base de datos. Acceso a la aplicación denegado. ===== ");
				// e.printStackTrace();
			} /**
				 * Método que establece la conexión con la base de datos y carga los datos en
				 * los ArrayList correspondientes.
				 * 
				 * @throws RuntimeException si no se puede establecer la conexión con la base de
				 *                          datos.
				 */

			String nuevoCodH = null;
			int numRH = 0;
			String nuevoCodV = null;
			int numRV = 0;
			/**
			 * Método principal que solicita el DNI del usuario, busca si corresponde a un
			 * cliente o a un socio, y muestra un mensaje de bienvenida o lanza una
			 * excepción en caso de que no se encuentre el DNI.
			 * 
			 * @param args los argumentos de la línea de comandos (no se utilizan en este
			 *             programa)
			 * @throws IllegalArgumentException si el DNI ingresado no es válido o si no se
			 *                                  encontró ningún cliente ni socio con ese
			 *                                  DNI.
			 */

			Scanner scanner = new Scanner(System.in);
			// Crea un cuadro de diálogo para ingresar el DNI
			String dniIngresado = "";
			while (true) {
				dniIngresado = JOptionPane.showInputDialog(null, "Ingrese su DNI:", "Login", JOptionPane.PLAIN_MESSAGE);
				dniIngresado = dniIngresado != null ? dniIngresado.toUpperCase() : ""; // Maneja el caso en que se
																						// presiona "Cancelar"

				try {
					if (!dniIngresado.matches("[0-9]{8}[A-Z]")) {
						throw new IllegalArgumentException(
								"El DNI ingresado no es válido. Por favor, ingrese un DNI válido.");
					}
					break;
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			// Busca el DNI en la lista de clientes y socios
			boolean esCliente = false;
			boolean esSocio = false;
			String nombre = "";

			for (Clientes cliente : aClientes) {
				if (cliente.getDni().equals(dniIngresado)) {
					esCliente = true;
					nombre = cliente.getNombre();
					break;
				}
			}

			if (!esCliente) {
				for (Socios socio : aSocios) {
					if (socio.getDni().equals(dniIngresado)) {
						esSocio = true;
						nombre = socio.getNombre();
						break;
					}
				}
			}

			// Muestra el mensaje de bienvenida o error
			if (esCliente) {
				JOptionPane.showMessageDialog(null, "Bienvenido Cliente " + nombre, "Bienvenida",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (esSocio) {
				JOptionPane.showMessageDialog(null, "Bienvenido Socio " + nombre, "Bienvenida",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				throw new IllegalArgumentException("Lo siento, no se encontró ningún cliente ni socio con ese DNI.");
				
			}LOGGER.info("LOGGER PRUEBA ERRORES");

			do {
				try {
					System.out.println("\nSeleccione una opción:");
					System.out.println("1. Mostrar Hoteles disponibles");
					System.out.println("2. Mostrar Vuelos disponibles");
					System.out.println("3. Consultar reserva Hotel");
					System.out.println("4. Consultar reserva Vuelo");
					System.out.println("5. Modificar reserva de Hotel");
					System.out.println("6. Modificar reserva de Vuelo");
					System.out.println("7. Anular reserva de Hotel");
					System.out.println("8. Anular reserva de Vuelos");
					System.out.println("9. Salir");

					opcion = scanner.nextInt();

					scanner.nextLine();

					switch (opcion) {

					case 1:
						do {
							// Mostrar lista de hoteles
							System.out.println("Lista de hoteles:");
							for (Hoteles hotel : aHoteles) {
								System.out.println(hotel.getCodH() + ". Nombre: " + hotel.getNombre() + ". Dirección: "
										+ hotel.getDireccion() + ". Estrellas: " + hotel.getNumEstrellas()
										+ ". Precio: - " + hotel.getPrecio());
							}

							// Pedir código de hotel a reservar o volver al menú
							System.out.println(
									"Ingrese el código del hotel que desea reservar o escriba el número '0' para volver al menú: ");
							String codH = scanner.nextLine();

							// Si el usuario eligió volver al menú, salir del bucle
							if (codH.equals("0")) {
								break;
							}

							// Buscar hotel en la lista de hoteles
							Hoteles hotelSeleccionado = null;
							for (Hoteles hotel : aHoteles) {
								if (hotel.getCodH().equals(codH)) {
									hotelSeleccionado = hotel;
									break;
								}
							}

							// Verificar si el hotel fue encontrado
							if (hotelSeleccionado == null) {
								System.out
										.println("==================================================================");
								System.out.println("El código de hotel ingresado no es válido.");
								System.out.println("Por favor introduzca un código de Hotel válido de la lista.");
								System.out
										.println("==================================================================");
							} else {
								// Obtener fecha actual
								LocalDate fechaReservaH = LocalDate.now();

								// Crear nueva reserva sin proporcionar el argumento numRH
								ReservasH nuevaReservaH = new ReservasH(dniIngresado, codH, aReservasH.size() + 1,
										fechaReservaH);

								// Agregar nueva reserva a la lista de reservas de hotel
								aReservasH.add(nuevaReservaH);
								agregadorh = true;

								System.out.println("Reserva realizada con éxito.");

								// Salir del bucle
								break;
							}
						} while (true);
						break;

					case 2:
						// Mostrar lista de Vuelos
						System.out.println("Lista de Vuelos:");
						for (Vuelos vuelo : aVuelos) {
							System.out.println(vuelo.getCodV() + ". Aerolínea: " + vuelo.getAerolinea() + ". Origen: "
									+ vuelo.getOrigen() + ". Destino " + vuelo.getDestino() + ". Clase: "
									+ vuelo.getClase() + ". Precio: " + vuelo.getPrecio() + ". Fecha de Salida: "
									+ vuelo.getFechaSalida() + ". Fecha de Llegada " + vuelo.getFechaLlegada());
						}

						// Pedir código de hotel a reservar
						System.out.print(
								"Introduzca el código del vuelo que desea reservar o introduzca el número 0 para regresar al menú: ");
						String codV = scanner.nextLine();

						// Si el usuario eligió volver al menú, salir del bucle
						if (codV.equals("0")) {
							break;
						}

						// Buscar hotel en la lista de hoteles
						Vuelos vueloSeleccionado = null;
						for (Vuelos vuelo : aVuelos) {
							if (vuelo.getCodV().equals(codV)) {
								vueloSeleccionado = vuelo;
								break;
							}
						}

						// Verificar si el hotel fue encontrado
						if (vueloSeleccionado == null) {
							System.out.println("==================================================================");
							System.out.println("El código de vuelo ingresado no es válido.");
							System.out.println("Por favor introduzca un código de Vuelo válido de la lista.");
							System.out.println("==================================================================");
						} else {
							// Obtener fecha actual
							LocalDate fechaReservaV = LocalDate.now();

							// Crear nueva reserva sin proporcionar el argumento numRH
							ReservasV nuevaReservaV = new ReservasV(dniIngresado, codV, aReservasV.size() + 1,
									fechaReservaV);

							// Verificar si el socio tiene derecho a descuento
							/*
							 * if (esSocio) { // Aplicar descuento del 30% double precioConDescuento =
							 * nuevaReservaV.aplicarDescuento(vueloSeleccionado.getPrecio());
							 * nuevaReservaV.setPrecio(precioConDescuento); }
							 */

							// Agregar nueva reserva a la lista de reservas de vuelos
							aReservasV.add(nuevaReservaV);

							// Agregar nueva reserva a la lista de reservas de vuelos
							aReservasV.add(nuevaReservaV);
							agregadorv = true;

							System.out.println("Reserva realizada con éxito.");

						}
						break;
					case 3:
						// Mostrar reservas del usuario
						System.out.println("Reservas de Hotel realizadas por el usuario con DNI " + dniIngresado + ":");
						boolean reservasEncontradasH = false;
						for (ReservasH reservah : aReservasH) {
							if (reservah.getDni().equals(dniIngresado)) {
								Hoteles hotelReservado = null;
								for (Hoteles hotel : aHoteles) {
									if (hotel.getCodH().equals(reservah.getCodH())) {
										hotelReservado = hotel;
										break;
									}
								}
								System.out.println("Reserva de hotel en " + hotelReservado.getNombre() + " de código "
										+ reservah.getCodH() + " para el día " + reservah.getFechaRH()
										+ " con número de reserva " + reservah.getNumRH());
								reservasEncontradasH = true;
							}
						}
						if (!reservasEncontradasH) {
							System.out.println("No se encontraron reservas para el usuario con DNI " + dniIngresado);
						}
						break;
					case 4:
						// Mostrar reservas del usuario
						System.out.println("Reservas de Vuelo realizadas por el usuario con DNI " + dniIngresado + ":");
						boolean reservasEncontradasV = false;
						for (ReservasV reservav : aReservasV) {
							if (reservav.getDni().equals(dniIngresado)) {
								Vuelos vueloReservado = null;
								for (Vuelos vuelo : aVuelos) {
									if (vuelo.getCodV().equals(reservav.getCodV())) {
										vueloReservado = vuelo;
										break;
									}
								}
								System.out.println("Reserva de hotel en " + vueloReservado.getAerolinea()
										+ " de código " + reservav.getCodV() + " para el día " + reservav.getFechaRV()
										+ " con número de reserva " + reservav.getNumRV());
								reservasEncontradasV = true;
							}
						}
						if (!reservasEncontradasV) {
							System.out.println("No se encontraron reservas para el usuario con DNI " + dniIngresado);
						}
						break;
					case 5:
						// Modificar reserva de hotel
						System.out.print("Introduzca el número de reserva de Hotel que desea modificar: ");
						numRH = scanner.nextInt();
						scanner.nextLine(); // Consumir el carácter de salto de línea restante

						// Buscar reserva en la lista de reservas de hotel
						ReservasH reservaModificarH = null;
						for (ReservasH reservah : aReservasH) {
							if (reservah.getNumRH() == numRH) {
								reservaModificarH = reservah;
								break;
							}
						}

						// Verificar si la reserva fue encontrada
						if (reservaModificarH == null) {
							System.out.println("La reserva ingresada no es válida.");
							System.out.println("Por favor introduzca un número de reserva válido.");
						} else {
							// Pedir al usuario que ingrese el nuevo código de hotel
							System.out.print("Introduzca el nuevo código de hotel: ");
							nuevoCodH = scanner.nextLine();

							// Actualizar el código de hotel en la reserva correspondiente
							reservaModificarH.setCodH(nuevoCodH);

							System.out.println("La reserva de su Hotel ha sido modificada correctamente.");
							modificadorh = true;
						}
						break;
					case 6:
						// Modificar reserva de hotel
						System.out.print("Introduzca el número de reserva de Vuelo que desea modificar: ");
						numRV = scanner.nextInt();
						scanner.nextLine(); // Consumir el carácter de salto de línea restante

						// Buscar reserva en la lista de reservas de hotel
						ReservasV reservaModificarV = null;
						for (ReservasV reservav : aReservasV) {
							if (reservav.getNumRV() == numRV) {
								reservaModificarV = reservav;
								break;
							}
						}

						// Verificar si la reserva fue encontrada
						if (reservaModificarV == null) {
							System.out.println("La reserva ingresada no es válida.");
							System.out.println("Por favor introduzca un número de reserva válido.");
						} else {
							// Pedir al usuario que ingrese el nuevo código de hotel
							System.out.print("Introduzca el nuevo código del Vuelo: ");
							nuevoCodV = scanner.nextLine();

							// Actualizar el código de hotel en la reserva correspondiente
							reservaModificarV.setCodV(nuevoCodV);

							System.out.println("La reserva ha sido modificada correctamente.");
							modificadorv = true;
						}
						break;
					case 7:
						// Eliminar reserva de hotel
						System.out.print("Introduzca el número de reserva de Hotel que desea eliminar: ");
						numRH = scanner.nextInt();
						scanner.nextLine(); // Consumir el carácter de salto de línea restante

						// Buscar reserva en la lista de reservas de hotel
						ReservasH reservaEliminarH = null;
						for (ReservasH reservah : aReservasH) {
							if (reservah.getNumRH() == numRH && reservah.getDni().equals(dniIngresado)) {
								reservaEliminarH = reservah;
								break;
							}
						}

						// Verificar si la reserva fue encontrada
						if (reservaEliminarH == null) {
							System.out.println("La reserva ingresada no es válida o no pertenece al usuario con DNI "
									+ dniIngresado + ".");
							System.out.println("Por favor introduzca un número de reserva válido.");
						} else {
							// Eliminar la reserva correspondiente
							aReservasH.remove(reservaEliminarH);
							System.out.println("La reserva ha sido eliminada correctamente.");
							eliminadorh = true;
						}

						break;
					case 8:
						// Eliminar reserva de vuelo
						System.out.print("Introduzca el número de reserva del Vuelo que desea eliminar: ");
						numRV = scanner.nextInt();
						scanner.nextLine(); // Consumir el carácter de salto de línea restante

						// Buscar reserva en la lista de reservas de vuelo
						ReservasV reservaEliminarV = null;
						for (ReservasV reservav : aReservasV) {
							if (reservav.getNumRV() == numRV && reservav.getDni().equals(dniIngresado)) {
								reservaEliminarV = reservav;
								break;
							}
						}

						// Verificar si la reserva fue encontrada
						if (reservaEliminarV == null) {
							System.out.println("La reserva ingresada no es válida o no pertenece al usuario con DNI "
									+ dniIngresado + ".");
							System.out.println("Por favor introduzca un número de reserva válido.");
						} else {
							// Eliminar la reserva correspondiente
							aReservasV.remove(reservaEliminarV);
							System.out.println("La reserva de su Vuelo ha sido eliminada correctamente.");
							eliminadorv = true;
						}
						break;

					case 9:
						System.out.println("Gracias por elegirnos. Hasta luego.");
						break;

					default:
						System.out.println("Opción inválida, por favor seleccione otra");
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Opción no válida. Intente de nuevo.");
					scanner.nextLine(); // Limpiar el buffer de entrada para evitar un bucle infinito
				}
			} while (opcion != 9);
			scanner.close();
			if (agregadorh) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes",
							"root", "");
					Statement st = conexion.createStatement();

					// Eliminar todas las reservas previas de hoteles
					String consulta = "DELETE FROM reservash;";
					st.executeUpdate(consulta);

					// Insertar las nuevas reservas
					consulta = "INSERT INTO reservash (dni, codH, numRH, fechaRH) VALUES (?, ?, ?, ?)";
					PreparedStatement ps = conexion.prepareStatement(consulta);

					for (ReservasH reservah : aReservasH) {
						String dni = reservah.getDni();
						numRH = reservah.getNumRH();
						String codH = reservah.getCodH();
						LocalDate fechaRH = reservah.getFechaRH();

						ps.setString(1, dni);
						ps.setString(2, codH);
						ps.setInt(3, numRH);
						ps.setDate(4, java.sql.Date.valueOf(fechaRH));

						ps.executeUpdate();
					}

					// Cerrar el statement y la conexión
					st.close();
					conexion.close();

					System.out.println("Las reservas de hoteles se han cargado correctamente en la base de datos.");

				} catch (SQLException e) {
					System.out.println("Error al cargar las reservas de hoteles en la base de datos.");
				}
			}
			if (agregadorv) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes",
							"root", "");
					Statement st = conexion.createStatement();

					// Eliminar todas las reservas previas de hoteles
					String consulta = "DELETE FROM reservasv;";
					st.executeUpdate(consulta);

					// Insertar las nuevas reservas
					consulta = "INSERT INTO reservasv (dni, codV, numRV, fechaRV) VALUES (?, ?, ?, ?)";
					PreparedStatement ps = conexion.prepareStatement(consulta);

					for (ReservasV reservav : aReservasV) {
						String dni = reservav.getDni();
						numRV = reservav.getNumRV();
						String codV = reservav.getCodV();
						LocalDate fechaRV = reservav.getFechaRV();

						ps.setString(1, dni);
						ps.setString(2, codV);
						ps.setInt(3, numRV);
						ps.setDate(4, java.sql.Date.valueOf(fechaRV));

						ps.executeUpdate();
					}

					// Cerrar el statement y la conexión
					st.close();
					conexion.close();

					System.out.println("Las reservas de vuelos se han cargado correctamente en la base de datos.");

				} catch (SQLException e) {
					System.out.println("Error al cargar las reservas de vuelos en la base de datos.");
				}
			}
			if (modificadorh) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes",
							"root", "");
					// Eliminar todas las reservas previas de hoteles
					String consulta = "UPDATE reservash SET codH = ? WHERE numRH = ?";
					PreparedStatement ps = conexion.prepareStatement(consulta);
					ps.setString(1, nuevoCodH);
					ps.setInt(2, numRH);
					ps.executeUpdate();
					ps.close();
					conexion.close();
					System.out.println("Su Hotel se ha modificado correctamente en la base de datos.");
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			if (modificadorv) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes",
							"root", "");
					// Eliminar todas las reservas previas de hoteles
					String consulta = "UPDATE reservasv SET codV = ? WHERE numRV = ?";
					PreparedStatement ps = conexion.prepareStatement(consulta);
					ps.setString(1, nuevoCodV);
					ps.setInt(2, numRV);
					ps.executeUpdate();
					ps.close();
					conexion.close();
					System.out.println("Su vuelo se ha modificado correctamente en la base de datos.");
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			if (eliminadorh) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes",
							"root", "");
					// Eliminar la reserva de hotel correspondiente
					String consulta = "DELETE FROM reservash WHERE numRH = ?";
					PreparedStatement ps = conexion.prepareStatement(consulta);
					ps.setInt(1, numRH);
					int filasAfectadas = ps.executeUpdate();
					ps.close();
					conexion.close();
					if (filasAfectadas > 0) {
						System.out.println("La reserva ha sido eliminada correctamente de la base de datos.");
						eliminadorh = true;
					} else {
						System.out.println("La reserva ingresada no es válida o no pertenece al usuario con DNI "
								+ dniIngresado + ".");
						System.out.println("Por favor introduzca un número de reserva válido.");
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			if (eliminadorv) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia_de_viajes",
							"root", "");
					// Eliminar la reserva de hotel correspondiente
					String consulta = "DELETE FROM reservasv WHERE numRV = ?";
					PreparedStatement ps = conexion.prepareStatement(consulta);
					ps.setInt(1, numRV);
					int filasAfectadas = ps.executeUpdate();
					ps.close();
					conexion.close();
					if (filasAfectadas > 0) {
						System.out.println("La reserva ha sido eliminada correctamente de la base de datos.");
						eliminadorv = true;
					} else {
						System.out.println("La reserva ingresada no es válida o no pertenece al usuario con DNI "
								+ dniIngresado + ".");
						System.out.println("Por favor introduzca un número de reserva válido.");
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Se ha producido un error", e);
			LOGGER.info("LOGGER PRUEBA ERRORES");
		} finally {
			if (fileHandler != null) {
				fileHandler.close();
			}
		}
	}
}
