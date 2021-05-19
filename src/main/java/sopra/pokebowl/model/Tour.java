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

@Entity
@Table(name = "tour")
public class Tour {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "actionJoueur1")
	private Action actionJoueur1;
	@Column(name = "actionJoueur2")
	private Action actionJoueur2;
	@Column(name = "attaquePokemon1")
	private String attaquePokemon1;
	@Column(name = "attaquePokemon2")
	private String attaquePokemon2;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "combat_id")
	private Combat combat;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pokemonMatch1")
	private PokemonMatch pokemonMatch1;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pokemonMatch2")
	private PokemonMatch pokemonMatch2;
	
	public Tour() {
		super();
	}
	
	public Tour(Long id, Action actionJoueur1, Action actionJoueur2, String attaquePokemon1, String attaquePokemon2) {
		super();
		this.id = id;
		this.actionJoueur1 = actionJoueur1;
		this.actionJoueur2 = actionJoueur2;
		this.attaquePokemon1 = attaquePokemon1;
		this.attaquePokemon2 = attaquePokemon2;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Action getActionJoueur1() {
		return actionJoueur1;
	}
	public void setActionJoueur1(Action actionJoueur1) {
		this.actionJoueur1 = actionJoueur1;
	}
	public Action getActionJoueur2() {
		return actionJoueur2;
	}
	public void setActionJoueur2(Action actionJoueur2) {
		this.actionJoueur2 = actionJoueur2;
	}
	public String getAttaquePokemon1() {
		return attaquePokemon1;
	}
	public void setAttaquePokemon1(String attaquePokemon1) {
		this.attaquePokemon1 = attaquePokemon1;
	}
	public String getAttaquePokemon2() {
		return attaquePokemon2;
	}
	public void setAttaquePokemon2(String attaquePokemon2) {
		this.attaquePokemon2 = attaquePokemon2;
	}

	public Combat getCombat() {
		return combat;
	}

	public void setCombat(Combat combat) {
		this.combat = combat;
	}

	public PokemonMatch getPokemonMatch1() {
		return pokemonMatch1;
	}

	public void setPokemonMatch1(PokemonMatch pokemonMatch1) {
		this.pokemonMatch1 = pokemonMatch1;
	}

	public PokemonMatch getPokemonMatch2() {
		return pokemonMatch2;
	}

	public void setPokemonMatch2(PokemonMatch pokemonMatch2) {
		this.pokemonMatch2 = pokemonMatch2;
	}	
	
}
