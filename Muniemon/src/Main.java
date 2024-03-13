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

		int seleccionUsuario = 8;
		ArrayList<Muniemon> listaMuniemones = new ArrayList<Muniemon>();

		// Imprime el menú la primera vez
		imprimirMenu(listaMuniemones);

		// Imprime el menú de nuevo si la selección no es 7 (salir del juego)
		while (seleccionUsuario != 7) {

			switch (seleccionUsuario) {
			case 1:
				anhadirMuniemon(0, listaMuniemones);
				imprimirMenu(listaMuniemones);
				seleccionUsuario = sc.nextInt();
				break;
			case 2:
				anhadirMuniemon(1, listaMuniemones);
				imprimirMenu(listaMuniemones);
				seleccionUsuario = sc.nextInt();
				break;
			case 3:
				System.out.println(listaMuniemones.get(0));
				imprimirMenu(listaMuniemones);
				seleccionUsuario = sc.nextInt();
				break;
			case 4:
				System.out.println(listaMuniemones.get(1));
				imprimirMenu(listaMuniemones);
				seleccionUsuario = sc.nextInt();
				break;
			case 5:
				listaMuniemones.get(0).atacar(listaMuniemones.get(1));
				imprimirMenu(listaMuniemones);
				seleccionUsuario = sc.nextInt();
				break;
			case 6:
				listaMuniemones.get(1).atacar(listaMuniemones.get(0));
				imprimirMenu(listaMuniemones);
				seleccionUsuario = sc.nextInt();
				break;
			default:
				imprimirMenu(listaMuniemones);
				seleccionUsuario = sc.nextInt();
				break;
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
			System.out.println("Bienvenido al mundo de los Muniemon. Para empezar, necesitarás crear 2 Muniemones.");
			System.out.println("");
			System.out.println("Muniemon 1:");
			listaMuniemones.add(crearMuniemon());
			System.out.println("Muniemon 2:");
			listaMuniemones.add(crearMuniemon());
		} else if (!listaMuniemones.isEmpty()) {
			System.out.println("- Pulsa 1 para crear el Muniemon 1");
			System.out.println("- Pulsa 2 para crear el Muniemon 2");
			System.out.println("- Pulsa 3 para mostrar el Muniemon 1");
			System.out.println("- Pulsa 4 para mostrar el Muniemon 2");
			System.out.println("- Pulsa 5 para que Muniemon 1 ataque a Muniemon 2");
			System.out.println("- Pulsa 6 para Muniemon 2 ataque a Muniemon 1");
			System.out.println("- Pulsa 7 para salir del juego");
		}

	}

	// Función para crear un Muniemon
	public static Muniemon crearMuniemon() {
		System.out.println("Introduce los datos de tu Muniemon");
		System.out.println("----------------------------------");
		System.out.print("- Nombre: ");
		String nombre;
		if (sc.hasNextLine()) {
			nombre = sc.nextLine();
		} else {
			sc.nextLine();
			nombre = sc.nextLine();
		}
		
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

		// Instanciamos un nuevo objeto Muniemon por constructor con las variables
		// locales definidas en esta función
		Muniemon muniemon = new Muniemon(nombre, vida, ataque, defensa, tipo);
		return muniemon;

	}

	public static void anhadirMuniemon(int index, ArrayList<Muniemon> listaMuniemones) {
			System.out.println(
					"Ya existe el Muniemon " + (index + 1) + ", ¿quieres crear otro y sobreescribir el anterior?");
			System.out.println("Pulsa 1 para crear un nuevo Muniemon o 2 para descartarlo");
			int seleccion = sc.nextInt();
			if (seleccion == 1) {
				listaMuniemones.set(index, crearMuniemon());
			}
	}

}
