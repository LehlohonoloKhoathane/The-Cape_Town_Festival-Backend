package za.ac.uct.service;
/**
 *
 * Author: Peter Buckingham (220165289)
 *
 */


import org.springframework.http.ResponseEntity;
import za.ac.uct.domain.dto.LoginDto;
import za.ac.uct.domain.dto.RegisterDto;
import za.ac.uct.domain.security.Role;
import za.ac.uct.domain.security.User;

import java.util.List;


public interface IUserService {


   String authenticate(LoginDto loginDto);
   ResponseEntity<?> register (RegisterDto registerDto);
   Role saveRole(Role role);

   User saverUser (User user) ;
   List<User> getAll();
    User read(Integer id);
    User update(Integer id, User user);
}
