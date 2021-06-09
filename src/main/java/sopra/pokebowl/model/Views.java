package sopra.pokebowl.model;

public class Views {
	public static class ViewCommon{}
	
	public static class ViewUtilisateur extends ViewCommon{}
	public static class ViewUtilisateurDetail extends ViewCommon{}
	
	public static class ViewSalon extends ViewCommon{}
	public static class ViewSalonDetail extends ViewSalon{}
	
	public static class ViewCombat extends ViewCommon{}
	public static class ViewCombatDetail extends ViewCombat{}
	
	public static class ViewTour extends ViewCommon{}
	public static class ViewTourDetail extends ViewTour{}
	
	public static class ViewPokemon extends ViewCommon{}
	public static class ViewPokemonDetail extends ViewPokemon{}
	
	public static class ViewTypeClass extends ViewCommon{}
	public static class ViewTypeClassDetail extends ViewPokemon{}
}
