package com.gabriellaxavier.desafioconcrete.service;

import com.gabriellaxavier.desafioconcrete.models.CadastroModel;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public CadastroModel buscar(String id){

        CadastroModel obj = repo.getOne(id);
        return obj;
    }
}
