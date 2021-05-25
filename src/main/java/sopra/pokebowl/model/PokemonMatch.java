package sopra.pokebowl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "pokemon_match")
public class PokemonMatch {
	
	@Id
	@GeneratedValue
	private Integer numero;
	@Version
	private int version;
	@Column(name = "hpMatch")
	private int hpMatch;
	@Column(name = "acttackMatch")
	private int attackMatch;
	@Column(name = "defenseMatch")
	private int defenseMatch;
	@Column(name = "specialAttackMatch")
	private int specialAttackMatch;
	@Column(name = "defenseActtackMatch")
	private int specialDefenseMatch;
	@Column(name = "speedMatch")
	private int speedMatch;
	@Column(name = "numAttaqueActive")
	private int numAttaqueActive;
	@Column(name = "statut")
	private Statut statut;
	@Column(name = "ppAttaque1")
	private int ppAttaque1;
	@Column(name = "ppAttaque2")
	private int ppAttaque2;
	@Column(name = "ppAttaque3")
	private int ppAttaque3;
	@Column(name = "ppAttaque4")
	private int ppAttaque4;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="monPokemon_id")
	private MonPokemon monPokemon;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "combat_id")
	private Combat combat;
	
	
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
		this.specialDefenseMatch = defenseAttackMatch;
		this.speedMatch = speedMatch;
		this.numAttaqueActive = numAttaqueActive;
		this.statut = statut;
		this.ppAttaque1 = ppAttaque1;
		this.ppAttaque2 = ppAttaque2;
		this.ppAttaque3 = ppAttaque3;
		this.ppAttaque4 = ppAttaque4;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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

	public int getSpecialDefenseMatch() {
		return specialDefenseMatch;
	}

	public void setSpecialDefenseMatch(int defenseAttackMatch) {
		this.specialDefenseMatch = defenseAttackMatch;
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

	public MonPokemon getMonPokemon() {
		return monPokemon;
	}

	public void setMonPokemon(MonPokemon monPokemon) {
		this.monPokemon = monPokemon;
	}

	public Combat getCombat() {
		return combat;
	}

	public void setCombat(Combat combat) {
		this.combat = combat;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
