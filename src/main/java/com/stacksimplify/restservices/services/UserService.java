/**
 * 
 */
package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;
/**
 * @author Avi
 * Created Service layer; 
 * Not created separate Service interface class and Service implementation class for project simplification 
 */
@Service
public class UserService {

	// Autowire User repository
	@Autowired
	private UserRepository userRepository;
	
	//get all users method
	public List<User> getAllUsers(){
		return userRepository.findAll();		
	}
	
	//getUserById method
	public Optional<User> getUserById(Long id){
		//Optional container as user output may be null
		Optional<User> user = userRepository.findById(id); //userRepository.findById(id).isPresent();
		return user;
   //TODO check use of userRepository.getOne(id) method;
	}
	
	// createUser method to save new entry in H2 DB
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//updateUserById
	public User updateUserById(Long id, User user) {
		user.setId(id);
		userRepository.save(user);
		
		return user;
	}
	
	//deleteUserById
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);	
		}
	}	
	
	//getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
