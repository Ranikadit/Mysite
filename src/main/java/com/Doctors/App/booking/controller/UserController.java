package com.Doctors.App.booking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Doctors.App.booking.entity.User;
import com.Doctors.App.booking.service.UserService;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React app running on port 3000

public class UserController
{

@Autowired
private UserService userService;

@PostMapping("/save")
public User  save(@RequestBody User user)
 {
    return userService.saveUser(user);
}

@GetMapping("/finAll")
@CrossOrigin(origins = "http://localhost:3000")
public List<User> findAll() {
    return userService.findAll();
}



@GetMapping("/findById/{id}")
public User findById(@PathVariable int id) {
    return userService.findById(id);  // Corrected findById spelling and method signature
}



@PutMapping("update")
public User update(@RequestBody User user) {
    return userService.updateUser(user);  // Return updated user
}


@DeleteMapping
public void delete(@RequestParam int id) {
    userService.deleteUser(id);
}
}



