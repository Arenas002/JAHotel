package com.JAHotel.WebHotel.model.domain.service;

import com.JAHotel.WebHotel.model.domain.HABITACION;
import com.JAHotel.WebHotel.model.domain.repository.habitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class habitacionService {

    @Autowired//@Autowired es una anotación que indica que la clase depende de otra clase.
    private habitacionRepository habitacionRepository;



    @Transactional(readOnly = true)
    public List<HABITACION> findAll() {
        return habitacionRepository.findAll();
    }
}
