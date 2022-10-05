package com.JAHotel.WebHotel.model.service;

import com.JAHotel.WebHotel.model.domain.Alimentacion;
import com.JAHotel.WebHotel.model.repository.AlimentacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class alimentacionService {

    @Autowired
    private AlimentacionRepository alimentacionRepository;

    @Transactional(readOnly = true)
    public List<Alimentacion> getAll() {
        return alimentacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Alimentacion> getById(Integer id) {

       return alimentacionRepository.findById(id);
    }
}
