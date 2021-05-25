package sopra.pokebowl.test;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitCombat {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	public void combatCreate() {
		ICombatRepository combatRepo = context.getBean(ICombatRepository.class);
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		ISalonRepository salonRepo = context.getBean(ISalonRepository.class);
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		
		Utilisateur joueur1 = new Utilisateur();
		Utilisateur joueur2 = new Utilisateur();
		joueur1 = utilisateurRepo.save(joueur1);
		joueur2 = utilisateurRepo.save(joueur2);
		 
		Salon salon = new Salon();
		salon.setJoueur1(joueur1);
		salon.setJoueur2(joueur2);
		salon = salonRepo.save(salon);
		
		Equipe equipeJoueur1 = new Equipe();
		Equipe equipeJoueur2 = new Equipe();
		equipeJoueur1 = equipeRepo.save(equipeJoueur1);  
		equipeJoueur2 = equipeRepo.save(equipeJoueur2);
		
		Combat combat = new Combat(); 
		combat.setIdUtilisateurGagnant(salon.getJoueur1().getId());
		combat.setSalon(salon);
		combat.setEquipe1(equipeJoueur1);
		combat.setEquipe2(equipeJoueur2);
		
		combat = combatRepo.save(combat);
		
		Combat combatFind = combatRepo.save(combat);
		
		Assert.assertEquals(salon.getId(), combatFind.getSalon().getId());
		Assert.assertEquals(equipeJoueur1.getId(), combatFind.getEquipe1().getId());
		Assert.assertEquals(equipeJoueur2.getId(), combatFind.getEquipe2().getId());
		Assert.assertEquals(salon.getJoueur1().getId(), combatFind.getIdUtilisateurGagnant());
		
		combatRepo.delete(combat);
		
		salonRepo.delete(salon);
		utilisateurRepo.delete(joueur1);  
		utilisateurRepo.delete(joueur2);
		
		equipeRepo.delete(equipeJoueur1);
		equipeRepo.delete(equipeJoueur2);
	  
	}
	
	@Test
	public void combatUpdate() {
		ICombatRepository combatRepo = context.getBean(ICombatRepository.class);
		
		Combat combat = new Combat();
		combat.setIdUtilisateurGagnant(45L);
		
		combat = combatRepo.save(combat);
		
		combat.setIdUtilisateurGagnant(12L);
		
		combat = combatRepo.save(combat);
		
		combat = combatRepo.save(combat);
		
		Optional<Combat> combatFind = combatRepo.findById(combat.getId());
		
		Assert.assertEquals((Long)12L, combatFind.get().getIdUtilisateurGagnant());
		
		combatRepo.delete(combat);
	}
	
	@Test
	public void combatFindAllAndDelete() {
		ICombatRepository combatRepo = context.getBean(ICombatRepository.class);
		
		Combat combat1 = new Combat();
		Combat combat2 = new Combat();
		Combat combat3 = new Combat();
		Combat combat4 = new Combat();
		
		combat1 = combatRepo.save(combat1);
		combat2 = combatRepo.save(combat2);
		combat3 = combatRepo.save(combat3);
		combat4 = combatRepo.save(combat4);  
		
		List<Combat> combats = combatRepo.findAll();
		
		Assert.assertEquals(4, combats.size());
		
		combatRepo.delete(combat1);
		combatRepo.delete(combat2);
		combatRepo.delete(combat3);
		combatRepo.delete(combat4);
		
		combats = combatRepo.findAll();
		
		Assert.assertEquals(0, combats.size());
		
	}
	
 }
