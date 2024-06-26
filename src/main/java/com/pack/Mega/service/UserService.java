package com.pack.Mega.service;
import com.pack.Mega.model.User;
import com.pack.Mega.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(int userId){
        Optional<User> userOptional= userRepository.findById(userId);
        User user  = new User();
        if(userOptional.isPresent())
             user = userOptional.get();

        return user;
    }

    public List<User> addUsers(List<User> users) {
        return userRepository.saveAll(users);
    }
}
