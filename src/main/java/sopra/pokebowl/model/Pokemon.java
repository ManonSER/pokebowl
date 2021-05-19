package sopra.pokebowl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="hp")
	private Integer hp;
	@Column(name="attaque")
	private Integer attaque;
	@Column(name="defense")
	private Integer defense;
	@Column(name="attaque")
	private Integer attaqueSpe;
	@Column(name="defenseSpe")
	private Integer defenseSpe;
	@Column(name="speed")
	private Integer speed;
	@Column(name="taille")
	private Float taille;
	@Column(name="poids")
	private Float poids;
	@Column(name="generation")
	private Integer generation;
	@Column(name="avatar")
	private String avatar;
	@Column(name="description", length = 255)
	private String description;
	
	
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Pokemon(Long id, String nom, Integer hp, Integer attaque, Integer defense, Integer attaqueSpe,
			Integer defenseSpe, Integer speed, Float taille, Float poids, Integer generation, String avatar,
			String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.hp = hp;
		this.attaque = attaque;
		this.defense = defense;
		this.attaqueSpe = attaqueSpe;
		this.defenseSpe = defenseSpe;
		this.speed = speed;
		this.taille = taille;
		this.poids = poids;
		this.generation = generation;
		this.avatar = avatar;
		this.description = description;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Integer getHp() {
		return hp;
	}



	public void setHp(Integer hp) {
		this.hp = hp;
	}



	public Integer getAttaque() {
		return attaque;
	}



	public void setAttaque(Integer attaque) {
		this.attaque = attaque;
	}



	public Integer getDefense() {
		return defense;
	}



	public void setDefense(Integer defense) {
		this.defense = defense;
	}



	public Integer getAttaqueSpe() {
		return attaqueSpe;
	}



	public void setAttaqueSpe(Integer attaqueSpe) {
		this.attaqueSpe = attaqueSpe;
	}



	public Integer getDefenseSpe() {
		return defenseSpe;
	}



	public void setDefenseSpe(Integer defenseSpe) {
		this.defenseSpe = defenseSpe;
	}



	public Integer getSpeed() {
		return speed;
	}



	public void setSpeed(Integer speed) {
		this.speed = speed;
	}



	public Float getTaille() {
		return taille;
	}



	public void setTaille(Float taille) {
		this.taille = taille;
	}



	public Float getPoids() {
		return poids;
	}



	public void setPoids(Float poids) {
		this.poids = poids;
	}



	public Integer getGeneration() {
		return generation;
	}



	public void setGeneration(Integer generation) {
		this.generation = generation;
	}



	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}