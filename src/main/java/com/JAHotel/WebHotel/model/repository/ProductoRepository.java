package com.JAHotel.WebHotel.model.repository;

import com.JAHotel.WebHotel.model.domain.Alimentacion;
import com.JAHotel.WebHotel.model.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
