/**
 * 
 */
package com.stacksimplify.restservices.mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;


/**
 * @author Avi
 * UserMapper Interface with declaration of two methods
 *
 */

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	// Create mapper instance
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	// User Object (User to User UserMsDto)
	//@Mapping(source="email", target="emailaddress") // if only one attribute change
	@Mappings({
		@Mapping(source="email", target="emailaddress"),
		@Mapping(source="role", target="rolename")
	})
	UserMsDto userToUserMsDto(User user);
	
	// List of Users; List<User> to List<UserMsDto>
	List<UserMsDto> userToUserMsDtos(List<User> users);

}

