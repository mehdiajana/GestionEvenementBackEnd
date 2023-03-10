package gestion.evenement;

import gestion.evenement.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import gestion.evenement.model.Role;
import gestion.evenement.model.User;

import java.util.Date;

@SpringBootApplication
public class GestionEvenementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEvenementsApplication.class, args);

	}
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService)
	{
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			Date date = new Date();
			//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			//date = formatter.format(date)

			userService.saveUser(new User(0L,"Ajana","mehdiajana","Mehdi","mehdi5ajana@gmail.com","1234" ));
			userService.saveUser(new User(0L,"Slimani","sanaaslimani","sanaa","slimaniii@gmail.com","000000" ));

			userService.addRoleToUser("mehdiajana","ROLE_ADMIN");
			userService.addRoleToUser("mehdiajana","ROLE_USER");
			userService.addRoleToUser("sanaaslimani","ROLE_USER");
		};
	}

}


