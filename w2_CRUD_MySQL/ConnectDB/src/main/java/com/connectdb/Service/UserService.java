package com.connectdb.Service;

import com.connectdb.Entity.User;
import com.connectdb.Repository.UserRepository;
import com.connectdb.dto.request.UserCreationRequets;
import com.connectdb.dto.request.UserUpdateRequets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    public User CreateUser(UserCreationRequets request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());
        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUserById(String id){
        return userRepo.findById(id).
                orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User updateUser(String UserId, UserUpdateRequets request){
        User user = getUserById(UserId);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());
        return userRepo.save(user);
    }

    public void deleteUser(String UserId){
        userRepo.deleteById(UserId);
    }
}
