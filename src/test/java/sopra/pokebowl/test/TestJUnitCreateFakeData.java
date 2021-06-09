package sopra.pokebowl.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Action;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Tour;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.ITourRepository;
import sopra.pokebowl.repository.ITypeClassRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitCreateFakeData {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	public void CreateFakeDate() {
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		ISalonRepository salonRepo = context.getBean(ISalonRepository.class);
		ICombatRepository combatRepo = context.getBean(ICombatRepository.class);
		ITourRepository tourRepo = context.getBean(ITourRepository.class);
		ITypeClassRepository typeClassRepo = context.getBean(ITypeClassRepository.class);
		
//		Utilisateur utilisateur1 = new Utilisateur();
//		utilisateur1.setPseudo("pokemonator");
//		utilisateur1.setEmail("jean.jojo@gmail.com");
//		utilisateur1.setAvatar("chemin/avatar");
//		utilisateur1.setMotDePasse("lesoleilbrille33");
//		
//		utilisateur1 = utilisateurRepo.save(utilisateur1);
//		
//		Utilisateur utilisateur2 = new Utilisateur();
//		utilisateur2.setPseudo("jeanyves");
//		utilisateur2.setEmail("alexis.dupond@hotmail.fr");
//		utilisateur2.setAvatar("disqueC/image/avatar4");
//		utilisateur2.setMotDePasse("unplusdeux++");
//		
//		utilisateur2 = utilisateurRepo.save(utilisateur2);
		
//		Salon salon = new Salon();
//		salon.setNom("salon des bg");
//		salon.setMotDePasse("32785654");
//		
//		salon = salonRepo.save(salon);
//		
//		Salon salon2 = new Salon();
//		salon2.setNom("salon numéro 3");
//		salon2.setMotDePasse("998765411");
		
//		salon2 = salonRepo.save(salon2);
		
//		Combat combat = new Combat(); 
//		combat.setIdUtilisateurGagnant(1L);
//		
//		Combat combat2 = new Combat(); 
//		combat2.setIdUtilisateurGagnant(90L);
//		
//		Combat combat3 = new Combat(); 
//		combat3.setIdUtilisateurGagnant(23L);
//		
//		Combat combat4 = new Combat(); 
//		combat4.setIdUtilisateurGagnant(34L);
//		
//		combat = combatRepo.save(combat);
//		combat2 = combatRepo.save(combat2);
//		combat3 = combatRepo.save(combat3);
//		combat4 = combatRepo.save(combat4);
		
//		Tour tour = new Tour();
//		tour.setActionJoueur1(Action.ATTAQUER);
//		tour.setActionJoueur2(Action.CHANGER);
//		tour.setAttaquePokemon1("Abattage");
//		tour.setAttaquePokemon2("Abîme"); 
//		
//		tour = tourRepo.save(tour);
//		
//		Tour tour2 = new Tour();
//		tour2.setActionJoueur1(Action.CHANGER);
//		tour2.setActionJoueur2(Action.ATTAQUER);
//		tour2.setAttaquePokemon1("Abîme");
//		tour2.setAttaquePokemon2("Abattage"); 
//		
//		tour2 = tourRepo.save(tour2);
		
		TypeClass t1 = new TypeClass();
		t1.setType(TypeEnum.ACIER);
		t1.setAvatar("/oihvoieh/ozefzhf");
		
		TypeClass t2 = new TypeClass();
		t2.setType(TypeEnum.COMBAT);
		t2.setAvatar("cjfjfjf/jfjfjfj");
		
		t1 = typeClassRepo.save(t1);
		t2 = typeClassRepo.save(t2);
	}
}
