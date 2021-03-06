package io.oneko.user.rest;

import org.springframework.stereotype.Service;

import io.oneko.user.User;

@Service
public class UserDTOMapper {

	public UserDTO userToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setUuid(user.getUuid());
		dto.setUsername(user.getUserName());
		dto.setEmail(user.getEmail());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setRole(user.getRole());//wtf?
		return dto;
	}

	public User updateUserFromDTO(User user, UserDTO userDTO) {
		//id can not be changed
		user.setUserName(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUserName(userDTO.getUsername());
		user.setRole(userDTO.getRole());
		return user;
	}

}
