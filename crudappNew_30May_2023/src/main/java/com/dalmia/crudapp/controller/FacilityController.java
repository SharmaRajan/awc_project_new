package com.dalmia.crudapp.controller;

import com.dalmia.crudapp.entity.Facility;
import com.dalmia.crudapp.request.FacilityFormRequest;
import com.dalmia.crudapp.service.IFacilityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("/lists")
    public ResponseEntity<?> getFacility(HttpServletRequest request){
        return ResponseEntity.ok(facilityService.getAllFacilities(request));
    }

    /*@GetMapping("/lists/{id}")
    public ResponseEntity<?> getFacility(@PathVariable int id){
        return ResponseEntity.ok(facilityService.getFacility(id));
    }*/

    @PostMapping("/lists")
    public ResponseEntity<Facility> saveFacility(@RequestBody @Valid FacilityFormRequest request){
        return new ResponseEntity<>(facilityService.saveFacility(request),HttpStatus.CREATED);
    }

}
