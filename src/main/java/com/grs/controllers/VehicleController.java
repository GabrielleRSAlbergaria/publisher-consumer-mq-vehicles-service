package com.grs.controllers;

import com.grs.models.dto.VehicleDTO;
import com.grs.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    private ResponseEntity postMessage(@RequestBody VehicleDTO vehicleDTO){
        this.vehicleService.sendVehicleToQueue(vehicleDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
