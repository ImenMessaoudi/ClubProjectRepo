package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.DAO.Entities.Film;
import tn.esprit.DAO.Entities.TypeFilm;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmRepo extends CrudRepository<Film,Long> {

    //Film getByDateProduction(Date dateProduction);
//    @Query(value = " select Var  from  film Var " +
//            "where Var.nom=?1 and Var.date_production=?2 " , nativeQuery = true)
//    Film getFilmByNomAndDateProduction(String n, Date d);


    Film getByNomAndDateProduction(String n, Date d);

    @Query(value = "select * from film f" +
            "join salle_films sf on f.id = sf.films_id" +
            " join salle s on sf.salle_id = s.id" +
            " where s.id=?1", nativeQuery = true)
    List<Film> searchListFilmBySall(Long idSalle);




    List<Film> getFilmsByTypeFilm(TypeFilm typefilm);
}
