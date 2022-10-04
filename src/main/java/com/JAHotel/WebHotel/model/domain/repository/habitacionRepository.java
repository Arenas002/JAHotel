package com.JAHotel.WebHotel.model.domain.repository;

import com.JAHotel.WebHotel.model.domain.ALIMENTACION;
import com.JAHotel.WebHotel.model.domain.HABITACION;
import org.springframework.data.jpa.repository.JpaRepository;

public interface habitacionRepository extends JpaRepository<HABITACION,Integer> {
}
