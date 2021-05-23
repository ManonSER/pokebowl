package sopra.pokebowl.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.Statistique;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitUtilisateur {

	@Test
	public void utilisateurCreate() {
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		IEquipeRepository equipeRepo = Application.getInstance().getEquipeRepo();
		 
		Statistique stats = new Statistique();
		stats.setPokemonPrefere("Carapuce");
		stats.setNbrVictoires(54);
		stats.setNbrDefaites(34);
		stats.setNbrPartiesJouees(stats.getNbrDefaites() + stats.getNbrVictoires());
		
		Equipe derniereEquipe = new Equipe();
		derniereEquipe.setNom("dernière équipe");    
		derniereEquipe.setFavorite(false);
		derniereEquipe.setNbrPokemons(5); 
	
		derniereEquipe = equipeRepo.save(derniereEquipe);
		 
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo("pokemonator");
		utilisateur.setEmail("jean.jojo@gmail.com"); 
		utilisateur.setAvatar("chemin/avatar");
		utilisateur.setMotDePasse("lesoleilbrille33");
		utilisateur.setStatistique(stats); 
		utilisateur.setDerniereEquipe(derniereEquipe);
		
		utilisateur = utilisateurRepo.save(utilisateur); 
		
		Utilisateur utilisateurFind = utilisateurRepo.findById(utilisateur.getId());
		 
		Assert.assertEquals("pokemonator", utilisateurFind.getPseudo());
		Assert.assertEquals("jean.jojo@gmail.com", utilisateurFind.getEmail());
		Assert.assertEquals("chemin/avatar", utilisateurFind.getAvatar());
		Assert.assertEquals("lesoleilbrille33", utilisateurFind.getMotDePasse());
		Assert.assertEquals("Carapuce", utilisateurFind.getStatistique().getPokemonPrefere());
		Assert.assertEquals((Integer)54, utilisateurFind.getStatistique().getNbrVictoires());
		Assert.assertEquals((Integer)34, utilisateurFind.getStatistique().getNbrDefaites());
		Assert.assertEquals(stats.getNbrPartiesJouees(), utilisateurFind.getStatistique().getNbrPartiesJouees());
		Assert.assertEquals(derniereEquipe.getId(), utilisateurFind.getDerniereEquipe().getId());
		
		utilisateurRepo.delete(utilisateur);
		equipeRepo.delete(derniereEquipe);
	}
	
	@Test
	public void utilisateurUpdate() {
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo("pokemonator");
		utilisateur.setEmail("jean.jojo@gmail.com");
		utilisateur.setAvatar("chemin/avatar");
		utilisateur.setMotDePasse("lesoleilbrille33");
		
		utilisateur = utilisateurRepo.save(utilisateur);
		
		utilisateur.setPseudo("jeanyves");
		utilisateur.setEmail("alexis.dupond@hotmail.fr");
		utilisateur.setAvatar("disqueC/image/avatar4");
		utilisateur.setMotDePasse("unplusdeux++");
		
		utilisateur = utilisateurRepo.save(utilisateur);
		
		Utilisateur utilisateurFind = utilisateurRepo.findById(utilisateur.getId());
		
		Assert.assertEquals("jeanyves", utilisateurFind.getPseudo());
		Assert.assertEquals("alexis.dupond@hotmail.fr", utilisateurFind.getEmail()); 
		Assert.assertEquals("disqueC/image/avatar4", utilisateurFind.getAvatar());
		Assert.assertEquals("unplusdeux++", utilisateurFind.getMotDePasse());
		
		utilisateurRepo.delete(utilisateur);
	}
	
	@Test
	public void utilisateurFindAllAndDelete() {
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		Utilisateur utilisateur1 = new Utilisateur();
		Utilisateur utilisateur2 = new Utilisateur();
		Utilisateur utilisateur3 = new Utilisateur();
		Utilisateur utilisateur4 = new Utilisateur();
		
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		utilisateur2 = utilisateurRepo.save(utilisateur2);
		utilisateur3 = utilisateurRepo.save(utilisateur3);
		utilisateur4 = utilisateurRepo.save(utilisateur4);
		
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
		
		Assert.assertEquals(4, utilisateurs.size());
		
		utilisateurRepo.delete(utilisateur1);
		utilisateurRepo.delete(utilisateur2);  
		utilisateurRepo.delete(utilisateur3); 
		utilisateurRepo.delete(utilisateur4);
		
		utilisateurs = utilisateurRepo.findAll();
		
		Assert.assertEquals(0, utilisateurs.size());
	}
	
	@Test
	public void testFindPseudoMailAvatarStatsById() {
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMan");
		u.setEmail("pokeman@gmail.com");
		u.setAvatar("http://avatar");
		
		Statistique stats = new Statistique();
		stats.setPokemonPrefere("Dracaufeu");
		stats.setNbrPartiesJouees(10);
		stats.setNbrVictoires(8);
		stats.setNbrDefaites(2);
		
		u.setStatistique(stats);
		
		u = utilisateurRepo.save(u);
		
		Object[] result = utilisateurRepo.findPseudoMailAvatarStatsById(u.getId());
		
		for(Object o : result) {
			System.out.println(o.toString());
		}
		
		Assert.assertEquals((String)result[0], u.getPseudo());
		Assert.assertEquals((String)result[1], u.getEmail());
		Assert.assertEquals((String)result[2], u.getAvatar());
		Assert.assertEquals(((Statistique)result[3]).getPokemonPrefere(), u.getStatistique().getPokemonPrefere());
		Assert.assertEquals(((Statistique)result[3]).getNbrPartiesJouees(), u.getStatistique().getNbrPartiesJouees());
		Assert.assertEquals(((Statistique)result[3]).getNbrVictoires(), u.getStatistique().getNbrVictoires());
		Assert.assertEquals(((Statistique)result[3]).getNbrDefaites(), u.getStatistique().getNbrDefaites());
		
		utilisateurRepo.delete(u);
		
	}
	
	@Test
	public void testFindAvatarsPokeAllEquipesById() {
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		IPokemonRepository pokeRepo = Application.getInstance().getPokemonRepo();
		IMonPokemonRepository monPokeRepo = Application.getInstance().getMonPokemonRepo();
		IEquipeRepository equipeRepo = Application.getInstance().getEquipeRepo();
		
		// CREATION DES POKEMONS DE REFERENCE
		Pokemon pp1 = new Pokemon();
		pp1.setNom("Pikachu");
		pp1.setAvatar("hhtp://Pikachu");
		Pokemon pp2 = new Pokemon();
		pp2.setNom("Raichu");
		pp2.setAvatar("hhtp://Raichu");
		Pokemon pp3 = new Pokemon();
		pp3.setNom("Minidraco");
		pp3.setAvatar("hhtp://Minidraco");
		
		Pokemon pp4 = new Pokemon();
		pp4.setNom("Mew");
		pp4.setAvatar("hhtp://Mew");
		Pokemon pp5 = new Pokemon();
		pp5.setNom("Mewtwo");
		pp5.setAvatar("hhtp://Mewtwo");
		Pokemon pp6 = new Pokemon();
		pp6.setNom("Roucoul");
		pp6.setAvatar("hhtp://Roucoul");
		Pokemon pp7 = new Pokemon();
		pp7.setNom("Chenipan");
		pp7.setAvatar("hhtp://Chenipan");
		
		Pokemon pp8 = new Pokemon();
		pp8.setNom("Rondoudou");
		pp8.setAvatar("hhtp://Rondoudou");
		Pokemon pp9 = new Pokemon();
		pp9.setNom("Abra");
		pp9.setAvatar("hhtp://Abra");
		Pokemon pp10 = new Pokemon();
		pp10.setNom("Carapuce");
		pp10.setAvatar("hhtp://Carapuce");
		Pokemon pp11 = new Pokemon();
		pp11.setNom("M. Mime");
		pp11.setAvatar("hhtp://M. Mime");
		Pokemon pp12 = new Pokemon();
		pp12.setNom("Stari");
		pp12.setAvatar("hhtp://Stari");
		
		// SAUVEGARDE DES POKEMONS DE REFERENCE
		pp1 = pokeRepo.save(pp1);
		pp2 = pokeRepo.save(pp2);
		pp3 = pokeRepo.save(pp3);
		pp4 = pokeRepo.save(pp4);
		pp5 = pokeRepo.save(pp5);
		pp6 = pokeRepo.save(pp6);
		pp7 = pokeRepo.save(pp7);
		pp8 = pokeRepo.save(pp8);
		pp9 = pokeRepo.save(pp9);
		pp10 = pokeRepo.save(pp10);
		pp11 = pokeRepo.save(pp11);
		pp12 = pokeRepo.save(pp12);
		
		// CREATION DE L'UTILISATEUR
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMonMan");		
		
		// CREATION DES 3 EQUIPES
		Equipe e1 = new Equipe();
		e1.setNbrPokemons(3);
		e1.setNom("Equipe 1");
		
		Equipe e2 = new Equipe();
		e2.setNbrPokemons(4);
		e2.setNom("Equipe 2");
		
		Equipe e3 = new Equipe();
		e3.setNbrPokemons(5);
		e3.setNom("Equipe 3");
		
		// AJOUT DES EQUIPES DANS L'UTILISATEUR (Même s'il est esclave ? Sinon la taille de la liste des equipes sauv de l'utilisateur est nulle)
		u.getEquipesSauvegardees().add(e1);
		u.getEquipesSauvegardees().add(e2);
		u.getEquipesSauvegardees().add(e3);
		// SAUVEGARDE DE L'UTILISATEUR
		u = utilisateurRepo.save(u);
		
		// SET DE L'UTILISATEUR DES EQUIPES PUIS SAUVEGARDE DES EQUIPES
		e1.setUtilisateurEquipeSauv(u);
		e2.setUtilisateurEquipeSauv(u);
		e3.setUtilisateurEquipeSauv(u);
		
		e1 = equipeRepo.save(e1);
		e2 = equipeRepo.save(e2);
		e3 = equipeRepo.save(e3);
		
		// CREATION DES POKEMON "MONPOKEMON" DES EQUIPES, ON SET LE POKEMON DE REFERENCE ET L'EQUIPE DANS LAQUELLE IL EST + SAUVEGARDE DES MONPOKEMON
		MonPokemon p1 = new MonPokemon();
		p1.setPokeReference(pp1);
		p1.setEquipe(e1);
		MonPokemon p2 = new MonPokemon();
		p2.setPokeReference(pp2);
		p2.setEquipe(e1);
		MonPokemon p3 = new MonPokemon();
		p3.setPokeReference(pp3);
		p3.setEquipe(e1);
		
		MonPokemon p4 = new MonPokemon();
		p4.setPokeReference(pp4);
		p4.setEquipe(e2);
		MonPokemon p5 = new MonPokemon();
		p5.setPokeReference(pp5);
		p5.setEquipe(e2);
		MonPokemon p6 = new MonPokemon();
		p6.setPokeReference(pp6);
		p6.setEquipe(e2);
		MonPokemon p7 = new MonPokemon();
		p7.setPokeReference(pp7);
		p7.setEquipe(e2);
		
		MonPokemon p8 = new MonPokemon();
		p8.setPokeReference(pp8);
		p8.setEquipe(e3);
		MonPokemon p9 = new MonPokemon();
		p9.setPokeReference(pp9);
		p9.setEquipe(e3);
		MonPokemon p10 = new MonPokemon();
		p10.setPokeReference(pp10);
		p10.setEquipe(e3);
		MonPokemon p11 = new MonPokemon();
		p11.setPokeReference(pp11);
		p11.setEquipe(e3);
		MonPokemon p12 = new MonPokemon();
		p12.setPokeReference(pp12);
		p12.setEquipe(e3);
		
		p1 = monPokeRepo.save(p1);
		p2 = monPokeRepo.save(p2);
		p3 = monPokeRepo.save(p3);
		p4 = monPokeRepo.save(p4);
		p5 = monPokeRepo.save(p5);
		p6 = monPokeRepo.save(p6);
		p7 = monPokeRepo.save(p7);
		p8 = monPokeRepo.save(p8);
		p9 = monPokeRepo.save(p9);
		p10 = monPokeRepo.save(p10);
		p11 = monPokeRepo.save(p11);
		p12 = monPokeRepo.save(p12);
		
		List<List<String>> result = utilisateurRepo.findAvatarsPokeAllEquipesById(u.getId());
		
		// POKEMONS EQUIPE 1
		Assert.assertEquals(result.get(0).get(0), p1.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(0).get(1), p2.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(0).get(2), p3.getPokeReference().getAvatar());
		
		// POKEMONS EQUIPE 2
		Assert.assertEquals(result.get(1).get(0), p4.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(1).get(1), p5.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(1).get(2), p6.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(1).get(3), p7.getPokeReference().getAvatar());
		
		//POKEMONS EQUIPE 3
		Assert.assertEquals(result.get(2).get(0), p8.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(2).get(1), p9.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(2).get(2), p10.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(2).get(3), p11.getPokeReference().getAvatar());
		Assert.assertEquals(result.get(2).get(4), p12.getPokeReference().getAvatar());
		
		monPokeRepo.delete(p12);
		monPokeRepo.delete(p11);
		monPokeRepo.delete(p10);
		monPokeRepo.delete(p9);
		monPokeRepo.delete(p8);
		monPokeRepo.delete(p7);
		monPokeRepo.delete(p6);
		monPokeRepo.delete(p5);
		monPokeRepo.delete(p4);
		monPokeRepo.delete(p3);
		monPokeRepo.delete(p2);
		monPokeRepo.delete(p1);
		equipeRepo.delete(e3);
		equipeRepo.delete(e2);
		equipeRepo.delete(e1);
		utilisateurRepo.delete(u);
		pokeRepo.delete(pp12);
		pokeRepo.delete(pp11);
		pokeRepo.delete(pp10);
		pokeRepo.delete(pp9);
		pokeRepo.delete(pp8);
		pokeRepo.delete(pp7);
		pokeRepo.delete(pp6);
		pokeRepo.delete(pp5);
		pokeRepo.delete(pp4);
		pokeRepo.delete(pp3);
		pokeRepo.delete(pp2);
		pokeRepo.delete(pp1);
		
		
		
	}
}
