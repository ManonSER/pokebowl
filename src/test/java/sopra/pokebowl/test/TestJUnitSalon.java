package sopra.pokebowl.test;

import org.junit.Assert;
import org.junit.Test;

import sopra.pokebowl.Application;
import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitSalon {
	
	@Test
	public void salonCreate() {
		ISalonRepository salonRepo = Application.getInstance().getSalonRepo();
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		Utilisateur joueur1 = new Utilisateur();
		Utilisateur joueur2 = new Utilisateur();
		joueur1 = utilisateurRepo.save(joueur1);
		joueur2 = utilisateurRepo.save(joueur2);
		
		Salon salon = new Salon();
		salon.setNom("salon des bg");
		salon.setMotDePasse("32785654");
		salon.setJoueur1(joueur1);
		salon.setJoueur2(joueur2); 
		
		Salon salonFind = salonRepo.findById(salon.getId());
		
		Assert.assertEquals("salon des bg", salonFind.getNom());
		Assert.assertEquals("32785654", salonFind.getMotDePasse());
		Assert.assertEquals(joueur1.getId(), salonFind.getJoueur1().getId());
		Assert.assertEquals(joueur2.getId(), salonFind.getJoueur2().getId());
		
		salonRepo.delete(salon);
		utilisateurRepo.delete(joueur1);
		utilisateurRepo.delete(joueur2);
	}
	
	@Test
	public void salonUpdate() {
		
	}
	
	@Test
	public void salonFindAllAndDelete() {
		
	}
}
