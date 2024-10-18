package com.Doctors.App.booking.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Doctors.App.booking.entity.User;
public interface UserRepository extends  JpaRepository<User,Integer>
{

}

