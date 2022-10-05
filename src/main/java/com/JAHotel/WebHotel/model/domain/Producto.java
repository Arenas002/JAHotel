package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "PRODUCTO")

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "CANTIDADDISPONIBLE",nullable = false)
    private Integer cantidadDisponible;

    @Column(name = "VALOR")
    private Integer valorProducto;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producto")
    @JsonBackReference(value = "ID_PRODUCTO")
    private List<Huesped> producto = new ArrayList<>();
}
