package com.gabriellaxavier.desafioconcrete;

import com.gabriellaxavier.desafioconcrete.models.CadastroModel;
import com.gabriellaxavier.desafioconcrete.models.PhoneModel;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DesafioJavaApiApplication implements CommandLineRunner {

	//@Autowired
	//private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*List<PhoneModel> listPhone = new ArrayList<>();
		listPhone.add(new PhoneModel("81", "995784030"));

		CadastroModel cad1 = new CadastroModel(null,"gabriella","gabriella@teste.com","",listPhone);

		userRepo.save(cad1);*/

	}
}
