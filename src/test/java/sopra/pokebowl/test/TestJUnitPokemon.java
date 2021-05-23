package sopra.pokebowl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ITypeClassRepository;

public class TestJUnitPokemon {
	@Test
	public void pokemonFindAllAndDelete() {
		IPokemonRepository pokemonRepo = Application.getInstance().getPokemonRepo();
		
		Pokemon p1 = new Pokemon();
		Pokemon p2 = new Pokemon();
		
		p1 = pokemonRepo.save(p1);
		p2 = pokemonRepo.save(p2);
		
		List<Pokemon> list = pokemonRepo.findAll();
		
		Assert.assertEquals(2, list.size());
		
		pokemonRepo.delete(p1);
		pokemonRepo.delete(p2);
		
		list = pokemonRepo.findAll();
		
		Assert.assertEquals(0, list.size());
		
	}
	
	@Test
	public void pokemonCreate() {
		IPokemonRepository pokemonRepo = Application.getInstance().getPokemonRepo();
		ITypeClassRepository typeClassRepo = Application.getInstance().getTypeClassRepo();
		IAttaqueRepository attaqueRepo = Application.getInstance().getAttaqueRepo();
		
		String nom = "Bulbizarre";
		Integer hp = 200;
		Integer attaque = 92;
		Integer defense = 92;
		Integer attaqueSpe = 121;
		Integer defenseSpe = 121;
		Integer speed = 85;
		Float taille = 0.7f;
		Float poids = 6.9f;
		Integer generation = 1;
		String avatar = null;
		String description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this POKéMON.";
		
		Pokemon p1 = new Pokemon(nom, hp, attaque, defense, attaqueSpe, defenseSpe, speed, taille, poids, generation, avatar, description);
		
		List<Attaque> attaques = new ArrayList<Attaque>();
		
		Attaque a1 = new Attaque();
		a1 = attaqueRepo.save(a1);
		Attaque a2 = new Attaque();
		a2 = attaqueRepo.save(a2);
		Attaque a3 = new Attaque();
		a3 = attaqueRepo.save(a3);
		Attaque a4 = new Attaque();
		a4 = attaqueRepo.save(a4);
		
		attaques.add(a1);
		attaques.add(a2);
		attaques.add(a3);
		attaques.add(a4);
		
		p1.setAttaques(attaques);
		
		TypeClass type1 = new TypeClass(TypeEnum.PLANTE, null);
		TypeClass type2 = new TypeClass(TypeEnum.POISON, null);
		
		type1 = typeClassRepo.save(type1);
		type2 = typeClassRepo.save(type2);
		
		p1.setType1(type1);
		p1.setType2(type2);
		
		p1 = pokemonRepo.save(p1);

	
		//Assert.assertEquals((Integer)5, p1.getId());
		Assert.assertEquals("Bulbizarre", p1.getNom());
		Assert.assertEquals((Integer)200, p1.getHp());
		Assert.assertEquals((Integer)92, p1.getAttaque());
		Assert.assertEquals((Integer)92, p1.getDefense());
		Assert.assertEquals((Integer)121, p1.getAttaqueSpe());
		Assert.assertEquals((Integer)121, p1.getDefenseSpe());
		Assert.assertEquals((Integer)85, p1.getSpeed());
		Assert.assertEquals((Float)0.7f, p1.getTaille());
		Assert.assertEquals((Float)6.9f, p1.getPoids());
		Assert.assertEquals((Integer)1, p1.getGeneration());
		Assert.assertEquals(null, p1.getAvatar());
		Assert.assertEquals("A strange seed was planted on its back at birth. The plant sprouts and grows with this POKéMON.", p1.getDescription());
		Assert.assertEquals(4, p1.getAttaques().size());
		Assert.assertEquals(TypeEnum.PLANTE, p1.getType1().getType());
		Assert.assertEquals(TypeEnum.POISON, p1.getType2().getType());
		
		pokemonRepo.delete(p1);
		attaqueRepo.delete(a4);
		attaqueRepo.delete(a3);
		attaqueRepo.delete(a2);
		attaqueRepo.delete(a1);
		typeClassRepo.delete(type1);
		typeClassRepo.delete(type2);
	}
	
