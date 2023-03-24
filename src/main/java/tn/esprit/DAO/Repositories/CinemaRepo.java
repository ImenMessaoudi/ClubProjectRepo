package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.DAO.Entities.Cinema;

import java.util.List;

@Repository
public interface CinemaRepo extends CrudRepository<Cinema,Long> {


    Cinema getByNom(String n);


    List<Cinema> getByNomContains(String nom);



    //selectionner  la  liste  des  Cinema where  adresse  passe en  parametre

    @Query(value = "select * from cinema  where adresse like %?1% ",nativeQuery = true)
    List<Cinema> retreveByAdresswithParamSQL( String param);


}
