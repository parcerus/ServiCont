package com.ServiCont.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ServiCont.entities.User;
import com.ServiCont.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;


    
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createUser(User newUser){
        return this.userRepository.save(newUser);
    }

    public User findUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public User getOrCreateUser(Map<String, Object>userData){

        String email = (String) userData.get("email");

        User user= this.findUserByEmail(email);
        if(user == null){
            String name = (String) userData.get("nickname");
            String image = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");
    
            User newUser= new User(email=email, image=image, auth0Id=auth0Id);
            return createUser(newUser);
        }
    
        return user;


    }


}
