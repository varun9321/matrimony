package com.oms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oms.dao.UserDetailsDao;
import com.oms.service.AdminService;
import com.oms.validators.UserDetailsDaoValidator;

@Controller("Guest")
public class FirstTimeGuest {
	
	@Autowired
	AdminService admServ;
	
	@Autowired
	private UserDetailsDaoValidator userValidator;
	
	@InitBinder("userdetailsdao")
	protected void initSignupBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String addUserGet(Model model) {
		model.addAttribute("userdetailsdao", new UserDetailsDao());
		model.addAttribute("roles",admServ.findAllRoles());
		return "adduser";
	}

	@RequestMapping(value="/",method = RequestMethod.POST)
	public String addUserPost(Model model,@Valid @ModelAttribute("userdetailsdao") UserDetailsDao userdetailsdao,BindingResult result) {
		model.addAttribute("roles",admServ.findAllRoles());
		if(result.hasErrors()){
			return "adduser";
		}
		admServ.saveUsers(userdetailsdao);
		System.out.println("post"+userdetailsdao.getName()+userdetailsdao.getEmail()+userdetailsdao.getPassword()+userdetailsdao.getRoles());
		return "redirect:/admin";
	}
	
}
