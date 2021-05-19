package sopra.pokebowl.model;

public class Salon {
	private Long id;
	private String nom;
	private String motDePasse;
	
	public Salon() {
		super();
	}
	
	public Salon(Long id, String nom, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.motDePasse = motDePasse;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
