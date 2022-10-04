package com.JAHotel.WebHotel.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ALIMENTACION")
public class HABITACION {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer Id;

    @Column(name = "TIPOHABITACION", nullable = false)
    private String tipoHabitacion;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "DISPONIBILIDAD", nullable = true)
    private Boolean disponibilidad;



}
