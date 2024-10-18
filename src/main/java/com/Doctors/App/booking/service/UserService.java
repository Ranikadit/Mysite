package com.Doctors.App.booking.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Doctors.App.booking.entity.User;
import com.Doctors.App.booking.repository.UserRepository;

@Service
public class UserService 
{
@Autowired
private UserRepository userRepository;

public User saveUser(User user)
{
   return userRepository.save(user);
}
public User findById(int id)
{
   Optional<User>user=userRepository.findById(id);
   if(user.isEmpty())
   {
      throw new RuntimeException("user not found");
   }
      return user.get();
   
}
public List<User>findAll()
{
   return userRepository.findAll();
}
public User updateUser(User user)
{
   Optional<User>dbUser=userRepository.findById(user.getId());
   if(dbUser.isEmpty())
   {
      throw new RuntimeException("user not found");
   }
   User existingUser=dbUser.get();
   existingUser.setUsername(user.getUsername());
   existingUser.setEmail(user.getEmail());
   existingUser.setPassword(user.getPassword());
   return userRepository.save(existingUser);
   }
   public void deleteUser(int id)
   {
      Optional<User> dbUser=userRepository.findById(id);
      if (dbUser.isEmpty())
      {
         throw new RuntimeException("user not found"); 
      }
      userRepository.delete(dbUser.get());
   }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}

