package com.JAHotel.WebHotel.controller;

import com.JAHotel.WebHotel.model.domain.Factura;
import com.JAHotel.WebHotel.model.domain.Habitacion;
import com.JAHotel.WebHotel.model.service.FacturaService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class FacturaController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private FacturaService facturaService;

    @GetMapping(path = "/api/v1/facturas")
    public ResponseEntity<MyResponseUtility> obtenerFacturas() {
        response.restart();
        response.data = facturaService.getFactura();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/facturas/{id}")
    public ResponseEntity<MyResponseUtility> obtenerFacturasPorId(@PathVariable(value = "id") Integer id) {
        response.restart();
        try {
            response.data = facturaService.getById(id);
        }catch (DataAccessException e) {
        response.message= ("Error al realizar la consulta en la base de datos");
        response.descriptionError = (Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(((Optional<?>)response.data).isEmpty()) {
            response.message = ("La factura con` Id: ".concat(id.toString().concat(" no exixte en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path ="/api/v1/createFactura")
    public ResponseEntity<MyResponseUtility>crearFactura(@RequestBody Factura factura){
        response.restart();
        try {

            response.data = facturaService.create(factura);
        }catch (DataAccessException e) {
            response.error = true;
            response.message=("Error al realizar el insert en la base de datos");
            response.descriptionError=(Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.message=("El cliente ha sido creado");
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
