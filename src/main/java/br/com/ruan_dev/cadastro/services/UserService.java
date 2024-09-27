package br.com.ruan_dev.cadastro.services;

import br.com.ruan_dev.cadastro.entites.User;
import br.com.ruan_dev.cadastro.repostirories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final View error;

    @Autowired
    public UserService(UserRepository userRepository, View error) {
        this.userRepository = userRepository;
        this.error = error;
    }


    public User insert(User user) {
        User userSave = userRepository.save(user);
        return userSave;
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public List<User> findUser() {
        return userRepository.findAll();
    }

    public Optional<User> findUserByEmail(String email) {
        List<User> users = userRepository.findAll();
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
}
