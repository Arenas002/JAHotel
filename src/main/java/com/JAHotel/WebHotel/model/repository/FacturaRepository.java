package com.JAHotel.WebHotel.model.repository;

import com.JAHotel.WebHotel.model.domain.Alimentacion;
import com.JAHotel.WebHotel.model.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Integer> {
}
