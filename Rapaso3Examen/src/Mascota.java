import java.util.Objects;

public class Mascota {

	private String nombre;
	private String tipo = "PERRO, GATO";
	public static final int CUESTA_ALIMENTO = 30;
	public static final int MINUTOS_MAXIMO_JUEGO = 20;
	public static final int CONTROL_PARENTAL = 100;
	private int acumulaPuntoMascota;
	public static final String COMIDA = "HUESOS, PESCADO";
	private int almacen, minutosJuego;
	private static int tiempoAcumuladoJuego;
	private boolean sePuedeJugar;

	public Mascota(String nombre, String tipo) throws MascotaException {
		this.nombre = nombre;
		if ( !  (tipo.equals("PERRO")  || tipo.equals("GATO"))) {
			throw new MascotaException("Tipo de mascota incorrecto");
		}
		this.tipo=tipo;
		almacen = 0;
		acumulaPuntoMascota = 0;
		sePuedeJugar = true;
	}

	public static int getTiempoAcumuladoJuego() {
		return tiempoAcumuladoJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	
	public int getAcumulaPuntoMascota() {
		return acumulaPuntoMascota;
	}

	public int getAlmacen() {
		return almacen;
	}

	@Override
	public String toString() {
		String cadena;
		if (tipo == "PERRO") {
			cadena = "Mascota [nombre=" + nombre + ", tipo=" + tipo + ", acumulaPuntoMascota=" + acumulaPuntoMascota
					+ ", Huesos=" + almacen + ", minutosJuego=" + minutosJuego + "]";
		}
		if (tipo == "GATO") {
			cadena = "Mascota [nombre=" + nombre + ", tipo=" + tipo + ", acumulaPuntoMascota=" + acumulaPuntoMascota
					+ ", pescados=" + almacen + ", minutosJuego=" + minutosJuego + "]";
		}
		return nombre;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public void darDeComerMascota() throws MascotaException{
		if(almacen<=0) {
			throw new MascotaException("No hay comida en el almacén");
		}
		almacen--;
	}

	public void comprarComida(int numeroAlimentos) throws MascotaException {
		if (numeroAlimentos < 0) {
			throw new MascotaException("Error, debe ser número positivo");
		}
		if (acumulaPuntoMascota < (numeroAlimentos * CUESTA_ALIMENTO)) {
			throw new MascotaException("Error, no hay puntos suficientes");
		}
		acumulaPuntoMascota -= numeroAlimentos * CUESTA_ALIMENTO;
		almacen = almacen + numeroAlimentos;
	}

	public void jugar(int minutos) throws MascotaException {
		if (minutos < 0 || minutos > MINUTOS_MAXIMO_JUEGO) {
			throw new MascotaException("Error, minutos fuera de rango");
		}
		for (int i = 0; i < minutos && sePuedeJugar; i++) {
			if (tiempoAcumuladoJuego > CONTROL_PARENTAL) {
				sePuedeJugar = false;
				throw new MascotaException("Las mascotas tienen sueño... Se van a dormir ZZZZ");
			}
			acumulaPuntoMascota = acumulaPuntoMascota + 3;

			tiempoAcumuladoJuego += minutos;
			if (tiempoAcumuladoJuego > CONTROL_PARENTAL) {
				sePuedeJugar = false;
				throw new MascotaException("Las mascotas tienen sueño... Se van a dormir ZZZZ");
			}
		}
	}

}
