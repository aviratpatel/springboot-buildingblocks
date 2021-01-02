package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.EmpoyeeRepository;

/**
 * @author Avi
 * Created Service layer; 
 * Not created separate Service interface class and Service implementation class for project simplification 
 */
@Service
public class EmployeeService {

	// Autowire User repository
	@Autowired
	private EmpoyeeRepository employeeRepository;
	
	//get all users method
	public List<Employee> getAllUsers(){
		return employeeRepository.findAll();		
	}
	
	//getUserById method
	public Optional<Employee> getUserById(Long id) throws UserNotFoundException {
		//Optional container as user output may be null
		Optional<Employee> emp = employeeRepository.findById(id); //userRepository.findById(id).isPresent();
		
		if(!emp.isPresent()) {
			throw new UserNotFoundException("User is not found in user repository");
		}
		return emp;
   //TODO check use of userRepository.getOne(id) method;
	}
	
	// createUser method to save new entry in H2 DB
	public Employee createUser(Employee emp) throws UserExistsException {
		// Check if user exists using username
		Employee existingUser = employeeRepository.findByemail(emp.getEmail());
		
		// if not exists then, throw UserExistsException
		if(existingUser != null) {
			throw new UserExistsException("Employee already exists in Repository; Check your input body");
		}

		
		return employeeRepository.save(emp);
	}
	
	//updateUserById
	public Employee updateUserById(Long id, Employee emp) throws UserNotFoundException {
		Optional<Employee> optionalemp = employeeRepository.findById(id); //userRepository.findById(id).isPresent();
		
		if(!optionalemp.isPresent()) {
			throw new UserNotFoundException("User not found in user Repository, please provide correct user id");
		}
		
		emp.setEmpid(id);
		return employeeRepository.save(emp);
		
	}
	
	//deleteUserById
	public void deleteUserById(Long id) {
/* Old code when exception handling code was not written
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);	
		}
*/
		Optional<Employee> optionalemp = employeeRepository.findById(id); //userRepository.findById(id).isPresent();
		
		if(!optionalemp.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete User because it is not found in user Repository, please provide correct user id");
		}
		
		employeeRepository.deleteById(id);
	}	
	
}
