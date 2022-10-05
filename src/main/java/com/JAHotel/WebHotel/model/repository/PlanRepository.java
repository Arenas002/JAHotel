package com.JAHotel.WebHotel.model.repository;

import com.JAHotel.WebHotel.model.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
