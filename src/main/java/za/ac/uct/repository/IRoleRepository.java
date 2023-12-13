package za.ac.uct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.uct.domain.security.Role;
import za.ac.uct.domain.security.RoleName;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role,Integer> {

    Role findByRoleName(RoleName roleName);
    //get all roles


    @Override
    List<Role> findAll();
}
