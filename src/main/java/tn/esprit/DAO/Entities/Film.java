package tn.esprit.DAO.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder //  constructeur  a faire  quand  on sera  bessoin

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    @Enumerated (EnumType.STRING)
    TypeFilm typeFilm;

    @Temporal(TemporalType.DATE)
    Date dateProduction;
}
