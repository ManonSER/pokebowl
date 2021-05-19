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
		this(null, null);
	}
	
	public MonPokemon(Long id, Integer ordre) {
		super();
		this.id = id;
		this.ordre = ordre;
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
	
	

}
