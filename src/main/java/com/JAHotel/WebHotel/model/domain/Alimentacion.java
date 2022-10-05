package com.JAHotel.WebHotel.model.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
// se elimino porque el nombre de la clase es igual al nombre de la tabla en la DB
@Table(name = "alimentacion")  // juan && Jhonatan 2022

public class Alimentacion {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)

    private Integer Id;


    @Column(name = "TIPODEALIMENTACION", nullable = false)
    private String tipoDeAlimentacion;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    // RELACIONES
    @OneToMany(mappedBy = "alimentacion")
    @JsonManagedReference(value = "ID_ALIMENTACION")

    private List<Plan> alimentacion= new ArrayList<>();




}
