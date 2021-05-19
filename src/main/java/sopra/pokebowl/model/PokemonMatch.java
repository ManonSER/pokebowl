package sopra.pokebowl.model;

public class PokemonMatch {
	
	private int numero;
	private int hpMatch;
	private int attackMatch;
	private int defenseMatch;
	private int specialAttackMatch;
	private int defenseAttackMatch;
	private int speedMatch;
	private int numAttaqueActive;
	private Statut statut;
	private int ppAttaque1;
	private int ppAttaque2;
	private int ppAttaque3;
	private int ppAttaque4;
	
	public PokemonMatch() {
		super();
	}

	public PokemonMatch(int numero, int hpMatch, int attackMatch, int defenseMatch, int specialAttackMatch,
			int defenseAttackMatch, int speedMatch, int numAttaqueActive, Statut statut, int ppAttaque1, int ppAttaque2,
			int ppAttaque3, int ppAttaque4) {
		super();
		this.numero = numero;
		this.hpMatch = hpMatch;
		this.attackMatch = attackMatch;
		this.defenseMatch = defenseMatch;
		this.specialAttackMatch = specialAttackMatch;
		this.defenseAttackMatch = defenseAttackMatch;
		this.speedMatch = speedMatch;
		this.numAttaqueActive = numAttaqueActive;
		this.statut = statut;
		this.ppAttaque1 = ppAttaque1;
		this.ppAttaque2 = ppAttaque2;
		this.ppAttaque3 = ppAttaque3;
		this.ppAttaque4 = ppAttaque4;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getHpMatch() {
		return hpMatch;
	}

	public void setHpMatch(int hpMatch) {
		this.hpMatch = hpMatch;
	}

	public int getAttackMatch() {
		return attackMatch;
	}

	public void setAttackMatch(int attackMatch) {
		this.attackMatch = attackMatch;
	}

	public int getDefenseMatch() {
		return defenseMatch;
	}

	public void setDefenseMatch(int defenseMatch) {
		this.defenseMatch = defenseMatch;
	}

	public int getSpecialAttackMatch() {
		return specialAttackMatch;
	}

	public void setSpecialAttackMatch(int specialAttackMatch) {
		this.specialAttackMatch = specialAttackMatch;
	}

	public int getDefenseAttackMatch() {
		return defenseAttackMatch;
	}

	public void setDefenseAttackMatch(int defenseAttackMatch) {
		this.defenseAttackMatch = defenseAttackMatch;
	}

	public int getSpeedMatch() {
		return speedMatch;
	}

	public void setSpeedMatch(int speedMatch) {
		this.speedMatch = speedMatch;
	}

	public int getNumAttaqueActive() {
		return numAttaqueActive;
	}

	public void setNumAttaqueActive(int numAttaqueActive) {
		this.numAttaqueActive = numAttaqueActive;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public int getPpAttaque1() {
		return ppAttaque1;
	}

	public void setPpAttaque1(int ppAttaque1) {
		this.ppAttaque1 = ppAttaque1;
	}

	public int getPpAttaque2() {
		return ppAttaque2;
	}

	public void setPpAttaque2(int ppAttaque2) {
		this.ppAttaque2 = ppAttaque2;
	}

	public int getPpAttaque3() {
		return ppAttaque3;
	}

	public void setPpAttaque3(int ppAttaque3) {
		this.ppAttaque3 = ppAttaque3;
	}

	public int getPpAttaque4() {
		return ppAttaque4;
	}

	public void setPpAttaque4(int ppAttaque4) {
		this.ppAttaque4 = ppAttaque4;
	}
}
