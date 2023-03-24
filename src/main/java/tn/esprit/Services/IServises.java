package tn.esprit.Services;

import tn.esprit.DAO.Entities.Cinema;
import tn.esprit.DAO.Entities.Film;
import tn.esprit.DAO.Entities.Salle;
import tn.esprit.DAO.Entities.TypeFilm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IServises {

    Cinema searchCinemaByNom(String nom);
    List<Cinema> findAllCinema();

    Cinema UpdateCinema(Cinema c);
    Cinema findCinemaById(Long id);

    List<Cinema> getListCinByChaineContaine(String chaine);

    List<Cinema> getListCinByAdresse(String adresse);

    Film searchFilmByNomAndDateProd(String nom, Date dateP);

   Film getFilmById( Long id);

    //affecter un film  a  une  salle

 void affecterFilmAuSalle(Long idFilm, Long idSalle);


   //affecter une  salle  a  un cinema

   void  affecterUneSalleauCinema (Long idCinema ,Long idSalle);

    //déaffecter un film  a  une  salle

    void deaffecterFilmAuSalle(Long idFilm, Long idSalle);

    //déaffecter une  salle  a  un cinema

    void  deaffecterUneSalleFromCinema (Long idSalle);


    List<Film> listerFilmsBySall(Long idSall);

    Film ajouterFilmEtAffecterAuSalle(Film f, String nom);

    Salle trouverSalleByCapacite(Integer capacite);

    Film addFilm(Film f);
    List<Film> retriveAllFilm();

    List<Salle> getAllSallesByCapacite(Integer capacite);

    Salle retrouverSalleParChaine(String chaine);

    List<Film> retriveListByTypeFilm(TypeFilm typeFilm);

    void deleteSalleByCapacite(Integer capacite);

    void  deleteFilmById(Long id);

    List<Cinema> trouverListeCinemaByAdresse(String adresse);

}
