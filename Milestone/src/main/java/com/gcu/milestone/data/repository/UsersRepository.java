package com.gcu.milestone.data.repository;

import com.gcu.milestone.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long>
{
	UserEntity findByUsername(String username);
}
