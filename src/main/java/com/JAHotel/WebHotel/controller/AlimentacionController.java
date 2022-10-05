package com.JAHotel.WebHotel.controller;

import com.JAHotel.WebHotel.model.service.alimentacionService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController//@RestController anotacion que indica que esta clase es un controlador de rest
@CrossOrigin(value = "*") //@CrossOrigin anotacion que indica que esta
public class AlimentacionController {
    @Autowired
    private MyResponseUtility response;

    @Autowired
    private alimentacionService alimentacionService;

    @GetMapping(path = "/api/v1/alimentacion")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = alimentacionService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/alimentacion/{id}")
    public ResponseEntity<MyResponseUtility> indexporId(@PathVariable(value = "id") Integer id) {
        response.data = alimentacionService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
