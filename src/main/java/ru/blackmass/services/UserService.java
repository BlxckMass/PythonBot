package ru.blackmass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blackmass.entities.User;
import ru.blackmass.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private FlagService flagService;

    @Autowired
    public UserService(UserRepository userRepository, FlagService flagService) {
        this.userRepository = userRepository;
        this.flagService = flagService;
    }

    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsersTopBalance() {
        return userRepository.findTop10ByOrderByBalanceDesc();
    }

    public List<User> getUsersTopCountClick() {
        return userRepository.findTop10ByOrderByCountClickDesc();
    }

    public List<User> getUsersTopLevel() {
        return userRepository.findTop10ByOrderByLvlDescExpDesc();
    }

}
