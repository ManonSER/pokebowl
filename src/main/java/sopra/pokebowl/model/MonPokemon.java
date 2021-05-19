package sopra.pokebowl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mon_pokemon")
public class MonPokemon {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="ordre")
	private Integer ordre;
	
	@ManyToOne
	@JoinColumn(name="numero_equipe")
	private Equipe equipe;
	@OneToOne
	@JoinColumn(name="id_pokemon")
	private Pokemon pokeReference;
	@OneToOne
	@JoinColumn(name="id_attaque1")
	private Attaque attaque1;
	@OneToOne
	@JoinColumn(name="id_attaque2")
	private Attaque attaque2;
	@OneToOne
	@JoinColumn(name="id_attaque3")
	private Attaque attaque3;
	@OneToOne
	@JoinColumn(name="id_attaque4")
	private Attaque attaque4;
	@OneToOne(mappedBy="monPokemon")
	private PokemonMatch pokeMatch;
	
	public MonPokemon() {
		this(null, null, null, null, null, null, null, null);
	}
	
	public MonPokemon(Integer ordre, Equipe equipe, Pokemon pokeReference, Attaque attaque1, Attaque attaque2,
			Attaque attaque3, Attaque attaque4, PokemonMatch pokeMatch) {
		super();
		this.ordre = ordre;
		this.equipe = equipe;
		this.pokeReference = pokeReference;
		this.attaque1 = attaque1;
		this.attaque2 = attaque2;
		this.attaque3 = attaque3;
		this.attaque4 = attaque4;
		this.pokeMatch = pokeMatch;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}



	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}



	public Pokemon getPokeReference() {
		return pokeReference;
	}



	public void setPokeReference(Pokemon pokeReference) {
		this.pokeReference = pokeReference;
	}



	public Attaque getAttaque1() {
		return attaque1;
	}



	public void setAttaque1(Attaque attaque1) {
		this.attaque1 = attaque1;
	}



	public Attaque getAttaque2() {
		return attaque2;
	}



	public void setAttaque2(Attaque attaque2) {
		this.attaque2 = attaque2;
	}



	public Attaque getAttaque3() {
		return attaque3;
	}



	public void setAttaque3(Attaque attaque3) {
		this.attaque3 = attaque3;
	}



	public Attaque getAttaque4() {
		return attaque4;
	}



	public void setAttaque4(Attaque attaque4) {
		this.attaque4 = attaque4;
	}



	public PokemonMatch getPokeMatch() {
		return pokeMatch;
	}



	public void setPokeMatch(PokemonMatch pokeMatch) {
		this.pokeMatch = pokeMatch;
	}
	
	
	

}
