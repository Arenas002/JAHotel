package com.JAHotel.WebHotel.model.repository;

import com.JAHotel.WebHotel.model.domain.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface habitacionRepository extends JpaRepository<Habitacion,Integer> {
}
