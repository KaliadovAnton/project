package com.anton.service;

import com.anton.model.User;
import com.anton.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getListOfUsers(){
        return userRepository.getAllUsers();
    }

    public void deleteUser(Long id){
        userRepository.deleteUser(id);
    }

    public void addUser(User user){
        userRepository.addUser(user);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(()-> new NoResultException("Theres no user with id "+id));
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }


}
