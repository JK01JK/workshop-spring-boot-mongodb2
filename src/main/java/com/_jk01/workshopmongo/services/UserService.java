package com._jk01.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._jk01.workshopmongo.domain.User;
import com._jk01.workshopmongo.dto.UserDTO;
import com._jk01.workshopmongo.repository.UserRepository;
import com._jk01.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> maybeUser = repo.findById(id);
		User user = maybeUser.orElse(null);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),  objDto.getName(), objDto.getEmail());
	}
	
}
