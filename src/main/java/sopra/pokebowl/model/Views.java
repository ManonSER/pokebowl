package sopra.pokebowl.model;

public class Views {
	public static class ViewCommon{}
	
	public static class ViewEquipe extends ViewCommon {}
	public static class ViewEquipeDetail extends ViewEquipe {}
	
	public static class ViewMonPokemon extends ViewCommon {}
	public static class ViewMonPokemonDetail extends ViewMonPokemon {}
	
	public static class ViewPokemonMatch extends ViewCommon {}
	public static class ViewPokemonMatchDetail extends ViewPokemonMatch {}
	
	public static class ViewAttaque extends ViewCommon {}
	public static class ViewAttaqueDetail extends ViewAttaque {}
}
