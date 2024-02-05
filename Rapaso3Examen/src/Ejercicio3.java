import java.util.Arrays;

public class Ejercicio3 {
	public static void main(String[] args) {
		int[] arrayOriginal = new int[15];

		// Llenar el array con números enteros aleatorios entre 0 y 500 (ambos
		// incluidos)
		for (int i = 0; i < arrayOriginal.length; i++) {
			arrayOriginal[i] = (int) (Math.random() * 501);
		}

		System.out.println("Array original: " + Arrays.toString(arrayOriginal));

		// Cincuerizar el array
		cincuerizarArray(arrayOriginal);

		System.out.println("Array cincuerizado: " + Arrays.toString(arrayOriginal));
	}

	public static void cincuerizarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 5 != 0) {
				// Si el número no es múltiplo de 5, encontrar el siguiente múltiplo de 5
				array[i] = ((array[i] / 5) + 1) * 5;
			}
		}
	}
}
