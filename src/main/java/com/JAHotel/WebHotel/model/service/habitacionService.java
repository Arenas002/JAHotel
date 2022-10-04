package com.JAHotel.WebHotel.model.service;

import com.JAHotel.WebHotel.model.domain.Habitacion;
import com.JAHotel.WebHotel.model.repository.habitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class habitacionService {

    @Autowired//@Autowired es una anotación que indica que la clase depende de otra clase.
    private habitacionRepository habitacionRepository;



    @Transactional(readOnly = true)
    public List<Habitacion> getAll() {
        return habitacionRepository.findAll();
    }

    public Habitacion create( Habitacion habitacion){
    return  habitacionRepository.save(habitacion);
    }

    public Habitacion update(Integer id,Habitacion habitacion){
        habitacion.setId(id);
        return habitacionRepository.save(habitacion);
    }

}
