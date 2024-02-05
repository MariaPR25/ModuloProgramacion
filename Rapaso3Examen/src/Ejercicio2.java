import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
	private static Scanner teclado = new Scanner(System.in);
	private static final int MAX_VUELTAS = 4;
	private static final String[] COLORES = { "VERDE", "ROJO", "BLANCO", "NEGRO", "AZUL", "AMARILLO", "ROJO", "ROSA" };

	public static void main(String[] args) {
		String[] cadenaArray = new String[MAX_VUELTAS];
		for (int i = 0; i < MAX_VUELTAS; i++) {
			cadenaArray[i] = pedirPalabra("Introduce color o palabra: ");
		}

		System.out.println("Cadena Original:" + Arrays.toString(cadenaArray));

		arrayModificado(cadenaArray);

		System.out.println("Array Modificada:");
		System.out.println("Cadena Modificada:" + Arrays.toString(cadenaArray));
	}

	public static String pedirPalabra(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}

	public static void arrayModificado(String[] arrayFormado) {
		String[] arrayModificada = new String[arrayFormado.length];

		int posicionInicio = 0, posicionFin = arrayFormado.length - 1;
		for (int i = 0; i < arrayFormado.length; i++) {
			if (esColor(arrayFormado[i])) {
				arrayModificada[posicionInicio] = arrayFormado[i];
				posicionInicio++;
			} else {
				arrayModificada[posicionFin] = arrayFormado[i];
				posicionFin--;
			}
		}

		for (int i = 0; i < arrayModificada.length; i++) {
			arrayFormado[i] = arrayModificada[i];
		}

	}

	private static boolean esColor(String string) {

		boolean encontrado = false;

		for (int i = 0; i < COLORES.length && !encontrado; i++) {
			if (COLORES[i].equalsIgnoreCase(string)) {
				encontrado = true;
			}
		}
		return encontrado;
	}

}
