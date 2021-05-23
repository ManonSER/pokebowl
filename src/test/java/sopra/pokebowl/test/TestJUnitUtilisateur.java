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
	public void utilisateurFindPseudoMailAvatarStatsById() {
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		Statistique stats = new Statistique();
		stats.setPokemonPrefere("Carapuce");
		stats.setNbrVictoires(54);
		stats.setNbrDefaites(34);
		stats.setNbrPartiesJouees(stats.getNbrDefaites() + stats.getNbrVictoires());
		
		Utilisateur u1 = new Utilisateur();
		u1.setPseudo("tristandu33");
		u1.setEmail("tristan.poul@hotmail.fr");
		u1.setAvatar("chemin/dossier/image");
		u1.setMotDePasse("23456346hbhdbG");
		u1 = utilisateurRepo.save(u1);
		
		Utilisateur u2 = new Utilisateur();
		u2.setPseudo("pokemonator");
		u2.setEmail("poke.mon@yahoo.fr");
		u2.setAvatar("dossier/jeux/avatar");
		u2.setMotDePasse("lesoleilbrille3344");
		u2.setStatistique(stats);
		u2 = utilisateurRepo.save(u2);
		
		Utilisateur u3 = new Utilisateur();
		u3.setPseudo("francisdu92");
		u3.setEmail("francis.lalane@gmail.com");
		u3.setAvatar("C/avatars/image");
		u3.setMotDePasse("troisplusdeux=7");
		u3 = utilisateurRepo.save(u3);
		
		Object[] infoJoueur = utilisateurRepo.findPseudoMailAvatarStatsById(u2.getId()); 
		Statistique statFind = (Statistique)infoJoueur[3];
		
		Assert.assertEquals(u2.getPseudo(), infoJoueur[0]);
		Assert.assertEquals(u2.getEmail(), infoJoueur[1]);
		Assert.assertEquals(u2.getAvatar(), infoJoueur[2]);
		Assert.assertEquals(stats.getPokemonPrefere(), statFind.getPokemonPrefere());
		
		utilisateurRepo.delete(u1);
		utilisateurRepo.delete(u2);
		utilisateurRepo.delete(u3);  
	}
}
