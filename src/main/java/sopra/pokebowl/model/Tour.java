package sopra.pokebowl.model;

public class Tour {

	private Long id;
	private Action actionJoueur1;
	private Action actionJoueur2;
	private String attaquePokemon1;
	private String attaquePokemon2;
	
	public Tour() {
		super();
	}
	
	public Tour(Long id, Action actionJoueur1, Action actionJoueur2, String attaquePokemon1, String attaquePokemon2) {
		super();
		this.id = id;
		this.actionJoueur1 = actionJoueur1;
		this.actionJoueur2 = actionJoueur2;
		this.attaquePokemon1 = attaquePokemon1;
		this.attaquePokemon2 = attaquePokemon2;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Action getActionJoueur1() {
		return actionJoueur1;
	}
	public void setActionJoueur1(Action actionJoueur1) {
		this.actionJoueur1 = actionJoueur1;
	}
	public Action getActionJoueur2() {
		return actionJoueur2;
	}
	public void setActionJoueur2(Action actionJoueur2) {
		this.actionJoueur2 = actionJoueur2;
	}
	public String getAttaquePokemon1() {
		return attaquePokemon1;
	}
	public void setAttaquePokemon1(String attaquePokemon1) {
		this.attaquePokemon1 = attaquePokemon1;
	}
	public String getAttaquePokemon2() {
		return attaquePokemon2;
	}
	public void setAttaquePokemon2(String attaquePokemon2) {
		this.attaquePokemon2 = attaquePokemon2;
	}	
}
