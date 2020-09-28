package com.gabriellaxavier.desafioconcrete.repository;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhoneRepository extends JpaRepository<UserModel, UUID> {
}
