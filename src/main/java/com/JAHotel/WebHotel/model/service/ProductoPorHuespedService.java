package com.JAHotel.WebHotel.model.service;

import com.JAHotel.WebHotel.model.domain.ProductosPorHuesped;
import com.JAHotel.WebHotel.model.repository.ProductoPorHuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class ProductoPorHuespedService {

    @Autowired
    private ProductoPorHuespedRepository productoPorHuespedRepository;

    @Transactional(readOnly = true)
    public List<ProductosPorHuesped> getAll(){
        return productoPorHuespedRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ProductosPorHuesped> getById(Integer id) {
        return productoPorHuespedRepository.findById(id);
    }

    public List<ProductosPorHuesped>  getByIdProductos(Integer idhuesped, Integer idProducto){
        List<ProductosPorHuesped> listByIdProductos = productoPorHuespedRepository.getByIdProductos(idhuesped, idProducto);
        return listByIdProductos;
    }

    public ProductosPorHuesped create(ProductosPorHuesped productosPorHuesped){
        return productoPorHuespedRepository.save(productosPorHuesped);
    }

    public ProductosPorHuesped update(Integer id, ProductosPorHuesped productosPorHuesped){
        productosPorHuesped.setId(id);
        return productoPorHuespedRepository.save(productosPorHuesped);
    }

    public ProductosPorHuesped delete(Integer id){
        productoPorHuespedRepository.deleteById(id);
        return null;
    }
}
