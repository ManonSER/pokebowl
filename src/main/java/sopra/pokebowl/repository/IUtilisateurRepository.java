package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	@Query("select u from Utilisateur u where u.pseudo = :pseudo and u.motDePasse = :mot_de_passe")
	public Utilisateur findUtilisateurbyPseudoMdp(@Param("pseudo") String pseudo, @Param("mot_de_passe") String motDePasse);
	
	@Query("select u from Utilisateur u where u.pseudo = :pseudo")
	public Utilisateur findPseudobyPseudo(@Param("pseudo") String pseudo);
	
	@Query("select u from Utilisateur u where u.email = :email")
	public Utilisateur findEmailbyUtilisateur(@Param("email") String email);

}
