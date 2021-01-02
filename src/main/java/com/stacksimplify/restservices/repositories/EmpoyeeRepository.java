/**
 * 
 */
package com.stacksimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stacksimplify.restservices.entities.Employee;

/**
 * @author Avi
 *  * Interface to create new user
 * This is an interface which extends JPA Repository as we need to add one more method which is not present; custom method
 */
@Repository
public interface EmpoyeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findByemail(String email);

}
