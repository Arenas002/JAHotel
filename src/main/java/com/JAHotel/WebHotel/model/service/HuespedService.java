package com.JAHotel.WebHotel.model.service;

import com.JAHotel.WebHotel.model.domain.Factura;
import com.JAHotel.WebHotel.model.domain.Habitacion;
import com.JAHotel.WebHotel.model.domain.Huesped;
import com.JAHotel.WebHotel.model.repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class HuespedService {
    @Autowired
    private HuespedRepository huespedRepository;


    @Transactional(readOnly = true)
    public List<Huesped> getAll() {
        return huespedRepository.findAll();
    }

    public Optional<Huesped> getById(Integer id){
        return huespedRepository.findById(id);
    }

    public Huesped create( Huesped huesped){
        return  huespedRepository.save(huesped);
    }

    public Huesped update(Integer id,Huesped huesped){
        huesped.setId(id);
        return huespedRepository.save(huesped);
    }

    public Huesped delete(Integer id){
        huespedRepository.deleteById(id);
        return null;
    }
}



