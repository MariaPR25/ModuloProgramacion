import java.util.Scanner;

public class Ejercicio1 {
	private static Scanner teclado = new Scanner (System.in);
private static final String [] DIAS_SEMANA ={"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES"};
	public static void main(String[] args) {
		String dia;
		boolean valido=false;
		System.out.println("Introduce dia de la semana por favor");
		dia=teclado.nextLine().toUpperCase();
		for (int i = 0; i < DIAS_SEMANA.length; i++) {
			if (DIAS_SEMANA[i].equals(dia)) {
				valido=true;
			}
		}
		
		System.out.println("El dato introducido "+dia+" es "+valido);
	}

}
