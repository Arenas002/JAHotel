package com.JAHotel.WebHotel.controller;


import com.JAHotel.WebHotel.model.domain.service.habitacionService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@RestController anotacion que indica que esta clase es un controlador de rest
@CrossOrigin(value = "*") //@CrossOrigin anotacion que indica que esta clase se puede llamar desde cualquier origen

public class HabitacionController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private habitacionService habitacionService;

    @GetMapping(path = "/api/v1/habitacion")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = habitacionService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
