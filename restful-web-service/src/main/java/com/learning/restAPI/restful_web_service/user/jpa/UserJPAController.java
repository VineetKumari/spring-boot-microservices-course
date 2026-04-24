package com.learning.restAPI.restful_web_service.user.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.restAPI.restful_web_service.user.Post;
import com.learning.restAPI.restful_web_service.user.User;
import com.learning.restAPI.restful_web_service.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserJPAController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(path="/jpa/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}

	@GetMapping(path="/jpa/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id)
	{
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		User newUser=userRepository.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		userRepository.delete(user.get());
	}

	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post> getAllPostsByUser(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		return user.get().getPosts();
	}
	
	@PostMapping(path="/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPost(@Valid @RequestBody Post post,@PathVariable int id)
	{
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		post.setUser(user.get());
		Post savedPost=postRepository.save(post);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{post_id}").buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/jpa/users/{id}/posts/{post_id}")
	public Post getPostDetails(@PathVariable int post_id)
	{
		Optional<Post> post = postRepository.findById(post_id);
		return post.get();
	}
}
