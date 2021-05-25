package sopra.pokebowl.test;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonRepository;

public class TestJUnitMonPokemon {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	public void monPokeFindAllAndDelete() {
		IMonPokemonRepository monPokeRepo = context.getBean(IMonPokemonRepository.class);
		
		MonPokemon p1 = new MonPokemon();
		MonPokemon p2 = new MonPokemon();
		
		p1 = monPokeRepo.save(p1);
		p2 = monPokeRepo.save(p2);
		
		List<MonPokemon> list = monPokeRepo.findAll();
		
		Assert.assertEquals(2, list.size());
		
		monPokeRepo.delete(p1);
		monPokeRepo.delete(p2);
		
		list = monPokeRepo.findAll();
		
		Assert.assertEquals(0, list.size());
		
	}
	
	@Test
	public void monPokeFindById() {
		IMonPokemonRepository monPokeRepo = context.getBean(IMonPokemonRepository.class);
		
		MonPokemon p1 = new MonPokemon();
		p1.setOrdre(2);
		p1 = monPokeRepo.save(p1);
		
		Optional<MonPokemon> p2 = monPokeRepo.findById(p1.getId());
		
		Assert.assertEquals((Integer)2, p2.get().getOrdre());
		
		monPokeRepo.delete(p1);
	}
	
	@Test
	public void monPokeCreate() {
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		IMonPokemonRepository monPokeRepo = context.getBean(IMonPokemonRepository.class);
		IAttaqueRepository attaqueRepo = context.getBean(IAttaqueRepository.class);
		IPokemonRepository pokeRepo = context.getBean(IPokemonRepository.class);
		
		MonPokemon p1 = new MonPokemon();
		p1.setOrdre(1);
		
		Equipe e = new Equipe();
		e = equipeRepo.save(e);
		p1.setEquipe(e);
		
		Attaque a1 = new Attaque();
		a1 = attaqueRepo.save(a1);
		Attaque a2 = new Attaque();
		a2 = attaqueRepo.save(a2);
		Attaque a3 = new Attaque();
		a3 = attaqueRepo.save(a3);
		Attaque a4 = new Attaque();
		a4 = attaqueRepo.save(a4);
		
		p1.setAttaque1(a1);
		p1.setAttaque2(a2);
		p1.setAttaque3(a3);
		p1.setAttaque4(a4);
		
		Pokemon p = new Pokemon();
		p = pokeRepo.save(p);
		p1.setPokeReference(p);
		
		p1 = monPokeRepo.save(p1);
	
		Assert.assertEquals((Integer)1, p1.getOrdre());
		Assert.assertEquals(e.getId(), p1.getEquipe().getId());
		Assert.assertEquals(a1.getId(), p1.getAttaque1().getId());
		Assert.assertEquals(a2.getId(), p1.getAttaque2().getId());
		Assert.assertEquals(a3.getId(), p1.getAttaque3().getId());
		Assert.assertEquals(a4.getId(), p1.getAttaque4().getId());
		Assert.assertEquals(p.getId(), p1.getPokeReference().getId());
		
		monPokeRepo.delete(p1);
		pokeRepo.delete(p);
		attaqueRepo.delete(a4);
		attaqueRepo.delete(a3);
		attaqueRepo.delete(a2);
		attaqueRepo.delete(a1);
		equipeRepo.delete(e);
	}
	
	@Test
	public void monPokeUpdate() {
		IMonPokemonRepository monPokeRepo = context.getBean(IMonPokemonRepository.class);
		
		MonPokemon p = new MonPokemon();
		p.setOrdre(2);
		p = monPokeRepo.save(p);
		
		p.setOrdre(5);
		p = monPokeRepo.save(p);
		
		Optional<MonPokemon> pFind = monPokeRepo.findById(p.getId());
		
		Assert.assertEquals((Integer)5, pFind.get().getOrdre());
	
		monPokeRepo.delete(p); 
	}
	
}
