package com.gabriellaxavier.desafioconcrete.service;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Optional<UserModel> buscar(String id){

        Optional<UserModel> obj = repo.findById(id);
        return obj;
    }

    public UserModel insert(UserModel obj) {
        String sha256hex = Hashing.sha256()
                .hashString(obj.getPasswd(), StandardCharsets.UTF_8)
                .toString();

        obj.setPasswd(sha256hex);

        return repo.save(obj);
    }
}
