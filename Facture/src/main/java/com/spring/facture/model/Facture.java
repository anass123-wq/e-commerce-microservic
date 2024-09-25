package com.spring.facture.model;

import com.spring.facture.PrendreApi.Client;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -4612504723628291981L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false,name = "date_creation_facture")
    private Date date;

    @ManyToOne
    private Client client;

    @Column(nullable = false,name = "Totql")
    private float total;

    @OneToMany(mappedBy = "facture",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;

}
