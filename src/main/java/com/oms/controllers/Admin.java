package com.oms.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.oms.Inter;
import com.oms.dao.UserDetailsDao;
import com.oms.entity.User;
import com.oms.service.AdminService;
import com.oms.validators.UserDetailsDaoValidator;


@Controller("admin")
public class Admin {

	@Autowired
	AdminService admServ;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminLogin(Model model) {
		model.addAttribute("users",admServ.findAllUsers());
		return "users";
	}

	@RequestMapping(value="/admin/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/admin";
	}

	@RequestMapping(value="/admin/usersupdated", method = RequestMethod.GET)
	public String userUpdated (Model model, @RequestParam("id") String id) {
		int i = Integer.parseInt(id);
		admServ.deleteById(i);
		return "redirect:/admin";
	}
	
}