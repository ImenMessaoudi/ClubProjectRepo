package tn.esprit.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.Entities.Cinema;
import tn.esprit.DAO.Entities.Film;
import tn.esprit.DAO.Entities.Salle;
import tn.esprit.DAO.Entities.TypeFilm;
import tn.esprit.DAO.Repositories.CinemaRepo;
import tn.esprit.DAO.Repositories.FilmRepo;
import tn.esprit.DAO.Repositories.SalleRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class Serverses implements  IServises {

    @Autowired
    FilmRepo fRepo;

    @Autowired
    CinemaRepo cRepo;

    @Autowired
    SalleRepo sRepo;


    @Override
    public Cinema searchCinemaByNom(String nom) {
        return cRepo.getByNom(nom);
    }

    @Override
    public List<Cinema> findAllCinema() {
        return (List<Cinema>) cRepo.findAll();
    }

    @Override
    public Cinema UpdateCinema(Cinema c) {

        log.info("Cinema update avec succes ");
        return cRepo.save(c);
    }

    @Override
    public Cinema findCinemaById(Long id) {
        return cRepo.findById(id).get();
    }

    @Override
    public List<Cinema> getListCinByChaineContaine(String chaine) {
        return (List<Cinema>) cRepo.getByNomContains(chaine);
    }

    @Override
    public List<Cinema> getListCinByAdresse(String adresse) {
        if(adresse == "" ){
            log.error("Chaine Vide");
        }
        return (List<Cinema>) cRepo.retreveByAdresswithParamSQL(adresse);
    }

    @Override
    public Film searchFilmByNomAndDateProd(String nom, Date dateP) {
        return fRepo.getByNomAndDateProduction(nom,dateP);
    }

    @Override
    public Film getFilmById(Long id) {
        return fRepo.findById(id).get();
    }

    @Override
    public void affecterFilmAuSalle(Long idFilm, Long idSalle) {
        Film filmAffecter = fRepo.findById(idFilm).get();// child
        Salle salleAffecter = sRepo.findById(idSalle).get();// parent
        salleAffecter.setFilms((List<Film>) filmAffecter);

        sRepo.save(salleAffecter);
    }

    @Override
    public void affecterUneSalleauCinema(Long idCinema, Long idSalle) {
        //recuperer les  objets
        Salle salleAffecter = sRepo.findById(idSalle).get(); //Parent
        Cinema cinemaAffecter = cRepo.findById(idCinema).get();// child
        // on affecte  le  child  au parent
        salleAffecter.setCinema(cinemaAffecter);
        sRepo.save(salleAffecter);
    }

    @Override
    public void deaffecterFilmAuSalle(Long idFilm, Long idSalle) {
       Film filmDeafecter =  fRepo.findById(idFilm).get();
       Salle salleAsafecter = sRepo.findById(idSalle).get();

        salleAsafecter.getFilms().remove(filmDeafecter);

        sRepo.save(salleAsafecter);

    }

    @Override
    public void deaffecterUneSalleFromCinema(Long idSalle) {
        Salle salleDesafecter = sRepo.findById(idSalle).get();
        salleDesafecter.setCinema(null);
        sRepo.save(salleDesafecter);

    }


    @Override
    public List<Film> listerFilmsBySall(Long idSall) {

        return fRepo.searchListFilmBySall(idSall);
    }

    @Override
    public Film ajouterFilmEtAffecterAuSalle(Film f, String nom) {
        Salle salleAffecter = sRepo.getByNom(nom);//parent
        //film=child
        //on affecte  le  child  au parent
        // On a  utuliser la cascade pou  persister
        fRepo.save(f);
        salleAffecter.getFilms().add(f);
        sRepo.save(salleAffecter);
        return f;
    }

    @Override
    public Salle trouverSalleByCapacite(Integer capacite) {
            return sRepo.findSalleByCapacite(capacite);

    }

    @Override
    public Film addFilm(Film f) {
        log.warn("le Film est Ajouté avec  succes");
        return fRepo.save(f);
    }

    @Override
    public List<Film> retriveAllFilm() {
        return (List<Film>) fRepo.findAll();
    }

    @Override
    public List<Salle> getAllSallesByCapacite(Integer capacite) {
       List<Salle> salles = (List<Salle>) sRepo.findAll();
       List <Salle> sallesCapacite= new ArrayList<Salle>();
        for (Salle s:salles) {
            if(s.getCapacite()>=capacite){
                sallesCapacite.add(s);
            }

        }
        log.error(String.valueOf(sallesCapacite.size()));
        return sallesCapacite;
    }

    @Override
    public Salle retrouverSalleParChaine(String chaine) {
        return sRepo.getByNomContains(chaine);

    }

    @Override
    public List<Film> retriveListByTypeFilm(TypeFilm typeFilm) {
        return fRepo.getFilmsByTypeFilm(typeFilm);
    }

    @Override
    public void deleteSalleByCapacite(Integer capacite) {
        sRepo.deleteSalleByCapacite(capacite);
    }

    @Override
    public void deleteFilmById(Long id) {
        fRepo.deleteById(id);
    }

    @Override
    public List<Cinema> trouverListeCinemaByAdresse(String adresse) {
        log.warn("la liste est  bien  affichés");
        return cRepo.retreveByAdresswithParamSQL(adresse);
    }
}