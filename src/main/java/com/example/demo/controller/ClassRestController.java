package com.example.demo.controller;

import com.example.demo.model.Clazz;
import com.example.demo.service.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clazz")
@CrossOrigin("*")
public class ClassRestController {
    @Autowired
    private ClazzServiceImpl clazzService;
    @GetMapping("")
    public ResponseEntity<Iterable<Clazz>> findAllStudent() {
        Iterable<Clazz> clazz = clazzService.findAll();
        return new ResponseEntity<>(clazz, HttpStatus.OK);
    }
}
