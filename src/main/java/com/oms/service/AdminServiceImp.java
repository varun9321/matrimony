package com.oms.service;

import java.awt.Robot;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.Remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oms.dao.UserDetailsDao;
import com.oms.entity.Role;
import com.oms.entity.User;
import com.oms.repository.RoleRepository;
import com.oms.repository.UserRepository;
import com.oms.security.SecurityConfig;
import scala.annotation.meta.setter;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private UserRepository usr;

	@Autowired
	private RoleRepository rol;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return usr.findUserByEmail(email);
	}

	/*public void saveUsers(){
		Role r = rol.findByroleName("ROLE_ADMIN");
		User u = new User();
		u.setName("varun3");
		u.setEmail("varun93213@gmail.com");
		u.setPassword("password3");
		u.getRoles().add(r);
		usr.save(u);
	}*/

	public Iterable<User> findAllUsers(){
		usr.findAll();
		return usr.findAll();
	}

	@Override
	public ArrayList<String> findAllRoles() {
		return SecurityConfig.roles;
	}

	@Override
	public void saveUsers(UserDetailsDao usrdao) {
		// TODO Auto-generated method stub

		File convFile = new File(usrdao.getFile().getOriginalFilename());
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(usrdao.getFile().getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		Role r = new Role();
		r.setRoleName(usrdao.getRoles());
		User u = new User();
		u.setName(usrdao.getName());
		u.setEmail(usrdao.getEmail());
		u.setPassword(usrdao.getPassword());
		u.getRoles().add(r);
		System.out.println(usrdao.getName() + " " + usrdao.getEmail() + "" +usrdao.getPassword()+ "" +usrdao.getRoles());
		usr.save(u);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		User u =usr.findUserById(id);
		usr.delete(u);
		rol.deleteById(id);


	}
}
