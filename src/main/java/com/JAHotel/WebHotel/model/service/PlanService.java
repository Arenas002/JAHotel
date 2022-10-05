package com.JAHotel.WebHotel.model.service;

import com.JAHotel.WebHotel.model.domain.Alimentacion;
import com.JAHotel.WebHotel.model.domain.Habitacion;
import com.JAHotel.WebHotel.model.domain.Plan;
import com.JAHotel.WebHotel.model.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Transactional(readOnly = true)
    public List<Plan> getAll() {
        return planRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Plan> getById(Integer id) {

        return planRepository.findById(id);
    }

    public Plan create(Plan plan){
        return  planRepository.save(plan);
    }


}
