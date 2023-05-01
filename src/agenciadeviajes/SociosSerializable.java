package agenciadeviajes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SociosSerializable {
	/**

	Clase que muestra un ejemplo de cómo guardar un objeto de tipo Socios en un fichero binario utilizando la serialización.

	Se crea un objeto Socios y se guarda en el fichero "socios.dat".

	Si el fichero ya existe, se sobreescribe con el nuevo objeto.
	*/

	public static void main(String[] args) {
		
		Socios s = new Socios("1236021A", "Antonio","Gonzales","Gonzales", 25,"3153372412", "antonio@gmail.com", 50);
		
		// lo guardo en el fichero socios.dat
		/**

		Método main que crea un objeto Socios y lo guarda en el fichero "socios.dat".

		@param args Argumentos de línea de comandos (no utilizados en este programa).
		*/
				try {
					FileOutputStream fos = new FileOutputStream("socios.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					// lo grabo
					oos.writeObject(s);
					// cierro el fichero
					oos.close();
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
			}
	}
}
