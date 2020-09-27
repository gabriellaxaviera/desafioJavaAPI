package com.gabriellaxavier.desafioconcrete.service;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Optional<UserModel> find(String id){

        Optional<UserModel> obj = repo.findById(id);
        return obj;
    }

    public UserModel insert(UserModel obj) {
        String sha256hex = Hashing.sha256()
                .hashString(obj.getPassword(), StandardCharsets.UTF_8)
                .toString();

        LocalDateTime localDateTime = LocalDateTime.now();

        obj.setPassword(sha256hex);
        obj.setCreated(localDateTime);
        obj.setLast_login(localDateTime);
        obj.setModified(localDateTime);

        return repo.save(obj);
    }

    public UserModel update(UserModel obj) {

        LocalDateTime localDateTime = LocalDateTime.now();
        obj.setLast_login(localDateTime);

        return repo.save(obj);
    }
}
