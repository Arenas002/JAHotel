package com.JAHotel.WebHotel.model.repository;

import com.JAHotel.WebHotel.model.domain.Alimentacion;
import com.JAHotel.WebHotel.model.domain.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuespedRepository extends JpaRepository<Huesped,Integer> {
}
