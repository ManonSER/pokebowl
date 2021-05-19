package sopra.pokebowl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="equipe")
public class Equipe {
	
	@Id
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="nom")
	private String nom;
	@Column(name="favorite")
	private Boolean favorite;
	@Column(name="nbr_pokemons")
	private Integer nbrPokemons;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateurEquipeSauv;
	@OneToOne(mappedBy="derniere_equipe")
	private Utilisateur utilisateurDeniereEquipe;
	@OneToMany(mappedBy="equipe")
	private List<MonPokemon> listPokemons;
	
	public Equipe() {
		this(null, null, null, null, null, null, null);
	}
	
	
	public Equipe(Integer numero, String nom, Boolean favorite, Integer nbrPokemons, Utilisateur utilisateurEquipeSauv,
			Utilisateur utilisateurDeniereEquipe, List<MonPokemon> listPokemons) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.favorite = favorite;
		this.nbrPokemons = nbrPokemons;
		this.utilisateurEquipeSauv = utilisateurEquipeSauv;
		this.utilisateurDeniereEquipe = utilisateurDeniereEquipe;
		this.listPokemons = listPokemons;
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


	public Utilisateur getUtilisateurEquipeSauv() {
		return utilisateurEquipeSauv;
	}


	public void setUtilisateurEquipeSauv(Utilisateur utilisateurEquipeSauv) {
		this.utilisateurEquipeSauv = utilisateurEquipeSauv;
	}


	public Utilisateur getUtilisateurDeniereEquipe() {
		return utilisateurDeniereEquipe;
	}


	public void setUtilisateurDeniereEquipe(Utilisateur utilisateurDeniereEquipe) {
		this.utilisateurDeniereEquipe = utilisateurDeniereEquipe;
	}


	public List<MonPokemon> getListPokemons() {
		return listPokemons;
	}


	public void setListPokemons(List<MonPokemon> listPokemons) {
		this.listPokemons = listPokemons;
	}
	
	
	
	
	

}
