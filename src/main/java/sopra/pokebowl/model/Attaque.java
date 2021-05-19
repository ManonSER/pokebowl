package sopra.pokebowl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Attaque")
public class Attaque {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="non")
	private String nom;
	@Column(name="categorie")
	private CategorieAttaque categorie;
	@Column(name="pointDePouvoir")
	private Integer pointDePouvoir;
	@Column(name="puissance")
	private Integer puissance;
	@Column(name="precision")
	private Float precision;
	@Column(name="description", length = 255)
	private String description;
	@ManyToMany(mappedBy = "attaques")
	private List<Pokemon> pokemons;
	@OneToOne
	@JoinColumn(name = "type")
	private TypeClass type;
	
	
	public Attaque() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Attaque(Long id, String nom, CategorieAttaque categorie, Integer pointDePouvoir, Integer puissance,
			Float precision, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorie = categorie;
		this.pointDePouvoir = pointDePouvoir;
		this.puissance = puissance;
		this.precision = precision;
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



	public CategorieAttaque getCategorie() {
		return categorie;
	}



	public void setCategorie(CategorieAttaque categorie) {
		this.categorie = categorie;
	}



	public Integer getPointDePouvoir() {
		return pointDePouvoir;
	}



	public void setPointDePouvoir(Integer pointDePouvoir) {
		this.pointDePouvoir = pointDePouvoir;
	}



	public Integer getPuissance() {
		return puissance;
	}



	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}



	public Float getPrecision() {
		return precision;
	}



	public void setPrecision(Float precision) {
		this.precision = precision;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Pokemon> getPokemons() {
		return pokemons;
	}



	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}



	public TypeClass getType() {
		return type;
	}



	public void setType(TypeClass type) {
		this.type = type;
	}
	
	

}
