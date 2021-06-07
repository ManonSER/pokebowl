package sopra.pokebowl.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AttaqueAPIRequest {
	public static final String nomAttaque = "nomAttaque";
	public static final String categorieAttaque = "categorieAttaque";
	public static final String pointDePouvoirAttaque = "pointDePouvoirAttaque";
	public static final String puissanceAttaque = "puissanceAttaque";
	public static final String precisionAttaque = "precisionAttaque";
	public static final String descriptionAttaque = "descriptionAttaque";
	public static final String typeAttaque = "typeAttaque";
	public static final String pokemonAttaque = "pokemonAttaque";
	
	public static Map<String, String> createAttaqueInfo(Integer i) throws IOException {
		Map<String, String> attaqueInfo = new HashMap<String, String>();
		
		String path = "https://pokeapi.co/api/v2/move/" + i;

		// Create a neat value object to hold the URL
		URL url = new URL(path);

		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");

		// This line makes the request
		InputStream responseStream = connection.getInputStream();

		// Manually converting the response body InputStream to APOD using Jackson
		ObjectMapper mapper = new ObjectMapper();
		JsonAttaque attaque = mapper.readValue(responseStream, JsonAttaque.class);

		// TODO
		// récupérer que les attaques avec un power > 0
		if (String.valueOf(attaque.generation.get("name")).equals("\"generation-i\"")) {

			// Get id
			attaqueInfo.put("id", attaque.id);

			// Get name
			attaqueInfo.put(nomAttaque, attaque.name);

			// Get Damage Class (catégorie attaque)
			attaqueInfo.put(categorieAttaque, String.valueOf(attaque.damage_class.get("name")));

			// Get PP
			attaqueInfo.put(pointDePouvoirAttaque, attaque.pp);

			// Get Power
			attaqueInfo.put(puissanceAttaque, attaque.power);

			// Get Accuracy
			attaqueInfo.put(precisionAttaque, attaque.accuracy);

			// TODO
			// récupérer le type

			// TODO
			// Utiliser une list de nom de pokemon faites avec les pokemons utilises
			// Get Pokemons who can used Move
			StringBuilder pokemonMove = new StringBuilder();
//			for (int j = 0; j < attaque.learned_by_pokemon.size(); j++) {
//				LinkedHashMap<Object, Object> pokemon = (LinkedHashMap<Object, Object>) attaque.learned_by_pokemon.get(j);
//				Map<String, String> pokeInfo = PokemonAPIRequest.createInfoPokemon(-1, (String) pokemon.get("name"));
//				if (Integer.parseInt(pokeInfo.get("id")) <= 151) {
//					pokemonMove.append(pokemon.get("name") + ", ");
//				}
//			}

			attaqueInfo.put(pokemonAttaque, String.valueOf(pokemonMove));
		}

		return attaqueInfo;
	}
}
