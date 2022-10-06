package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Huesped implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    @Column(name = "IDENTIFICACION", nullable = false)
    private Integer identificacion;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TELEFONO", nullable = false)
    private Integer telefono;

    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Column(name = "ID_PlAN", nullable = false)
    private String id_plan;

    @Column(name = "ID_PRODUCTO", nullable = false)
    private String id_producto;

// RELACIONES

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Producto.class)
   // @JsonManagedReference(value = "ID_PRODUCTO")
    @JoinColumn(name="ID_PRODUCTO",nullable = false, insertable = false,updatable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Plan.class)
    //@JsonManagedReference(value = "ID_PlAN")
    @JoinColumn(name="ID_PlAN",nullable = false, insertable = false,updatable = false)
    private Plan plan;



    @OneToMany(mappedBy = "huesped")
    @JsonBackReference(value = "id_huesped")
    private List<Factura> factura = new ArrayList<>();
}
