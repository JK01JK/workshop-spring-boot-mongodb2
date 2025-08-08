package com._jk01.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._jk01.workshopmongo.domain.Post;
import com._jk01.workshopmongo.repository.PostRepository;
import com._jk01.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> maybeUser = repo.findById(id);
		Post post = maybeUser.orElse(null);
		if(post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}

	
}
