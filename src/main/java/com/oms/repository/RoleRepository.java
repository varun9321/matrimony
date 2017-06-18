package com.oms.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.oms.entity.Role;


@Transactional
public interface RoleRepository extends JpaRepository<Role, Serializable>
{
	Role findByroleName(String name);
	void deleteById(int id);
	Role findRoleById(int id);
}