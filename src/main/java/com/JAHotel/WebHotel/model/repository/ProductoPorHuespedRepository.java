package com.JAHotel.WebHotel.model.repository;

import com.JAHotel.WebHotel.model.domain.ProductosPorHuesped;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoPorHuespedRepository extends JpaRepository<ProductosPorHuesped,Integer> {

@Query(value = "SELECT * FROM productosporhuesped  WHERE productosporhuesped.idhuesped =:idhuesped and productosporhuesped.idproducto =:idproducto",nativeQuery = true)
    List<ProductosPorHuesped> getByIdProductos(@Param(value = "idhuesped")Integer idhuesped, @Param(value="idproducto")Integer idproducto);
}