package com.springbootmvc.a5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootmvc.a5.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByUserRole(String source);

}
