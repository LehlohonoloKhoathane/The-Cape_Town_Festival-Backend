package za.ac.uct.service.impl;
/*
package za.ac.uct.service.impl;
*/
/**
 *
 * Author: Peter Buckingham (220165289)
 *
 *//*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.uct.domain.User;
import za.ac.uct.factory.impl.UserFactory;
import za.ac.uct.repository.UserRepository;
import za.ac.uct.service.IUserService;

import java.util.ArrayList;
import java.util.Optional;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
    private UserRepository repository = null;
    private UserFactory userFactory;

    @Autowired
    private UserServiceImpl(UserRepository repository, UserFactory userFactory) {
        this.repository = repository;
        this.userFactory = userFactory;
    }


    @Override
    public User create(User user) {
        User newUser = userFactory.create(user);
        return repository.save(newUser);
    }


    @Override
    public User read(Integer id) {
        Optional<User> optionalUser = this.repository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User update(User user) {
        if (repository.existsById(user.getId())) {
            User updatedUser = userFactory.create(user);
            return repository.save(updatedUser);
        }
        return null;
    }


    @Override
    public boolean delete(Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
        return (ArrayList<User>) this.repository.findAll();
    }


}
*/
