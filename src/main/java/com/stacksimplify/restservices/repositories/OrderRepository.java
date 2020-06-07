/**
 * 
 */
package com.stacksimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stacksimplify.restservices.entities.Order;

/**
 * @author Avi
 * Interface to create an order
 * We want to perform operations onto Order entity and primary key is id; so define type as Long for that key 
 */

@Repository // import org.springframework.stereotype.Repository package
public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
