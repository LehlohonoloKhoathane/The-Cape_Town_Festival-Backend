package za.ac.uct;
/**
 * BackendApplication.java
 * This is the main class for the backend
 * Author: Lehlohonolo Khoathane
 * Date: 24/11/2023
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.uct.service.IUserService;
import za.ac.uct.domain.security.Role;
import za.ac.uct.domain.security.RoleName;
import za.ac.uct.domain.security.User;
import za.ac.uct.repository.IRoleRepository;
import za.ac.uct.repository.IUserRepository;
/*import za.ac.uct.domain.User;
import za.ac.uct.repository.UserRepository;
import za.ac.uct.service.impl.UserServiceImpl;*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner run(IUserService userService, IRoleRepository roleRepository, IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            List<RoleName> roleNames = Arrays.asList( RoleName.USER, RoleName.ADMIN, RoleName.SUPERADMIN);

            for (RoleName roleName : roleNames) {
                Role role = roleRepository.findByRoleName(roleName);

                if (role == null) {
                    userService.saveRole(new Role(roleName));

                    String email = roleName.toString().toLowerCase() + "@gmail.com";
                    String password = roleName.toString().toLowerCase() + "password";

                    userService.saverUser(new User(email, passwordEncoder.encode(password), new ArrayList<>()));

                    role = roleRepository.findByRoleName(roleName);
                    User user = (User) userRepository.findByEmail(email).orElse(null);

                    if (user != null) {
                        user.getRoles().add(role);
                        userService.saverUser(user);
                    }
                }
            }
        };
    }
}
