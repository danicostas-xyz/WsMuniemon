import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import entidad.Muniemon;
import entidad.Tipo;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Cabecera del juego
		System.out.println("  ------------------------  ");
		System.out.println("| MUNIEMON EDICIÓN CRISTAL |");
		System.out.println("  ------------------------  ");
		System.out.println("");

		int exit = 1;
		ArrayList<Muniemon> listaMuniemones = new ArrayList<Muniemon>();

		// Imprime el menú la primera vez
		imprimirMenu(listaMuniemones);

		// Imprime el menú de nuevo si la selección es 1 (crear) o 2 (mostrar) y sale
		// del juego si es 3
		while (exit != 3) {
			if (exit == 1) {
				listaMuniemones.add(crearMuniemon());
				imprimirMenu(listaMuniemones);
				exit = sc.nextInt();
				sc.nextLine();
				System.out.println("");
			} else if (exit == 2) {
				for (Muniemon m : listaMuniemones) {
					System.out.println(m);
				}
				System.out.println("");
				System.out.println("- Pulsa 1 si quieres crear otro Muniemon");
				System.out.println("- Pulsa 2 para mostrar tus Muniemones");
				System.out.println("- Pulsa 3 para salir del juego");
				exit = sc.nextInt();
				sc.nextLine();
			}
		}

		// Footer juego GAME OVER
		System.out.println("  ---------  ");
		System.out.println("| Game Over |");
		System.out.println("  ---------  ");

	}

	// Menú del juego
	public static void imprimirMenu(ArrayList<Muniemon> listaMuniemones) {

		if (listaMuniemones.isEmpty()) {
			System.out.println("Bienvenido al mundo de los Muniemon. Para empezar, necesitarás tener un Muniemon.");
			System.out.println("");
		} else if (!listaMuniemones.isEmpty()) {
			System.out.println("- Pulsa 1 si quieres crear otro Muniemon");
			System.out.println("- Pulsa 2 para mostrar tus Muniemones");
			System.out.println("- Pulsa 3 para salir del juego");
		}

	}

	// Función para crear un Muniemon
	public static Muniemon crearMuniemon() {
		System.out.println("Introduce los datos de tu Muniemon");
		System.out.println("----------------------------------");
		System.out.print("- Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("- Vida: ");
		int vida = sc.nextInt();
		System.out.print("- Ataque: ");
		int ataque = sc.nextInt();
		System.out.print("- Defensa: ");
		int defensa = sc.nextInt();
		System.out.println("");

		System.out.println("Pulsa un número de la lista para elegir el tipo: ");
		System.out.println("1. Agua");
		System.out.println("2. Tierra");
		System.out.println("3. Fuego");
		System.out.println("4. Planta");

		int seleccionTipo = sc.nextInt();
		Tipo tipo;

		switch (seleccionTipo) {
		case 1:
			tipo = Tipo.AGUA;
			break;
		case 2:
			tipo = Tipo.TIERRA;
			break;
		case 3:
			tipo = Tipo.FUEGO;
			break;
		case 4:
			tipo = Tipo.PLANTA;
			break;
		default:
			tipo = Tipo.AGUA;
			break;
		}

		Muniemon muniemon = new Muniemon(nombre, vida, ataque, defensa, tipo);
		return muniemon;

	}

}
