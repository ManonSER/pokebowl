package sopra.pokebowl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "pseudo")
	private String pseudo;
	@Column(name = "email")
	private String email;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "mot_de_passe")
	private String motDePasse;
	@Embedded
	private Statistique statistique;
	@ManyToOne
	@Column(name = "derniere_equipe_id")
	private Equipe derniereEquipe;
	@OneToMany(mappedBy = "joueur1")
	private List<Salon> salons = new ArrayList<Salon>();
	@OneToMany(mappedBy = "joueur2")
	private List<Equipe> equipesSauvegardees = new ArrayList<Equipe>();
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(Long id, String pseudo, String email, String avatar, String motDePasse) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.email = email;
		this.avatar = avatar;
		this.motDePasse = motDePasse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Statistique getStatistique() {
		return statistique;
	}

	public void setStatistique(Statistique statistique) {
		this.statistique = statistique;
	}

	public Equipe getDerniereEquipe() {
		return derniereEquipe;
	}

	public void setDerniereEquipe(Equipe derniereEquipe) {
		this.derniereEquipe = derniereEquipe;
	}

	public List<Salon> getSalons() {
		return salons;
	}

	public void setSalons(List<Salon> salons) {
		this.salons = salons;
	}

	public List<Equipe> getEquipesSauvegardees() {
		return equipesSauvegardees;
	}

	public void setEquipesSauvegardees(List<Equipe> equipesSauvegardees) {
		this.equipesSauvegardees = equipesSauvegardees;
	}
}
