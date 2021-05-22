package sopra.pokebowl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitEquipe {
	
	@Test
	public void equipeFindAllAndDelete() {
		IEquipeRepository equipeRepo = Application.getInstance().getEquipeRepo();
		
		Equipe e1 = new Equipe();
		Equipe e2 = new Equipe();
		
		e1 = equipeRepo.save(e1);
		e2 = equipeRepo.save(e2);
		
		List<Equipe> list = equipeRepo.findAll();
		
		Assert.assertEquals(2, list.size());
		
		equipeRepo.delete(e1);
		equipeRepo.delete(e2);
		
		list = equipeRepo.findAll();
		
		Assert.assertEquals(0, list.size());
		
	}
	
	@Test
	public void equipeFindById() {
		IEquipeRepository equipeRepo = Application.getInstance().getEquipeRepo();
		
		Equipe e1 = new Equipe();
		e1.setNbrPokemons(4);
		e1 = equipeRepo.save(e1);
		
		Equipe e2 = equipeRepo.findById(e1.getId());
		e2 = equipeRepo.save(e2);
		
		Assert.assertEquals((Integer)4, e2.getNbrPokemons());
		
		equipeRepo.delete(e1);
		equipeRepo.delete(e2);
	}
	
	@Test
	public void equipeCreate() {
		IEquipeRepository equipeRepo = Application.getInstance().getEquipeRepo();
		IMonPokemonRepository monPokeRepo = Application.getInstance().getMonPokemonRepo();
		IUtilisateurRepository utilRepo = Application.getInstance().getUtilisateurRepo();
		
		Equipe e1 = new Equipe(1, "Equipe BG", true, null, null, null, null);
		
		MonPokemon p1 = new MonPokemon();
		MonPokemon p2 = new MonPokemon();
		MonPokemon p3 = new MonPokemon();
		MonPokemon p4 = new MonPokemon();
		p1 = monPokeRepo.save(p1);
		p2 = monPokeRepo.save(p2);
		p3 = monPokeRepo.save(p3);
		p4 = monPokeRepo.save(p4);
		
		List<MonPokemon> l1 = new ArrayList<MonPokemon>();
		l1.add(p1);
		l1.add(p2);
		l1.add(p3);
		l1.add(p4);
		
		e1.setNbrPokemons(l1.size());
		e1.setListPokemons(l1);
		
		Utilisateur uSauv = new Utilisateur();
		Utilisateur uDer = new Utilisateur();
		uSauv = utilRepo.save(uSauv);
		uDer = utilRepo.save(uDer);
		
		e1.setUtilisateurEquipeSauv(uSauv);
		e1.setUtilisateurDeniereEquipe(uDer);
		
		e1 = equipeRepo.save(e1);
	
		Assert.assertEquals((Integer)1, e1.getNumero());
		Assert.assertEquals("Equipe BG", e1.getNom());
		Assert.assertEquals(true, e1.getFavorite());
		Assert.assertEquals(uSauv.getId(), e1.getUtilisateurEquipeSauv().getId());
		Assert.assertEquals(uDer.getId(), e1.getUtilisateurDeniereEquipe().getId());
		Assert.assertEquals(p1.getId(), e1.getListPokemons().get(0).getId());
		Assert.assertEquals(p2.getId(), e1.getListPokemons().get(1).getId());
		Assert.assertEquals(p3.getId(), e1.getListPokemons().get(2).getId());
		Assert.assertEquals(p4.getId(), e1.getListPokemons().get(3).getId());
		
		monPokeRepo.delete(p1);
		monPokeRepo.delete(p2);
		monPokeRepo.delete(p3);
		monPokeRepo.delete(p4);
		utilRepo.delete(uSauv);
		utilRepo.delete(uDer);
		equipeRepo.delete(e1);
	}
	
	@Test
	public void equipeUpdate() {
		IEquipeRepository equipeRepo = Application.getInstance().getEquipeRepo();
		
		Equipe e = new Equipe();
		e.setNbrPokemons(4);
		e.setFavorite(true);
		e.setNom("coucou");
		e.setNumero(1);
		
		e = equipeRepo.save(e);
		
		e.setNbrPokemons(6);
		e.setFavorite(false);
		e.setNom("hello");
		e.setNumero(2);
		
		e = equipeRepo.save(e);
		
		Equipe eFind = equipeRepo.save(e);
		
		Assert.assertEquals((Integer)6, eFind.getNbrPokemons());
		Assert.assertEquals(false, eFind.getFavorite());
		Assert.assertEquals("hello", eFind.getNom());
		Assert.assertEquals((Integer)2, eFind.getNumero());
		
		equipeRepo.delete(e); 
		equipeRepo.delete(eFind);
	}

}
