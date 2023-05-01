/**
 * 
 */
package agenciadeviajes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservasVTest {
	
	private ReservasV reserva;
	
	@BeforeEach
	public void setUp() {
		reserva = new ReservasV("12345678A", "VC001", 1, LocalDate.now());
	}
	
	@Test
	public void testGettersAndSetters() {
		reserva.setDni("87654321B");
		assertEquals("87654321B", reserva.getDni());
		
		reserva.setCodV("VC002");
		assertEquals("VC002", reserva.getCodV());
		
		reserva.setNumRV(2);
		assertEquals(2, reserva.getNumRV());
		
		LocalDate nuevaFecha = LocalDate.now().plusDays(1);
		reserva.setFechaRV(nuevaFecha);
		assertEquals(nuevaFecha, reserva.getFechaRV());
	}
	
	@Test
	public void testToString() {
		String expectedString = "ReservasV [dni=12345678A, codV=VC001, numRV=1, fechaRV=" + LocalDate.now() + "]";
		assertEquals(expectedString, reserva.toString());
	}
	
	/*@Test
	public void testAplicarDescuento() {
		// Como la clase ReservasV no implementa todavía la lógica para aplicar descuentos,
		// simplemente comprobamos que el precio no cambie
		double precioInicial = 100.0;
		double precioFinal = reserva.aplicarDescuento(precioInicial);
		assertEquals(precioInicial, precioFinal);
	}*/
	
}
