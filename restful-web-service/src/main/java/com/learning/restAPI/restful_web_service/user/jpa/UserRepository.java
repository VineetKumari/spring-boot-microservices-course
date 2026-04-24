package com.learning.restAPI.restful_web_service.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.restAPI.restful_web_service.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
