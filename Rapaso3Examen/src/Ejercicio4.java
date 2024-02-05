import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int numeroPersonsa;
		System.out.println("Introduzca número de mesas");
		int mesa = Integer.parseInt(teclado.nextLine());
		int[] arrayMesa = new int[mesa];
		int[] arrayPersonas = new int[mesa];
		boolean encontrada = false;
		for (int i = 0; i < arrayMesa.length; i++) {
			arrayMesa[i] = (i + 1);
		}
		System.out.println("Mesa " + Arrays.toString(arrayMesa));
		for (int i = 0; i < arrayPersonas.length; i++) {
			arrayPersonas[i] = (int) (Math.random() * 5);
		}
		System.out.println("Personas " + Arrays.toString(arrayPersonas));
		do {
			System.out.println("¿Cuántos sois?");
			numeroPersonsa = Integer.parseInt(teclado.nextLine());
			if (numeroPersonsa < 1 || numeroPersonsa > 4) {
				System.out.println("Lo siento, no admitimos grupos de " + numeroPersonsa
						+ " personas, haga grupos de 4 personas como máximo e intente de nuevo");
			}
		} while (numeroPersonsa < 1 || numeroPersonsa > 4);

		for (int i = 0; i < arrayPersonas.length && !encontrada; i++) {
			if (arrayPersonas[i] == 0) {
				arrayPersonas[i] = numeroPersonsa;
				encontrada = true;
			} else if (arrayPersonas[i] + numeroPersonsa <= 4) {
				arrayPersonas[i] = arrayPersonas[i] + numeroPersonsa;
				encontrada = true;
			} else {
				System.out.println("Lo siento, no quedan mesas libres");
			}
		}
		if (encontrada) {
			System.out.println("Mesa " + Arrays.toString(arrayMesa));
			System.out.println("Personas " + Arrays.toString(arrayPersonas));
		}

	}

}
