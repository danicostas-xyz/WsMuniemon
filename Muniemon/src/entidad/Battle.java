package entidad;

public class Battle {
	
	// - Atributos
	private Muniemon muniemon1;
	private Muniemon muniemon2;

	// - Constructores
	public Battle(Muniemon muniemon1, Muniemon muniemon2) {
		super();
		this.muniemon1 = muniemon1;
		this.muniemon2 = muniemon2;
	}

	public Battle() {
		super();
	}

	// - Getters & Setters
	public Muniemon getMuniemon1() {
		return muniemon1;
	}

	public void setMuniemon1(Muniemon muniemon1) {
		this.muniemon1 = muniemon1;
	}

	public Muniemon getMuniemon2() {
		return muniemon2;
	}

	public void setMuniemon2(Muniemon muniemon2) {
		this.muniemon2 = muniemon2;
	}
	
	public Muniemon startBattle() {
		Muniemon winner = null;
		
		System.out.println(muniemon1);
		
		
		return winner;
		
	}

}
