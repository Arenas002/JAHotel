package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "productosporhuesped")
public class ProductosPorHuesped implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( nullable = false)
    private Integer idhuesped;

    @Column(nullable = false)
    private Integer idproducto;

    @Column(nullable = false)
    private Integer cantidadproducto;


    // RELACIONES

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Producto.class)
//    @JsonManagedReference(value = "ID_PRODUCTO")
    @JoinColumn(name="idproducto",nullable = false, insertable = false,updatable = false)
    private Producto producto;


    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Huesped.class)
//     @JsonManagedReference(value = "id_huesped")
    @JoinColumn(name = "idhuesped", nullable = false, insertable = false,updatable = false)
    private Huesped huesped;


    @OneToMany(mappedBy = "productosPorHuesped")
    @JsonBackReference(value = "ID_FACTURA")
    private List<Factura> productosPorHuesped;
}
