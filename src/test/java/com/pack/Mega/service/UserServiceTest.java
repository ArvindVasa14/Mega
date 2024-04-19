package com.pack.Mega.service;

import com.pack.Mega.model.User;
import com.pack.Mega.repository.UserRepository;
import com.pack.Mega.service.UserService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addUserTest_Returns_User(){
        User user=new User();
        user.setUserName("ramu");
        when(userRepository.save(user)).thenReturn(user);
        User user1=userService.addUser(user);
        assertEquals(user1,user);
    }

    @Test
    public void getUsersTest_Returns_ListofUsers(){
        User user=new User();
        user.setUserName("ramu");
        User user1=new User();
        user.setUserName("Nithin");
        List<User> users1= new ArrayList<>();
        users1.add(user);
        users1.add(user1);
        when(userRepository.findAll()).thenReturn(users1);
        List<User> users =userService.getUsers();
        assertEquals(users1,users);
    }

    @Test
    public void getUserTest_Returns_User(){
        User user=new User();
        user.setUserName("ramu");
        int userId=1;
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User user1=userService.getUser(userId);
        assertEquals(user,user1);
    }

    @Test
    public void ddUsers_Returns_ListUsers() {
        User user=new User();
        user.setUserName("ramu");
        User user1=new User();
        user.setUserName("Nithin");
        List<User> users2= new ArrayList<>();
        users2.add(user);
        users2.add(user1);
        when(userRepository.saveAll(users2)).thenReturn(users2);

        List<User> rusers=userService.addUsers(users2);
        assertEquals(users2,rusers);
    }


}
