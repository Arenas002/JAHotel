package com.JAHotel.WebHotel.model.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "ALIMENTACION")

public class ALIMENTACION {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)

    private Integer Id;


    @Column(name = "TIPODEALIMENTACION", nullable = false)
    private String tipoDeAlimentacion;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;



}
