package sopra.pokebowl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "combat")
public class Combat {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "id_utilisateur_gagnant")
	private Long idUtilisateurGagnant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salon_id")
	private Salon salon;
	@OneToMany(mappedBy = "combat")
	private List<Tour> tours = new ArrayList<Tour>();
	@OneToMany(mappedBy = "combat")
	private List<PokemonMatch> pokemonMatchs = new ArrayList<PokemonMatch>();
	@Column(name = "equipe1")
	private Equipe equipe1;
	@Column(name = "equipe2")
	private Equipe equipe2;
	
	
	public Combat() {
		super();
	}
	public Combat(Long id, Long idUtilisateurGagnant) {
		super();
		this.id = id;
		this.idUtilisateurGagnant = idUtilisateurGagnant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUtilisateurGagnant() {
		return idUtilisateurGagnant;
	}
	public void setIdUtilisateurGagnant(Long idUtilisateurGagnant) {
		this.idUtilisateurGagnant = idUtilisateurGagnant;
	}
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	public List<Tour> getTours() {
		return tours;
	}
	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}
	public Equipe getEquipe1() {
		return equipe1;
	}
	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}
	public Equipe getEquipe2() {
		return equipe2;
	}
	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}
	public List<PokemonMatch> getPokemonMatchs() {
		return pokemonMatchs;
	}
	public void setPokemonMatchs(List<PokemonMatch> pokemonMatchs) {
		this.pokemonMatchs = pokemonMatchs;
	}
	
	
}
