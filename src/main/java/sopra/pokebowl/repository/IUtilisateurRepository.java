package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
		
	public Utilisateur findByPseudoAndMotDePasse(String pseudo, String motDePasse);
	
	public Utilisateur findByPseudo(String pseudo);
	
	public Utilisateur findByEmail(String email);
}
