import java.util.Scanner;

public class Principal {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Mascota mascota1 = null, mascota2 = null;
		try {
			mascota1 = new Mascota("Nora", "PERRO");
			mascota2 = new Mascota("Kira", "GATO");
		} catch (MascotaException e) {
			System.out.println(e.getMessage());
		}
		int eleccion = 0;
		mostrarMenu();
		do {
			System.out.println("Introduzca eleción: ");
			eleccion = Integer.parseInt(teclado.nextLine());
		} while (eleccion != 5);
		tratarMenu(eleccion, mascota1, mascota2);

	}

	public static void mostrarMenu() {
		System.out.println("MENU: ");
		System.out.println("1.Dar comida a la mascota");
		System.out.println("2.Comprar comida");
		System.out.println("3.Jugar");
		System.out.println("4.Información de mascotas");
		System.out.println("5.Salir");
	}

	public static void tratarMenu(int eleccion, Mascota mascota1, Mascota mascota2) {
		int decision, comida, minutos;
		switch (eleccion) {
		case 1:
			System.err.println("¿A qué mascota quieres dar de comer, 1-2?");
			decision = Integer.parseInt(teclado.nextLine());
			if (decision != 1 || decision != 2) {
				System.out.println("Debe elegir entre mascota 1 o 2");
			}
			if (decision == 1) {
				try {
					mascota1.darDeComerMascota();
				} catch (MascotaException e) {
					System.out.println(e.getMessage());
				}
			} else {
				try {
					mascota2.darDeComerMascota();
				} catch (MascotaException e) {
					System.out.println(e.getMessage());
				}
			}
			break;
		case 2:
			System.err.println("¿A qué mascota comprar comida, 1-2?");
			decision = Integer.parseInt(teclado.nextLine());
			if (decision != 1 || decision != 2) {
				System.out.println("Debe elegir entre mascota 1 o 2");
			}
			System.out.println("¿Cuánta comida quieres darle?");
			comida = Integer.parseInt(teclado.nextLine());
			if (decision == 1) {
				try {
					mascota1.comprarComida(comida);
				} catch (MascotaException e) {
					System.out.println(e.getMessage());
				}
			} else {
				try {
					mascota2.comprarComida(comida);
				} catch (MascotaException e) {
					System.out.println(e.getMessage());
				}
			}
			break;
		case 3:
			System.err.println("¿Con qué mascota quieres jugar, 1-2?");
			decision = Integer.parseInt(teclado.nextLine());
			if (decision != 1 || decision != 2) {
				System.out.println("Debe elegir entre mascota 1 o 2");
			}
			System.out.println("¿Cuántos minutos quieres jugar?");
			minutos = Integer.parseInt(teclado.nextLine());

			if (decision == 1) {
				try {
					mascota1.jugar(minutos);
				} catch (MascotaException e) {
					System.out.println(e.getMessage());
				}
			} else {
				try {
					mascota2.jugar(minutos);
				} catch (MascotaException e) {
					System.out.println(e.getMessage());
				}
			}

			break;
		case 4:
			System.out.println(mascota1);
			System.out.println(mascota2);

			break;
		case 5:
			System.out.println("Va a salir del juego");
			break;

		}
	}
}
