import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import entidad.Muniemon;
import entidad.Tipo;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Muniemon> listaMuniemones = new ArrayList<Muniemon>();
		
		printHeader();
		startGame(listaMuniemones);
		printFooter();

	}

	// Imprime el header del juego
	public static void printHeader() {
		// Cabecera del juego
		System.out.println("  ------------------------  ");
		System.out.println("| MUNIEMON EDICIÓN CRISTAL |");
		System.out.println("  ------------------------  ");
		System.out.println("");
	}
	
	// Lógica del juego
	public static void startGame(ArrayList<Muniemon> listaMuniemones) {
		int userChoice = 8; // Opción del usuario para interactuar con el menú

		// Imprime el menú la primera vez
		printMenu(listaMuniemones);

		// Imprime el menú de nuevo si la selección no es salir del juego
		while (userChoice != 7) {

			switch (userChoice) {
			case 1:
				modifyMuniemon(0, listaMuniemones);
				printMenu(listaMuniemones);
				userChoice = sc.nextInt();
				break;
			case 2:
				modifyMuniemon(1, listaMuniemones);
				printMenu(listaMuniemones);
				userChoice = sc.nextInt();
				break;
			case 3:
				System.out.println(listaMuniemones.get(0));
				printMenu(listaMuniemones);
				userChoice = sc.nextInt();
				break;
			case 4:
				System.out.println(listaMuniemones.get(1));
				printMenu(listaMuniemones);
				userChoice = sc.nextInt();
				break;
			case 5:
				listaMuniemones.get(0).atacar(listaMuniemones.get(1));
				printMenu(listaMuniemones);
				userChoice = sc.nextInt();
				break;
			case 6:
				listaMuniemones.get(1).atacar(listaMuniemones.get(0));
				printMenu(listaMuniemones);
				userChoice = sc.nextInt();
				break;
			default:
				printMenu(listaMuniemones);
				userChoice = sc.nextInt();
				break;
			}
		}
	}
	
	// Imprime el footer del juego
	public static void printFooter() {
		// Footer juego GAME OVER
		System.out.println("  ---------  ");
		System.out.println("| Game Over |");
		System.out.println("  ---------  ");
	}
	
	// Menú del juego
	public static void printMenu(ArrayList<Muniemon> listaMuniemones) {

		if (listaMuniemones.isEmpty()) {
			System.out.println("Bienvenido al mundo de los Muniemon. Para empezar, necesitarás crear 2 Muniemones.");
			System.out.println("");
			System.out.println("Muniemon 1:");
			listaMuniemones.add(createMuniemon());
			sc.nextLine();
			System.out.println("Muniemon 2:");
			listaMuniemones.add(createMuniemon());
		} else if (!listaMuniemones.isEmpty()) {
			System.out.println("- Pulsa 1 para modificar el Muniemon 1");
			System.out.println("- Pulsa 2 para modificar el Muniemon 2");
			System.out.println("- Pulsa 3 para mostrar el Muniemon 1");
			System.out.println("- Pulsa 4 para mostrar el Muniemon 2");
			System.out.println("- Pulsa 5 para empezar el combate");
			System.out.println("- Pulsa 6 para salir del juego");
		}

	}

	// Función para crear un Muniemon
	public static Muniemon createMuniemon() {
		sc.nextLine();
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
		System.out.print("- Velocidad: ");
		int velocidad = sc.nextInt();
		System.out.println("");

		System.out.println("Pulsa un número de la lista para elegir el tipo: ");
		System.out.println("1. Agua");
		System.out.println("2. Fuego");
		System.out.println("3. Planta");

		int seleccionTipo = sc.nextInt();
		Tipo tipo = null;

		switch (seleccionTipo) {
		case 1:
			tipo = Tipo.AGUA;
			break;
		case 2:
			tipo = Tipo.FUEGO;
			break;
		case 3:
			tipo = Tipo.PLANTA;
			break;
		}

		// Instanciamos un nuevo objeto Muniemon por constructor con las variables
		// locales definidas en esta función
		Muniemon muniemon = new Muniemon(nombre, vida, ataque, defensa, velocidad, tipo);
		return muniemon;

	}

	// Función para modificar el Muniemon
	public static void modifyMuniemon(int index, ArrayList<Muniemon> listaMuniemones) {
		System.out
				.println("Ya existe el Muniemon " + (index + 1) + ", ¿quieres crear otro y sobreescribir el anterior?");
		System.out.println("Pulsa 1 para crear un nuevo Muniemon o 2 para descartarlo");
		int choice = sc.nextInt();
		if (choice == 1) {
			listaMuniemones.set(index, createMuniemon());
		}
	}
}