	@Test
	public void pokemonUpdate() {
		IPokemonRepository pokemonRepo = Application.getInstance().getPokemonRepo();
		
		String nom = "Bulbizarre";
		Integer hp = 200;
		Integer attaque = 92;
		Integer defense = 92;
		Integer attaqueSpe = 121;
		Integer defenseSpe = 121;
		Integer speed = 85;
		Float taille = 0.7f;
		Float poids = 6.9f;
		Integer generation = 1;
		String avatar = null;
		String description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this POKéMON.";
		Pokemon p = new Pokemon(nom, hp, attaque, defense, attaqueSpe, defenseSpe, speed, taille, poids, generation, avatar, description);
		
		p = pokemonRepo.save(p);
		
		p.setAttaque(95);
		p = pokemonRepo.save(p);
		
		Pokemon pFind = pokemonRepo.findById(p.getId());
		
		Assert.assertEquals((Integer)95, pFind.getAttaque());
	
		pokemonRepo.delete(p); 
	}
	
	@Test
	public void pokemonFindAllPokemonByType() {
		IPokemonRepository pokemonRepo = Application.getInstance().getPokemonRepo();
		ITypeClassRepository typeClassRepo = Application.getInstance().getTypeClassRepo();
		IAttaqueRepository attaqueRepo = Application.getInstance().getAttaqueRepo();
		
		String nom = "Bulbizarre";
		Integer hp = 200;
		Integer attaque = 92;
		Integer defense = 92;
		Integer attaqueSpe = 121;
		Integer defenseSpe = 121;
		Integer speed = 85;
		Float taille = 0.7f;
		Float poids = 6.9f;
		Integer generation = 1;
		String avatar = null;
		String description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this POKéMON.";
		Pokemon p = new Pokemon(nom, hp, attaque, defense, attaqueSpe, defenseSpe, speed, taille, poids, generation, avatar, description);
		
		TypeClass type1 = new TypeClass(TypeEnum.PLANTE, null);
		TypeClass type2 = new TypeClass(TypeEnum.POISON, null);
		
		type1 = typeClassRepo.save(type1);
		type2 = typeClassRepo.save(type2);
		
		p.setType1(type1);
		p.setType2(type2);
		
		List<Attaque> attaques = new ArrayList<Attaque>();
		
		Attaque a1 = new Attaque();
		a1 = attaqueRepo.save(a1);
		Attaque a2 = new Attaque();
		a2 = attaqueRepo.save(a2);
		Attaque a3 = new Attaque();
		a3 = attaqueRepo.save(a3);
		Attaque a4 = new Attaque();
		a4 = attaqueRepo.save(a4);
		
		attaques.add(a1);
		attaques.add(a2);
		attaques.add(a3);
		attaques.add(a4);
		
		p.setAttaques(attaques);
		
		p = pokemonRepo.save(p);
		
		String nom2 = "Boustiflor";
		Integer hp2 = 240;
		Integer attaque2 = 166;
		Integer defense2 = 94;
		Integer attaqueSpe2 = 157;
		Integer defenseSpe2 = 85;
		Integer speed2 = 103;
		Float taille2 = 1.0f;
		Float poids2 = 6.4f;
		Integer generation2 = 1;
		String avatar2 = null;
		String description2 = "It spits out POISONPOWDER to immobilize the enemy and then finishes it with a spray of ACID.";
		Pokemon p2 = new Pokemon(nom2, hp2, attaque2, defense2, attaqueSpe2, defenseSpe2, speed2, taille2, poids2, generation2, avatar2, description2);
		
		p2.setType1(type1);
		p2.setType2(type2);
		
		p2.setAttaques(attaques);
		
		p2 = pokemonRepo.save(p2);
		
		List<Pokemon> pokemons = pokemonRepo.findAllPokemonByType(TypeEnum.PLANTE, TypeEnum.POISON);
		
		Assert.assertEquals(2, pokemons.size());
		
		pokemonRepo.delete(p); 
		pokemonRepo.delete(p2);
		attaqueRepo.delete(a4);
		attaqueRepo.delete(a3);
		attaqueRepo.delete(a2);
		attaqueRepo.delete(a1);
		typeClassRepo.delete(type1);
		typeClassRepo.delete(type2);
	}
	
