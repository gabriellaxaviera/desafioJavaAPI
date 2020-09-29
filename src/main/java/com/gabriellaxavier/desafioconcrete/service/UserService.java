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
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public UserModel profile(PerfilDTO perfilDTO){

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
                perfilDTO.setLast_login(LocalDateTime.now());

                //verificar hora aqui
                Integer userH = userId.getLast_login().getHour();
                Integer perfilH = perfilDTO.getLast_login().getHour();
                Integer diffH = perfilH-userH;
                System.out.println(diffH);

                Integer userM = userId.getLast_login().getMinute();
                Integer perfilM = perfilDTO.getLast_login().getMinute();
                Integer diffM = perfilM-userM;
                System.out.println(diffM);

                if (diffH == 0)
                {
                    if (diffM >= 30)
                    {
                        System.out.println("SESSAO INVALIDA");
                    }
                }
                else
                {
                    System.out.println("SESSÃO INVALIDA");
                }

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

        UserModel userCad = repo.findByEmail(user.getEmail());
        System.out.println(userCad);

        if (userCad == null) {

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

            for (PhoneModel phone : user.getPhones()) {

                PhoneModel objPhone = phone;
                objPhone.setUser(obj);
                obj.getPhones().add(objPhone);
            }
            return repo.save(obj);
        }
        else
        {
            System.out.println("EMAIL JA CADASTRADO");
        }
        return null;
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
