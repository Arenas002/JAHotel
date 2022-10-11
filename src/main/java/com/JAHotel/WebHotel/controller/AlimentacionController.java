package com.JAHotel.WebHotel.controller;

import com.JAHotel.WebHotel.model.domain.Alimentacion;
import com.JAHotel.WebHotel.model.service.alimentacionService;
import com.JAHotel.WebHotel.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;
import java.util.Optional;

@RestController//@RestController anotacion que indica que esta clase es un controlador de rest
@CrossOrigin(value = "*") //@CrossOrigin anotacion que indica que esta
public class AlimentacionController {
    @Autowired
    private MyResponseUtility response ;

    @Autowired
    private alimentacionService alimentacionService;

    @GetMapping(path = "/api/v1/alimentacion")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = alimentacionService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/alimentacion/{id}")
    public ResponseEntity<MyResponseUtility> indexporId(@PathVariable(value = "id") Integer id) {


        try {
            response.data = alimentacionService.getById(id);

        } catch (DataAccessException e) {
            response.message = (" Error al realizar la consulta en la base de datos");
            response.descriptionError = (Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (((Optional<?>) response.data).isEmpty()) {
            response.message = ("El alimento con` Id: ".concat(id.toString().concat(" no exixte en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }


}
