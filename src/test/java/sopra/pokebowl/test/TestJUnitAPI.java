package sopra.pokebowl.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.api.AttaqueAPIRequest;
import sopra.pokebowl.api.PokemonAPIRequest;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.CategorieAttaque;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IPokemonRepository;

public class TestJUnitAPI {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	public final Integer numberPokeToUse = 151;
	public final Integer numberAttaqueToUse = 200;
	public List<String> listPoke = new ArrayList<String>();
	
	@Test
	public void createPokeDataBase() {
		IPokemonRepository pokemonRepo = context.getBean(IPokemonRepository.class);
		
		try {
			for(int i = 1; i <= numberPokeToUse; i++) {
				Map<String, String> pokemonInfo = PokemonAPIRequest.createInfoPokemon(i, null, listPoke);
				Pokemon pokemon = new Pokemon();
				pokemon.setNom(pokemonInfo.get(PokemonAPIRequest.nomPoke));
				pokemon.setHp(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.hpPoke)));
				pokemon.setAttaque(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.attaquePoke)));
				pokemon.setDefense(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.defensePoke)));
				pokemon.setAttaqueSpe(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.attaqueSpePoke)));
				pokemon.setDefenseSpe(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.defenseSpePoke)));
				pokemon.setSpeed(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.speedPoke)));
				pokemon.setPoids(Float.parseFloat(pokemonInfo.get(PokemonAPIRequest.poidsPoke)));
				pokemon.setTaille(Float.parseFloat(pokemonInfo.get(PokemonAPIRequest.taillePoke)));
				pokemon.setGeneration(1);
				pokemon.setAvatar(pokemonInfo.get(PokemonAPIRequest.avatarPoke));
				pokemon.setDescription(pokemonInfo.get(PokemonAPIRequest.descriptionPoke));
				
				pokemonRepo.save(pokemon);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createAttaqueDataBase() {
		IAttaqueRepository attaqueRepo = context.getBean(IAttaqueRepository.class);
		
		try {
			for(int i = 1; i <= numberAttaqueToUse; i++) {
				Map<String, String> attaqueInfo = AttaqueAPIRequest.createAttaqueInfo(i, listPoke);
				if(!attaqueInfo.isEmpty()) {
					Attaque attaque = new Attaque();
					
					attaque.setNom(attaqueInfo.get(AttaqueAPIRequest.nomAttaque));
					
					if(attaqueInfo.get(AttaqueAPIRequest.categorieAttaque).equals("\"physical\"")) {
						attaque.setCategorie(CategorieAttaque.PHYSIQUE);
					} else if(attaqueInfo.get(AttaqueAPIRequest.categorieAttaque).equals("\"special\"")) {
						attaque.setCategorie(CategorieAttaque.SPECIAL);
					}
					else if(attaqueInfo.get(AttaqueAPIRequest.categorieAttaque).equals("\"status\"")) {
						attaque.setCategorie(CategorieAttaque.STATUT_ATTAQUE);
					}
					attaque.setPointDePouvoir(Integer.parseInt(attaqueInfo.get(AttaqueAPIRequest.pointDePouvoirAttaque)));
					
					if(attaqueInfo.get(AttaqueAPIRequest.puissanceAttaque) != null) {
						attaque.setPuissance(Integer.parseInt(attaqueInfo.get(AttaqueAPIRequest.puissanceAttaque)));
					}
					
					if(attaqueInfo.get(AttaqueAPIRequest.precisionAttaque) != null) {
						attaque.setPrecisionAttaque(Float.parseFloat(attaqueInfo.get(AttaqueAPIRequest.precisionAttaque)));
					}
					
					if(attaqueInfo.get(AttaqueAPIRequest.descriptionAttaque) != null) {
						attaque.setDescription(attaqueInfo.get(AttaqueAPIRequest.descriptionAttaque));
					}
					
//					if(attaqueInfo.get(AttaqueAPIRequest.typeAttaque) != null) {
//						attaque.setTypeAttaque();
//					}
					
					attaqueRepo.save(attaque);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
