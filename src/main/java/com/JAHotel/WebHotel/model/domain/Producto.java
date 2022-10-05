package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Producto {
    @Id
    @Column(name = "ID",nullable = false)
    private Integer id;

    @Column(name = "NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "CANTIDADDISPONIBLE",nullable = false)
    private Integer cantidadDisponible;

    @Column(name = "VALOR")
    private Integer valorProducto;

    @OneToMany(mappedBy = "producto")
    @JsonBackReference(value = "ID_PRODUCTO")
    private List<Huesped> producto;
}