package com.gabriellaxavier.desafioconcrete.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriellaxavier.desafioconcrete.dto.LoginDTO;
import com.gabriellaxavier.desafioconcrete.dto.PerfilDTO;
import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class Perfil {

    @Autowired
    UserService service;

    @RequestMapping(value = "/userprofile/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> userprofile (PerfilDTO perfilDTO, @RequestHeader(value = "Token") UUID token , @PathVariable UUID id)
    {
        perfilDTO.setToken(token);
        UserModel tokenFound = service.profile(perfilDTO);
        return ResponseEntity.status(202).body(tokenFound);
    }
}
