package com.ntt.dtoConverter;

import com.ntt.dto.UserDTO;
import com.ntt.model.User;

public class DTOToEntityUser {
	
	public static User buildUserEntity(UserDTO userDTO) {
	
	User user = new User();
	
	//user.setUserId(userDTO.getUserId());
	user.setUserName(userDTO.getUserName());
	user.setPassword(userDTO.getPassword());
	user.setEmailId(userDTO.getEmailId());
	user.setIsAdmin("N");
	user.setAge(userDTO.getAge());
	user.setContactNumber(userDTO.getContactNumber());
	user.setCity(userDTO.getCity());
	user.setState(userDTO.getState());
	user.setPincode(userDTO.getPincode());
	
	return user;
	}
}
