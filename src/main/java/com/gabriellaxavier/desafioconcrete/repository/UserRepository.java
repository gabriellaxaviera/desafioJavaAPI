package com.gabriellaxavier.desafioconcrete.repository;

import com.gabriellaxavier.desafioconcrete.models.PhoneModel;
import com.gabriellaxavier.desafioconcrete.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    UserModel findById(UUID id);

    UserModel findByEmail(String email);

    UserModel findByToken(UUID token);

}
