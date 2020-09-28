package com.gabriellaxavier.desafioconcrete.service;

import com.gabriellaxavier.desafioconcrete.controllers.Perfil;
import com.gabriellaxavier.desafioconcrete.dto.LoginDTO;
import com.gabriellaxavier.desafioconcrete.dto.PerfilDTO;
import com.gabriellaxavier.desafioconcrete.models.PhoneModel;
import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.repository.PhoneRepository;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PhoneRepository phoneRepo;

    public UserModel find(UUID id){

        UserModel obj = repo.findById(id);
        return obj;
    }

    public UserModel perfil(PerfilDTO perfilDTO){

        UserModel user = repo.findByToken(perfilDTO.getToken());

        System.out.print("HEADER REQ ");
        System.out.println(perfilDTO.getToken()); //HEADER
        System.out.print("HEADER BANCO ");
        System.out.println(user.getToken()); //BANCO

        if (user != null)
        {
            UserModel userId = repo.findById(perfilDTO.getId());

            if (userId.getToken().equals(perfilDTO.getToken()))
            {
                System.out.println("TOKENS IGUAIS ");

                long diff = ChronoUnit.MINUTES.between(userId.getLast_login(),perfilDTO.getLast_login());
            }
            else
            {
                System.out.println("NAO AUTORIZADO TOKEN DIFERENTE");
            }

        }
        else
        {
            System.out.println("NÃO AUTORIZADO");
            return null;
        }
        return null;
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

    public UserModel login(LoginDTO loginDTO) {

        UserModel user = repo.findByEmail(loginDTO.getEmail());
        System.out.println(user);

        if (user != null) //se existe no banco
        {
            user.getEmail();
            loginDTO.getEmail();

            loginDTO.setPassword(Hashing.sha256()
                    .hashString(loginDTO.getPassword(), StandardCharsets.UTF_8)
                    .toString());

            if (user.getPassword().equals(loginDTO.getPassword()))
            {
                System.out.println("senhas iguais");
                System.out.println(user.getPassword());
                System.out.println(loginDTO.getPassword());
                return repo.findByEmail(loginDTO.getEmail());
            }
            else
            {
                System.out.println("senhas diferentes");
                System.out.println(user.getPassword());
                System.out.println(loginDTO.getPassword());
                return user = null;
            }

        }
        else
        {
            System.out.println("Email nao existe");
            return user;
        }
    }

}
