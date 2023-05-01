/**
 * 
 */
package agenciadeviajes;

/*import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

public class SociosTest {

    @Test
    public void testLeerArchivoSocios() {
        // Crear un archivo temporal para el test
        File archivoPrueba = new File("sociostest.dat");
        try {
            archivoPrueba.createNewFile();

            // Crear algunos socios para escribir al archivo de prueba
            Socios socio1 = new Socios("Juan", "Perez", "12345678A", "juanperez@gmail.com", 25, null, null, 5);
            Socios socio2 = new Socios("Maria", "Gomez", "87654321B", "mariagomez@gmail.com", 32, null, null, 2);

            // Escribir los socios al archivo de prueba
            FileOutputStream fos = new FileOutputStream(archivoPrueba);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(socio1);
            oos.writeObject(socio2);
            oos.close();
            fos.close();

            // Leer los socios del archivo de prueba
            FileInputStream fis = new FileInputStream(archivoPrueba);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Socios socioLeido1 = (Socios) ois.readObject();
            Socios socioLeido2 = (Socios) ois.readObject();
            ois.close();
            fis.close();

            // Verificar que los socios leídos son iguales a los creados anteriormente
            assertEquals(socio1, socioLeido1);
            assertEquals(socio2, socioLeido2);

        } catch (IOException | ClassNotFoundException e) {
            fail("Se produjo una excepción al leer el archivo de prueba");
        } finally {
            archivoPrueba.delete();
        }
    }
}*/

