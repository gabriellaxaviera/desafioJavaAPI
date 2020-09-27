package com.gabriellaxavier.desafioconcrete.controllers;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Register {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<?> insert (@RequestBody UserModel obj)
    {
        obj = service.insert(obj);
        return ResponseEntity.accepted().body(obj);
    }
}

