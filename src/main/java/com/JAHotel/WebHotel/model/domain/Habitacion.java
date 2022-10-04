package com.JAHotel.WebHotel.model.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "HABITACION")
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer Id;

    @Column(name = "TIPOHABITACION", nullable = false, )
    private String tipoHabitacion;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "DISPONIBILIDAD")
    private Boolean disponibilidad;



}
