/**
 * Created repository that is similar to DTO objects
 */
package com.stacksimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stacksimplify.restservices.entities.User;

/**
 * @author Avi
 * This is an interface which extends JPA Repository as we need to add one more method which is not present; custom method
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
