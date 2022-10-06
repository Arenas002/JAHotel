package com.JAHotel.WebHotel.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "HABITACION")
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;



    @Id
    @Column(name = "ID", nullable = false)
    private Integer Id;

    @Column(name = "TIPOHABITACION", nullable = false)
    private String tipoHabitacion;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "DISPONIBILIDAD")
    private Boolean disponibilidad;

// RELACIONES el backreference envia los datos

    @OneToMany(mappedBy = "habitacion")
    @JsonBackReference(value = "ID_HABITACION")
    private List<Plan> habitacion = new ArrayList<>();



}
