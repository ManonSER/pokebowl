package sopra.pokebowl.model;

public class Combat {

	private Long id;
	private Long idUtilisateurGagnant;
	
	
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
}
