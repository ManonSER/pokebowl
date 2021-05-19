package sopra.pokebowl.model;

import java.util.List;

public class Equipe {
	
	private Integer numero;
	private String nom;
	private Boolean favorite;
	private Integer nbrPokemons;
	
	private Utilisateur utilisateur;
	private List<MonPokemon> listPokemons;
	
	public Equipe() {
		this(null, null, null, null);
	}
	
	public Equipe(Integer numero, String nom, Boolean favorite, Integer nbrPokemons) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.favorite = favorite;
		this.nbrPokemons = nbrPokemons;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public Integer getNbrPokemons() {
		return nbrPokemons;
	}

	public void setNbrPokemons(Integer nbrPokemons) {
		this.nbrPokemons = nbrPokemons;
	}
	
	
	
	
	

}
