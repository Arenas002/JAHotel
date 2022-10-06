package com.JAHotel.WebHotel.model.service;

import com.JAHotel.WebHotel.model.domain.Producto;
import com.JAHotel.WebHotel.model.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    public List<Producto> getAll(){return productoRepository.findAll();}

    @Transactional(readOnly = true)
    public Optional<Producto> getById(Integer id){
        return productoRepository.findById(id);
    }

    public Producto create(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto update(Integer id, Producto producto){
        var product = productoRepository.findById(id);
        if(product.isPresent()){
            producto.setId(id);
             productoRepository.save(producto);
        }
        return product.get();
    }

    public Producto delete(Integer id){
        productoRepository.deleteById(id);
        return null;
    }
}
