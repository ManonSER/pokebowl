package sopra.pokebowl.model;

public class Utilisateur {
	private Long id;
	private String pseudo;
	private String email;
	private String avatar;
	private String motDePasse;
	
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
}
