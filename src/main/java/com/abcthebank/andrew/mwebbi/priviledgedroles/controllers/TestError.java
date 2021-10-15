package com.abcthebank.andrew.mwebbi.priviledgedroles.controllers;

import com.abcthebank.andrew.mwebbi.priviledgedroles.errorhandler.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/error")
public class TestError {

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<Object> resourceNotFound(@RequestParam Boolean enable) {
        try {
            if (enable) throw new ResourceNotFoundException("The resource you are looking for can not be found");
            return ResponseEntity.ok("{\"content\":\"resource is found\"");
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Run time exception:: The resource you are looking for can not be found");
        }

    }

}
