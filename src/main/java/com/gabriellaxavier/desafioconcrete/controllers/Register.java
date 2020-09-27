package com.gabriellaxavier.desafioconcrete.controllers;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cadastro")
public class Register {

    @Autowired
    private UserService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable String id){

        Optional<UserModel> obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);

//        List<PhoneModel> listPhone = new ArrayList<>();
//        listPhone.add(new PhoneModel("81", "995784030"));
//        listPhone.add(new PhoneModel("85", "995488241"));
//
//        CadastroModel cadastro = new CadastroModel("1","Gabriella","gabriella@teste.com","0055",listPhone, "87013df687g0sg687777773571sdfg68s7dfg36","","","");
//
//        List<CadastroModel> lista = new ArrayList<>();
//        lista.add(cadastro);
//
//        return lista;
    }
}
