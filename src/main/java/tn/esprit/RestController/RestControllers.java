package tn.esprit.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import tn.esprit.DAO.Entities.Cinema;
import tn.esprit.DAO.Entities.Film;
import tn.esprit.DAO.Entities.Salle;
import tn.esprit.DAO.Entities.TypeFilm;
import tn.esprit.Services.IServises;

import java.util.Date;
import java.util.List;
@RestController
@Slf4j
public class RestControllers {
    @Autowired
    IServises iSer;

    public RestControllers(IServises iSer) {
        this.iSer = iSer;
    }


    @GetMapping("findAllCinema")
    List<Cinema> afficherListCinema() {
        return iSer.findAllCinema();

    }

    @GetMapping("searchCinemaByNom")
    public Cinema searchCinemaByNom(String nom){
        return iSer.searchCinemaByNom(nom);
    }

    @GetMapping("getFilmById")
    Film getFilmById(@RequestParam Long id) {
        return iSer.getFilmById(id);
    }

    @GetMapping("searchFByNomAndDateProd")
    Film searchFByNomAndDateProd(@RequestParam String nom, @RequestParam Date date) {
        return iSer.searchFilmByNomAndDateProd(nom, date);
    }

    @GetMapping("ChercherListeCinemaByAdresse")
    List<Cinema> ChercherListeCinemaByAdresse(String adresse){
        return iSer.trouverListeCinemaByAdresse(adresse);
    }

    @GetMapping("getCinByContains")
    List<Cinema> getCinByContains(@RequestParam String chaine) {
        return iSer.getListCinByChaineContaine(chaine);

    }

    @GetMapping("trouverSalleByCapacite")
    public Salle trouverSalleByCapacite(@RequestParam Integer capacite) {
        return iSer.trouverSalleByCapacite(capacite);

    }

    @PostMapping("addFilm")
    Film addFilm(@RequestBody Film f) {
        return iSer.addFilm(f);
    }


    @GetMapping("retriveAllFilm")
    List<Film> retriveAllFilm() {
        return (List<Film>) iSer.retriveAllFilm();
    }


    @PostMapping(" UpdateCinema")
    Cinema UpdateCinema(@RequestBody Cinema c) {
        return iSer.UpdateCinema(c);
    }


    @GetMapping("getAllSallesByCapacite")
    List<Salle> getAllSallesByCapacite(@RequestParam Integer capacite) {
        return iSer.getAllSallesByCapacite(capacite);

    }

    @GetMapping("retrouverSalleParChaine")
    Salle retrouverSalleParChaine(@RequestParam String chaine){
        return iSer.retrouverSalleParChaine(chaine);


    }

    @GetMapping("retriveListByTypeFilm")
    List<Film> retriveListByTypeFilm(@RequestParam TypeFilm typeFilm){
        return iSer.retriveListByTypeFilm(typeFilm);

    }


    @DeleteMapping("deleteSalleByCapacite")
    void deleteSalleByCapacite(@RequestParam  Integer capacite){
        iSer.deleteSalleByCapacite(capacite);
    }

    @DeleteMapping("deleteFilmById")
    void deleteFilmById(@RequestParam Long id){
        iSer.deleteFilmById(id);
    }

    @GetMapping("listerFilmsBySall")
    List<Film> listerFilmsBySall(@RequestParam Long idSall){
        return iSer.listerFilmsBySall(idSall);

    }
    @PutMapping("affecterUneSalleauCinema")
    void affecterUneSalleauCinema(@RequestParam Long idCinema,@RequestParam Long idSalle){
        iSer.affecterUneSalleauCinema(idCinema,idSalle);
    }

    @PutMapping("affecterFilmAuSalle")
    void affecterFilmAuSalle(@RequestBody Film film,@RequestParam String nom){
        iSer.ajouterFilmEtAffecterAuSalle(film,nom);
    }
}