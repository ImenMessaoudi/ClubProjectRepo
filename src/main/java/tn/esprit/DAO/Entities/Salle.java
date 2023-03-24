package tn.esprit.DAO.Entities;


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

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Salle  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String nom;

    Integer capacite;

    @ManyToOne
    Cinema cinema;
    @ManyToMany (cascade = CascadeType.ALL)
    List <Film> films= new ArrayList<Film>();

}
