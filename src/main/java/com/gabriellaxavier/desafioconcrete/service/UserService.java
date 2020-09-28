package com.gabriellaxavier.desafioconcrete.service;

import com.gabriellaxavier.desafioconcrete.dto.LoginDTO;
import com.gabriellaxavier.desafioconcrete.models.PhoneModel;
import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.repository.PhoneRepository;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PhoneRepository phoneRepo;

    public Optional<UserModel> find(String id){

        Optional<UserModel> obj = repo.findById(id);
        return obj;
    }

    public UserModel insert(UserModel user) {

        UserModel obj = new UserModel();
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setToken(user.getToken());

        String sha256hex = Hashing.sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString();

        LocalDateTime localDateTime = LocalDateTime.now();

        obj.setPassword(sha256hex);
        obj.setCreated(localDateTime);
        obj.setLast_login(localDateTime);
        obj.setModified(localDateTime);

        for (PhoneModel phone: user.getPhones()) {

            PhoneModel objPhone = phone;
            objPhone.setUser(obj);
            obj.getPhones().add(objPhone);
        }

        return repo.save(obj) ;
    }

    public Optional<UserModel> login(LoginDTO loginDTO) {

        loginDTO.setPassword(Hashing.sha256()
                .hashString(loginDTO.getPassword(), StandardCharsets.UTF_8)
                .toString());

        return repo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
    }
}
