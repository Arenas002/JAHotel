package com.JAHotel.WebHotel.controller;

import com.JAHotel.WebHotel.model.domain.Factura;
import com.JAHotel.WebHotel.model.domain.Habitacion;
import com.JAHotel.WebHotel.model.service.FacturaService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class FacturaController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private FacturaService facturaService;

    @GetMapping(path = "/api/v1/facturas")
    public ResponseEntity<MyResponseUtility> obtenerFacturas() {
        response.data = facturaService.getFactura();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/facturas/{id}")
    public ResponseEntity<MyResponseUtility> obtenerFacturasPorId(@PathVariable(value = "id") Integer id) {
        response.data = facturaService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path ="/api/v1/createFactura")
    public ResponseEntity<MyResponseUtility>crearFactura(@RequestBody Factura factura){
        response.data = facturaService.create(factura);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path ="api/v1/ActualizarFactura/{id}")
    public ResponseEntity<MyResponseUtility>actualizarFactura(@PathVariable(value = "id") Integer id,@RequestBody Factura factura){
        response.data = facturaService.update(id,factura);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "api/v1/eliminarFactura/{id}")
    public ResponseEntity<MyResponseUtility>eliminarFactura(@PathVariable(value = "id") Integer id) {
    response.data = facturaService.delete(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
