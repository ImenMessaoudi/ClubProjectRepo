package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.DAO.Entities.Salle;
@Repository
public interface SalleRepo extends CrudRepository<Salle,Long> {


    Salle getByNom(String nom);

    Salle findSalleByCapacite(Integer capacite);

    Salle getByNomContains(String chaine);

     @Modifying
     @Query(value = "delete s from salle s where  s.capacite=:capa", nativeQuery = true)
     void  deleteSalleByCapacite(@Param(value="capa") Integer capacite);

}
