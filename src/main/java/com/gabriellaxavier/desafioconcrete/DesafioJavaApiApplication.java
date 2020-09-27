package com.gabriellaxavier.desafioconcrete;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.models.PhoneModel;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DesafioJavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaApiApplication.class, args);
	}

}
