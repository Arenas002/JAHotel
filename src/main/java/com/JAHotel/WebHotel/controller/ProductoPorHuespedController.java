package com.JAHotel.WebHotel.controller;

import com.JAHotel.WebHotel.model.domain.ProductosPorHuesped;
import com.JAHotel.WebHotel.model.service.ProductoPorHuespedService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class ProductoPorHuespedController {
    @Autowired
    private MyResponseUtility response;

    @Autowired
    private ProductoPorHuespedService productoPorHuespedService;

    @GetMapping(path = "/api/v1/productoporhuesped")
    public ResponseEntity<MyResponseUtility> getAll(){
        response.data = productoPorHuespedService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(path = "/api/v1/productoporhuesped/{id}")
    public ResponseEntity<MyResponseUtility> ObtenerPorId(@PathVariable(value="id") Integer id){
        response.data = productoPorHuespedService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping(path = "/api/v1/create/productoporhuesped")
    public ResponseEntity<MyResponseUtility>createProductoPorHuesped(@RequestBody ProductosPorHuesped productosPorHuesped){
        response.data = productoPorHuespedService.create(productosPorHuesped);
        return  new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping(path = "/api/v1/update/productoporhuesped/{id}")
    public ResponseEntity<MyResponseUtility> updateProductoPorHuesped(@PathVariable(value = "id")Integer id,@RequestBody ProductosPorHuesped productosPorHuesped){
        response.data = productoPorHuespedService.update(id,productosPorHuesped);
        return  new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/api/v1/eliminarProductoporhuesped/{id}")
    public ResponseEntity<MyResponseUtility>eliminarProductoporhuesped(@PathVariable(value = "id") Integer id){
        response.data = productoPorHuespedService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
