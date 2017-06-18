package com.oms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.oms.dao.UserDetailsDao;
import com.oms.entity.Role;
import com.oms.entity.User;

public interface AdminService {

	public User findUserByEmail(String email);
	public void saveUsers(UserDetailsDao usrdao);
	public Iterable<User> findAllUsers();
	public ArrayList<String> findAllRoles();
	public void deleteById(int id);
//	public void saveUsers();
}
