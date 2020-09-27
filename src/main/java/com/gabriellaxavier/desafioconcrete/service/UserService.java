package com.gabriellaxavier.desafioconcrete.service;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Optional<UserModel> buscar(String id){

        Optional<UserModel> obj = repo.findById(id);
        return obj;
    }
}
