package com.jasonz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jasonz.entities.ApplicationUser;

public interface IApplicationUserRepository extends JpaRepository<ApplicationUser, Long>
{
	public ApplicationUser findById(long id);
	
	public ApplicationUser findByUsername(String username);
	
	public ApplicationUser findByEmail(String email);
	
}