package com.JAHotel.WebHotel.controller;

import com.JAHotel.WebHotel.model.domain.Habitacion;
import com.JAHotel.WebHotel.model.domain.Plan;
import com.JAHotel.WebHotel.model.service.PlanService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//@RestController anotacion que indica que esta clase es un controlador de rest
@CrossOrigin(value = "*")
public class PlanController {
    @Autowired
    private MyResponseUtility response;

    @Autowired
    private PlanService planService;

    @GetMapping(path = "/api/v1/plan")
    public ResponseEntity<MyResponseUtility> obtenerPlanes() {
        response.data = planService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/plan/{id}")
    public ResponseEntity<MyResponseUtility> obtenerPlanPorId(@PathVariable(value = "id") Integer id) {
        response.data = planService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path ="/crearPlan")
    public ResponseEntity<MyResponseUtility>create(@RequestBody Plan plan){
        response.data = planService.create(plan);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
