package sopra.pokebowl.model;

public class MonPokemon {
	
	private Long id;
	private Integer ordre;
	
	private Pokemon pokeReference;
	private List<Attaque> listAttaques;
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
