package com.ntt.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ntt.dto.UserDTO;
import com.ntt.entityConverter.DTOUtilUser;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Product;
import com.ntt.model.User;
import com.ntt.repository.ProductRepository;
import com.ntt.repository.UserRepository;
import com.ntt.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository usersRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public List<UserDTO> getAllUsers() {
		return DTOUtilUser.buildUserDTOList(usersRepository.findAll());
	}

	@Override
	public UserDTO createUser(@Validated @RequestBody User user) {
		//user.setIsAdmin("N");
		log.info("UserServiceImpl:createUser for " +user.getUserName());
		User usersaved = usersRepository.save(user);
		if(Objects.isNull(usersaved))
		{
			log.error(" Error : Error in Saving the User Details");
			throw new UserNotFoundException("Error in Saving the User Details for the User Name :: " + user.getUserName());
		}
		return modelMapper.map(usersaved, UserDTO.class);
		//return DTOUtilUser.buildUserDTO(usersRepository.save(user));
	}
	
	@Override
	public Optional<User> getUserById(long id) {
		return usersRepository.findById(id);
	}
	
	@Override
	public UserDTO updateUsers(long UserId, User userDetails) throws UserNotFoundException {
		log.info("UserServiceImpl:updateUsers for " +UserId);
		User user = usersRepository.findById(UserId)
				.orElseThrow(() -> new UserNotFoundException("User not found for this id :: " + UserId));
		user.setUserName(userDetails.getUserName());
		user.setPassword(userDetails.getPassword());
		user.setIsAdmin(userDetails.getIsAdmin());
		user.setEmailId(userDetails.getEmailId());
		user.setAge(userDetails.getAge());
		user.setContactNumber(userDetails.getContactNumber());
		user.setCity(userDetails.getCity());
		user.setState(userDetails.getState());
		user.setPincode(userDetails.getPincode());
		User usersaved = usersRepository.save(user);
		return modelMapper.map(usersaved, UserDTO.class);
	}
	
	@Override
	public String validateUser(String userName, String password) throws UserNotFoundException {
		log.debug("UserServiceImpl:validateUser for " +userName);
		log.info("UserServiceImpl:validateUser for " +userName);
			User user=usersRepository.findByUserNameAndPassword(userName,password);
			if(Objects.isNull(user))
			{
				log.error(" Error : Enter correct User Credentials");
				throw new UserNotFoundException("User not found for this User Name :: " + userName);
			}
			
			return "User Successfully Logged In!!!";
		}

	}

