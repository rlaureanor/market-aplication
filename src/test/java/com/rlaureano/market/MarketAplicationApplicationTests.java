package com.rlaureano.market;

import com.rlaureano.market.domain.User;
import com.rlaureano.market.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MarketAplicationApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	public void createUserTest() {
		User user = new User();
		user.setUserId(4);
		user.setName("Ana");
		user.setLastName("Laureano");
		user.setStatus("Activo");
		user.setPassword(bCryptPasswordEncoder.encode("ana.123"));
		User retorno = userRepository.save(user);

		assert (retorno.getPassword().equalsIgnoreCase(user.getPassword()));

	}

}
