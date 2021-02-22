package com.ntt.entityConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ntt.dto.UserDTO;
import com.ntt.model.User;

public class DTOUtilUser {
	
	public static UserDTO buildUserDTO (User user)
	{
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setUserName(user.getUserName());
		userDTO.setPassword(user.getPassword());
		userDTO.setIsAdmin(user.getIsAdmin());
		userDTO.setEmailId(user.getEmailId());
		userDTO.setContactNumber(user.getContactNumber());
		userDTO.setCity(user.getCity());
		userDTO.setState(user.getState());
		userDTO.setPincode(user.getPincode());
		
		return userDTO;
	}
	
	public static List<UserDTO> buildUserDTOList (List<User> users)
	{
		
		return users.stream().map(al->buildUserDTO(al)).collect(Collectors.toList());
		}
	
		/*
		 * List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		 * 
		 * for(User user : users) { UserDTO userDTO = new UserDTO();
		 * 
		 * userDTO.setUserId(user.getUserId()); userDTO.setUserName(user.getUserName());
		 * userDTO.setPassword(user.getPassword());
		 * userDTO.setIsAdmin(user.getIsAdmin()); userDTO.setEmailId(user.getEmailId());
		 * userDTO.setContactNumber(user.getContactNumber());
		 * userDTO.setCity(user.getCity()); userDTO.setState(user.getState());
		 * userDTO.setPincode(user.getPincode());
		 * 
		 * userDTOList.add(userDTO); }
		 */
		
		//return userDTOList;

}
