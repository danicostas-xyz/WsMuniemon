package entidad;

public class Muniemon {

	// Definición de atributos de la clase Muniemon

	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private int velocidad;
	private Tipo tipo;

	// Constructores

	public Muniemon() {
		super();
	}

	public Muniemon(String nombre, int vida, int ataque, int defensa, int velocidad, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.tipo = tipo;
	}

	// Métodos

	@Override
	public String toString() {
		return "Muniemon [Nombre: " + nombre + ", Vida: " + vida + ", Ataque: " + ataque + ", Defensa: " + defensa
				+ "Velocidad: " + velocidad + ", Tipo: " + tipo + "]";
	}

	// Métodos Setter & Getter

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void atacar(Muniemon muniemon) {
		int vidaOponente = muniemon.getVida();
		if (this.getVida() > 0) {
			if (vidaOponente > 0) {
				int danho = 0;
				if (this.ataque > muniemon.getDefensa()) {
					danho = this.ataque - muniemon.getDefensa();
					muniemon.setVida(vidaOponente -= danho);
					if (muniemon.getVida() < 0) {
						muniemon.setVida(0);
					}
					System.out.println("¡" + this.getNombre() + " ataca a " + muniemon.getNombre() + "!");
					System.out.println("Daño: " + danho);
					System.out.println("Vida de " + muniemon.getNombre() + ": " + muniemon.getVida());
					if (muniemon.getVida() == 0) {
						System.out.println("¡" + muniemon.getNombre() + " ha sido debilitado!");
					}
				} else {
					danho = 1;
					muniemon.setVida(vidaOponente -= danho);
					System.out.println("¡" + this.getNombre() + " ataca a " + muniemon.getNombre() + "!");
					System.out.println("Daño: " + danho);
					System.out.println("Vida de " + muniemon.getNombre() + ": " + muniemon.getVida());
					if (muniemon.getVida() == 0) {
						System.out.println("¡" + muniemon.getNombre() + " ha sido debilitado!");
					}
				}

			} else {
				System.out.println(muniemon.getNombre() + " está debilitado, " + this.nombre + " no puede atacarle.");
			}
		} else {
			System.out.println(this.getNombre() + " está debilitado y no puede atacar a " + muniemon.getNombre());
		}

	}

}
