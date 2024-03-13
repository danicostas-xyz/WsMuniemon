package entidad;

public class Muniemon {

	// Definición de atributos de la clase Muniemon

	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private Tipo tipo;

	// Constructores

	public Muniemon() {
		super();
	}

	public Muniemon(String nombre, int vida, int ataque, int defensa, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.tipo = tipo;
	}

	// Métodos

	@Override
	public String toString() {
		return "Muniemon [nombre=" + nombre + ", vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa
				+ ", tipo=" + tipo + "]";
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
				int danho = this.ataque - muniemon.getDefensa();
				muniemon.setVida(vidaOponente -= danho);
			} else {
				System.out.println(muniemon.getNombre() + " está debilitado, " + this.nombre + " no puede atacarle.");
			}
		} else {
			System.out.println(this.getNombre() + " está debilitado y no puede atacar a " + muniemon.getNombre());
		}

	}

}
