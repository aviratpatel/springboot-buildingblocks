/**
 * 
 */
package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
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
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		//Optional container as user output may be null
		Optional<User> user = userRepository.findById(id); //userRepository.findById(id).isPresent();
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found in user repository");
		}
		return user;
   //TODO check use of userRepository.getOne(id) method;
	}
	
	// createUser method to save new entry in H2 DB
	public User createUser(User user) throws UserExistsException {
		// Check if user exists using username
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		// if not exists then, throw UserExistsException
		if(existingUser != null) {
			throw new UserExistsException("User already exists in Repository; Check your input body");
		}

		
		return userRepository.save(user);
	}
	
	//updateUserById
	public User updateUserById(Long id, User user) throws UserNotFoundException {
		Optional<User> optionaluser = userRepository.findById(id); //userRepository.findById(id).isPresent();
		
		if(!optionaluser.isPresent()) {
			throw new UserNotFoundException("User not found in user Repository, please provide correct user id");
		}
		
		user.setId(id);
		return userRepository.save(user);
		
	}
	
	//deleteUserById
	public void deleteUserById(Long id) {
/* Old code when exception handling code was not written
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);	
		}
*/
		Optional<User> optionaluser = userRepository.findById(id); //userRepository.findById(id).isPresent();
		
		if(!optionaluser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete User because it is not found in user Repository, please provide correct user id");
		}
		
		userRepository.deleteById(id);
	}	
	
	//getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
