package com.gabriellaxavier.desafioconcrete.repository;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    Optional<UserModel> findById(String id);

    /*Optional<UserModel> List<UserModel> findByPassword(String password); */
}
