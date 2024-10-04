package com.connectdb.Controller;

import com.connectdb.Entity.User;
import com.connectdb.Service.UserService;
import com.connectdb.dto.request.UserCreationRequets;
import com.connectdb.dto.request.UserUpdateRequets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    User CreateUser(@RequestBody UserCreationRequets request){
      return userService.CreateUser(request);
    }
    @GetMapping
    List<User> GetUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
        User getUsers(@PathVariable("userId") String userId ){
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser( @PathVariable String userId,@RequestBody UserUpdateRequets request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "Xoa thanh cong !!";
    }
}