	@Test
	public void pokemonFindAllPokemonByString() {
		IPokemonRepository pokemonRepo = Application.getInstance().getPokemonRepo();
		ITypeClassRepository typeClassRepo = Application.getInstance().getTypeClassRepo();
		IAttaqueRepository attaqueRepo = Application.getInstance().getAttaqueRepo();
		
		String nom = "Bulbizarre";
		Integer hp = 200;
		Integer attaque = 92;
		Integer defense = 92;
		Integer attaqueSpe = 121;
		Integer defenseSpe = 121;
		Integer speed = 85;
		Float taille = 0.7f;
		Float poids = 6.9f;
		Integer generation = 1;
		String avatar = null;
		String description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this POKéMON.";
		Pokemon p = new Pokemon(nom, hp, attaque, defense, attaqueSpe, defenseSpe, speed, taille, poids, generation, avatar, description);
		
		TypeClass type1 = new TypeClass(TypeEnum.PLANTE, null);
		TypeClass type2 = new TypeClass(TypeEnum.POISON, null);
		
		type1 = typeClassRepo.save(type1);
		type2 = typeClassRepo.save(type2);
		
		p.setType1(type1);
		p.setType2(type2);
		
		List<Attaque> attaques = new ArrayList<Attaque>();
		
		Attaque a1 = new Attaque();
		a1 = attaqueRepo.save(a1);
		Attaque a2 = new Attaque();
		a2 = attaqueRepo.save(a2);
		Attaque a3 = new Attaque();
		a3 = attaqueRepo.save(a3);
		Attaque a4 = new Attaque();
		a4 = attaqueRepo.save(a4);
		
		attaques.add(a1);
		attaques.add(a2);
		attaques.add(a3);
		attaques.add(a4);
		
		p.setAttaques(attaques);
		
		p = pokemonRepo.save(p);
		
		String nom2 = "Boustiflor";
		Integer hp2 = 240;
		Integer attaque2 = 166;
		Integer defense2 = 94;
		Integer attaqueSpe2 = 157;
		Integer defenseSpe2 = 85;
		Integer speed2 = 103;
		Float taille2 = 1.0f;
		Float poids2 = 6.4f;
		Integer generation2 = 1;
		String avatar2 = null;
		String description2 = "It spits out POISONPOWDER to immobilize the enemy and then finishes it with a spray of ACID.";
		Pokemon p2 = new Pokemon(nom2, hp2, attaque2, defense2, attaqueSpe2, defenseSpe2, speed2, taille2, poids2, generation2, avatar2, description2);
		
		p2.setType1(type1);
		p2.setType2(type2);
		
		p2.setAttaques(attaques);
		
		p2 = pokemonRepo.save(p2);
		
		List<Pokemon> pokemons = pokemonRepo.findAllPokemonByString("B");
		
		Assert.assertEquals(2, pokemons.size());
		
		pokemonRepo.delete(p); 
		pokemonRepo.delete(p2);
		attaqueRepo.delete(a4);
		attaqueRepo.delete(a3);
		attaqueRepo.delete(a2);
		attaqueRepo.delete(a1);
		typeClassRepo.delete(type1);
		typeClassRepo.delete(type2);
	}

}
