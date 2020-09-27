package com.gabriellaxavier.desafioconcrete;

import com.gabriellaxavier.desafioconcrete.models.UserModel;
import com.gabriellaxavier.desafioconcrete.models.PhoneModel;
import com.gabriellaxavier.desafioconcrete.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DesafioJavaApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<PhoneModel> listPhone = new ArrayList<>();
		listPhone.add(new PhoneModel("81", "995784030"));

		UserModel cad1 = new UserModel(null,"gabriella","gabriella@teste.com","123456teste",null);

		String sha256hex = Hashing.sha256()
				.hashString(cad1.getPasswd(), StandardCharsets.UTF_8)
				.toString();

		cad1.setPasswd(sha256hex);
		cad1.setPhone(listPhone);

		userRepo.save(cad1);

	}
}
