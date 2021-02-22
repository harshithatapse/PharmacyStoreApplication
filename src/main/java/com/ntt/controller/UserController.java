package com.ntt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.dto.UserDTO;
import com.ntt.dtoConverter.DTOToEntityUser;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Product;
import com.ntt.model.User;
import com.ntt.repository.UserRepository;
import com.ntt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsers();	
	}
	
	@PostMapping("/")
	public UserDTO createUser(@Validated @RequestBody UserDTO userDTO){
		User user = DTOToEntityUser.buildUserEntity(userDTO);
		return userService.createUser(user);
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUsersById(@PathVariable long id) throws UserNotFoundException{
		return userService.getUserById(id);
		
	}
	
	@PutMapping("/{id}")
	public UserDTO updateUsers(@PathVariable(value = "id") long UserId , @RequestBody User userDetails)throws UserNotFoundException{
		return userService.updateUsers(UserId,userDetails);
		
	} 
	
	@GetMapping("/{userName}/{password}")
	public String validateUser(@PathVariable String userName, @PathVariable String password) throws UserNotFoundException
	{
		return userService.validateUser(userName,password);
	}
	
}


