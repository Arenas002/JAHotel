package com.JAHotel.WebHotel.controller;

import com.JAHotel.WebHotel.model.domain.Producto;
import com.JAHotel.WebHotel.model.service.ProductoService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(value = "*")
public class ProductoController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private ProductoService productoService;

    @GetMapping(path = "/api/v1/producto")
    public ResponseEntity<MyResponseUtility> getAllProduct(){
        response.data = productoService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path ="/api/v1/producto/{id}")
    public ResponseEntity<MyResponseUtility> getProductById(@PathVariable(value = "id") Integer id){
        response.data = productoService.getById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/create/producto")
    public ResponseEntity<MyResponseUtility> create(@RequestBody Producto producto){
        response.data = productoService.create(producto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @PutMapping(path = "/api/v1/update/producto/{id}")
    public  ResponseEntity<MyResponseUtility> update(@PathVariable(value = "id")Integer id,@RequestBody Producto producto){
        response.data = productoService.update(id,producto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/v1/delete/producto/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable(value = "id")Integer id){
        response.data = productoService.delete(id);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

}
