package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "PLAN")
public class Plan {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer Id;

    @Column(name = "TIPO_PLAN", nullable = false)
    private String TIPO_PLAN;

    @Column(name = "DESCRIPCION", nullable = false)
    private String DESCRIPCION;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "ID_HABITACION", nullable = false)
    private Integer ID_HABITACION;


    @Column(name = "ID_ALIMENTACION", nullable = false)
    private Integer ID_ALIMENTACION;

    // RELACIONES

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "ID_ALIMENTACION")
    @JoinColumn(name="ID_ALIMENTACION",nullable = false, insertable = false,updatable = false)
    private Alimentacion alimentacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "ID_HABITACION")
    @JoinColumn(name="ID_HABITACION",nullable = false,insertable = false,updatable = false)
    private Habitacion habitacion;



}
