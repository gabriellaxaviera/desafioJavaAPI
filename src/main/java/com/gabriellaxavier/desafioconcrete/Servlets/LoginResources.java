package com.gabriellaxavier.desafioconcrete.Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriellaxavier.desafioconcrete.Entity.Login;
import com.gabriellaxavier.desafioconcrete.Entity.Phone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/auth", produces ={"application/json"})
public class LoginResources {

    @RequestMapping(method = RequestMethod.GET)
    private String listar() throws IOException {

        List<Phone> listPhone = new ArrayList<>();
        listPhone.add(new Phone("81", "995784030"));


        Login log1 = new Login("1", "Gabriella","gabriella@yeste.com","123456", listPhone);

        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.writeValue(new File("car.json"), log1);

        return "";
    }
}
