package com.JAHotel.WebHotel.model.service;

import com.JAHotel.WebHotel.model.domain.Factura;
import com.JAHotel.WebHotel.model.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Transactional(readOnly = true)
    public List<Factura> getFactura(){
        return facturaRepository.findAll();
    }

    public Optional<Factura> getById(Integer id){
        return facturaRepository.findById(id);
    }

    public Factura create(Factura factura){
        return facturaRepository.save(factura);
    }

    public Factura update(Integer id, Factura factura){
    factura.setId(id);
    return facturaRepository.save(factura);
    }

    public Factura delete(Integer id){
        facturaRepository.deleteById(id);
        return null;
    }

}
