package com.spring.start.z_startup.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.start.z_startup.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	User findByName(String Name);
	@EntityGraph(value = "users.permissions", type = EntityGraphType.LOAD)
	Optional<User> getById(int id);

}
