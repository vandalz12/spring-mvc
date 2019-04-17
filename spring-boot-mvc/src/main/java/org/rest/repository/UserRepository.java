package org.rest.repository;

import org.rest.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
	
}
