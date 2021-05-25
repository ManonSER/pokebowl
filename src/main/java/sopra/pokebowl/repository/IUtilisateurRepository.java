package sopra.pokebowl.repository;

import java.util.List;

import sopra.pokebowl.model.Utilisateur;

public interface IUtilisateurRepository extends  IRepository<Utilisateur, Long> {
	public Utilisateur findUtilisateurbyPseudoMdp(String pseudo, String motDePasse);
	public Utilisateur findPseudobyPseudo(String pseudo);
	public Utilisateur findEmailbyUtilisateur(String email);
	
	public Object[] findPseudoMailAvatarStatsById(Long id);
	public List<List<String>> findAvatarsPokeAllEquipesById(Long id);

}
