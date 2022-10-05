package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Factura {
    @Id
    @Column(name = "ID",nullable = false)
    private Integer id;

    @Column(name = "DETALLE")
    private String detalle;

    @Column(name = "VALOR",nullable = false)
    private Integer valorFactura;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Huesped.class)
    @JsonManagedReference(value = "id_huesped")
    @JoinColumn(name = "ID_HUESPED")
    private Huesped huesped;

}
