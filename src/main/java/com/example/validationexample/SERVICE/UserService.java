package com.example.validationexample.SERVICE;

import com.example.validationexample.DTO.UserRequest;
import com.example.validationexample.ENTITY.User;
import com.example.validationexample.EXCEPTION.UserNotFoundException;
import com.example.validationexample.REPOSITORY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest){
        User user = User.build(0,userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(),
                userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
        return repository.save(user);
    }


    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public User getUser(int id) throws UserNotFoundException {
        User user = repository.findByUserId(id);
        if(user != null){
            return user;
        }
        else{
            throw new UserNotFoundException("User Not Found with the id " +id);
        }
    }
}
