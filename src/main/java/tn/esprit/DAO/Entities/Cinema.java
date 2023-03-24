package tn.esprit.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder //  constructeur  a faire  quand  on sera  bessoin

@FieldDefaults(level = AccessLevel.PRIVATE)// Modificateur  d'acces
public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    @Column(length = 50) //controle  de  saisie  sur  le  nbr de  caractere
     String adresse;

    @Column(unique = true) // unicite  dans  la  base
    Integer telephone;


    @JsonIgnore
   @OneToMany(mappedBy = "cinema") // mappedby (unidirectionnel)
    List <Salle> salles = new ArrayList<Salle>();
}
