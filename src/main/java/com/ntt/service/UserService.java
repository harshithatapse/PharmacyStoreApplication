package com.ntt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ntt.dto.UserDTO;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Product;
import com.ntt.model.User;

public interface UserService {
	
	public List<UserDTO> getAllUsers();
	
	public UserDTO createUser(User user);

	public Optional<User> getUserById(long id);

	public String validateUser(String userName, String password) throws UserNotFoundException;

	public UserDTO updateUsers(long UserId, User userDetails) throws UserNotFoundException;

}
