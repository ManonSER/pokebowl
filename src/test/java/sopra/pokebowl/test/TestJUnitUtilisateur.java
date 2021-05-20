package sopra.pokebowl.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.Statistique;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IEquipeRepository;
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
		derniereEquipe.setNumero(0);
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
		Assert.assertEquals(derniereEquipe.getNumero(), utilisateurFind.getDerniereEquipe().getNumero());
		
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
		
		Assert.assertEquals(0, utilisateurs.size());
	}
}
