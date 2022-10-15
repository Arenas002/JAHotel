package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Factura {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DETALLE")
    private String detalle;

    @Column(name = "VALOR",nullable = false)
    private Integer valorFactura;


    @Column(name = "id_productoporhuesped", nullable = false, insertable = false,updatable = false)
    private Integer productorPorHuesped;



    @ManyToOne(fetch = FetchType.EAGER,targetEntity = ProductosPorHuesped.class)
    // @JsonManagedReference(value = "id_huesped")
    @JoinColumn(name = "id_productoporhuesped", nullable = false, insertable = false,updatable = false)
    private ProductosPorHuesped productosPorHuesped;

}
