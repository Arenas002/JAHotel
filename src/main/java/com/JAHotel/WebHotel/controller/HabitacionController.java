package com.JAHotel.WebHotel.controller;


import com.JAHotel.WebHotel.model.domain.Habitacion;
import com.JAHotel.WebHotel.model.service.habitacionService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//@RestController anotacion que indica que esta clase es un controlador de rest
@CrossOrigin(value = "*") //@CrossOrigin anotacion que indica que esta clase se puede llamar desde cualquier origen
//@RequestMapping("/habi")
public class HabitacionController {

    @Autowired
    private MyResponseUtility response;
    @Autowired
    private habitacionService habitacionService;

    @GetMapping(path = "/api/v1/habitacion")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = habitacionService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Habitacion>> getAllClients() {
//        var clientes = habitacionService.getAll();
//        return new ResponseEntity<>(clientes, HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/create")
    public ResponseEntity<MyResponseUtility>create(@RequestBody Habitacion habitacion){
        response.data = habitacionService.create(habitacion);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
