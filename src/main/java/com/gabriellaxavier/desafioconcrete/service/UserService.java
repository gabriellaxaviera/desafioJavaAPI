package com.gabriellaxavier.desafioconcrete.service;

import com.gabriellaxavier.desafioconcrete.dto.LoginDTO;
import com.gabriellaxavier.desafioconcrete.dto.PerfilDTO;
import com.gabriellaxavier.desafioconcrete.error.EmailExistsException;
import com.gabriellaxavier.desafioconcrete.error.UnauthorizedException;
import com.gabriellaxavier.desafioconcrete.error.ResourceNotFoundException;
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

    public UserModel find(UUID id){

        UserModel obj = repo.findById(id);
        if(obj != null)
        {
        return obj;
        }

        else
        {
            throw new ResourceNotFoundException("Usuário nao encontrado");
        }
    }

    public UserModel profile(PerfilDTO perfilDTO){

        UserModel user = repo.findByToken(perfilDTO.getToken());

        if (user != null)
        {
            UserModel userId = repo.findById(perfilDTO.getId());

            if (userId != null)
            {
                if (userId.getToken().equals(perfilDTO.getToken()))
                {
                    perfilDTO.setLast_login(LocalDateTime.now());

                    Integer userH = user.getLast_login().getHour();
                    Integer perfilH = perfilDTO.getLast_login().getHour();
                    Integer diffH = perfilH-userH;

                    Integer userM = user.getLast_login().getMinute();
                    Integer perfilM = perfilDTO.getLast_login().getMinute();
                    Integer diffM = perfilM-userM;

                    if (diffH == 0 && diffM <= 30 )
                    {
                        return user;
                    }
                    else
                    {
                        throw new UnauthorizedException("Sessão Inválida");
                    }

                }
                else
                {
                    throw new UnauthorizedException("Não autorizado");
                }
            }
            else
            {
                throw new UnauthorizedException("Usuário inexistente");
            }

        }
        else
        {
            throw new UnauthorizedException("Nao autorizado");
        }
    }

    public UserModel insert(UserModel user) {

        UserModel userCad = repo.findByEmail(user.getEmail());

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
            throw new EmailExistsException("Email já existente");
        }
    }

    public UserModel login(LoginDTO loginDTO) {

        UserModel user = repo.findByEmail(loginDTO.getEmail());

        if (user != null)
        {
            user.getEmail();
            loginDTO.getEmail();

            loginDTO.setPassword(Hashing.sha256()
                    .hashString(loginDTO.getPassword(), StandardCharsets.UTF_8)
                    .toString());

            if (user.getPassword().equals(loginDTO.getPassword()))
            {
                user.setLast_login(LocalDateTime.now());
                repo.save(user);
                return user;
            }
            else
            {
                throw new UnauthorizedException("Usuário e/ou senha inválidos");
            }
        }
        else
        {
            throw new ResourceNotFoundException("Usuário e/ou senha inválidos");
        }
    }

}
