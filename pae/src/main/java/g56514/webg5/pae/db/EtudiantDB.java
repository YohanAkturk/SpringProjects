package g56514.webg5.pae.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g56514.webg5.pae.model.Etudiant;

public interface EtudiantDB extends CrudRepository<Etudiant, Integer>{
    
    //Attention en JPQL on donne pas la table mais la classe !
    @Query("SELECT e.nom FROM Etudiant e WHERE e.nom = :nom")
    List<Object> getByLeNom(String nom);
    //les 2 méthodes ici (getByLeNom et findByNom) servent au mm truc. C'est juste pour test le JPQL.
    Iterable<Etudiant> findByNom(String nom);


    @Query("SELECT e.nom FROM Etudiant e")
    List<Object> getOnlyLeNom();

    @Query("SELECT e.nom, e.matricule FROM Etudiant e")
    List<Object[]> getLIdEtLeNom();

    @Query("SELECT e.nom, sum(cours.ects) FROM Etudiant e JOIN e.courses cours group by e")
    List<Object[]> getNomEtEcts();

    @Query("SELECT e.nom, sum(cours.ects) FROM Etudiant e JOIN e.courses cours group by e.nom HAVING sum(cours.ects) > :ects")
    List<Object[]> getNomEtEctsPlusQue(Long ects);
}
