/**
 * 
 */
package agenciadeviajes;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class ReservasHTest {
	/*Este test comprueba que al crear una nueva instancia de la clase ReservasH, los valores de sus atributos sean inicializados correctamente.

Primero, se crea una instancia de la clase ReservasH utilizando los argumentos especificados en el constructor. Luego, se llaman a los métodos getter de la instancia creada para obtener los valores de sus atributos y se comparan con los valores esperados utilizando el método assertEquals de JUnit.

Si los valores obtenidos de los métodos getter son iguales a los valores esperados, el test se considera exitoso. Si no, el test falla y se muestra un mensaje de error indicando qué valor esperado y qué valor obtenido no coinciden.*/

    @Test
    public void testGettersAndSetters() {
        ReservasH reserva = new ReservasH();
        reserva.setDni("12345678A");
        reserva.setCodH("HC001");
        reserva.setNumRH(1);
        reserva.setFechaRH(LocalDate.of(2023, 05, 1));

        Assert.assertEquals("12345678A", reserva.getDni());
        Assert.assertEquals("HC001", reserva.getCodH());
        Assert.assertEquals(1, reserva.getNumRH());
        Assert.assertEquals(LocalDate.of(2023, 05, 1), reserva.getFechaRH());
    }
}

