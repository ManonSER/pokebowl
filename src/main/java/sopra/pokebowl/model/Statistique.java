package sopra.pokebowl.model;

public class Statistique {
	
	private Long id;
	private String pokemonPrefere;
	private Integer nbrVictoires;
	private Integer nbrDefaites;
	private Integer nbrPartiesJouees;
	
	private Utilisateur utilisateur;
	
	public Statistique() {
		this(null, null, null, null, null);
	}
	
	public Statistique(Long id, String pokemonPrefere, Integer nbrVictoires, Integer nbrDefaites,
			Integer nbrPartiesJouees) {
		super();
		this.id = id;
		this.pokemonPrefere = pokemonPrefere;
		this.nbrVictoires = nbrVictoires;
		this.nbrDefaites = nbrDefaites;
		this.nbrPartiesJouees = nbrPartiesJouees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPokemonPrefere() {
		return pokemonPrefere;
	}

	public void setPokemonPrefere(String pokemonPrefere) {
		this.pokemonPrefere = pokemonPrefere;
	}

	public Integer getNbrVictoires() {
		return nbrVictoires;
	}

	public void setNbrVictoires(Integer nbrVictoires) {
		this.nbrVictoires = nbrVictoires;
	}

	public Integer getNbrDefaites() {
		return nbrDefaites;
	}

	public void setNbrDefaites(Integer nbrDefaites) {
		this.nbrDefaites = nbrDefaites;
	}

	public Integer getNbrPartiesJouees() {
		return nbrPartiesJouees;
	}

	public void setNbrPartiesJouees(Integer nbrPartiesJouees) {
		this.nbrPartiesJouees = nbrPartiesJouees;
	}
	
	

}
