package com.learning.restAPI.restful_web_service.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.restAPI.restful_web_service.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
