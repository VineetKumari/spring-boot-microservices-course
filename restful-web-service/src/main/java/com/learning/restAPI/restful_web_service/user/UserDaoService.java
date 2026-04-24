package com.learning.restAPI.restful_web_service.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users= new ArrayList<>();
	private static int userCount=0;
	static {
		users.add(new User(++userCount,"Ram",LocalDate.now().minusYears(20)));
		users.add(new User(++userCount,"Sham",LocalDate.now().minusYears(19)));
		users.add(new User(++userCount,"Radha",LocalDate.now().minusYears(18)));
	}
	
	  public User findOne(Integer id) {
	  return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
	  }
	 
	
	public List<User> findAll(){
		return users;
	}

	
	  public User save(User user) {
	  user.setId(++userCount);
	  users.add(user);
	  return user;
	  }


	  public void deleteUser(int id) {
		// TODO Auto-generated method stub
		  users.removeIf(user->user.getId()==id);
		
	  }
	 
}
