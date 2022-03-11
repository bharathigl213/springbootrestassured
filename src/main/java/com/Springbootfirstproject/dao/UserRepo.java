package com.Springbootfirstproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springbootfirstproject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
