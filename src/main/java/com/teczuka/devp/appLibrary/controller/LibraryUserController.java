package com.teczuka.devp.appLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teczuka.devp.appLibrary.model.LibraryUser;
import com.teczuka.devp.appLibrary.service.LibraryUserService;

@Controller
@RequestMapping("/user")
public class LibraryUserController {

	@Autowired
	private LibraryUserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("libraryUserForm", new LibraryUser());
		return "usuario";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("libraryUserForm") LibraryUser libraryUser, BindingResult result) {

		if (result.hasErrors()) {
			return "usuario";
		}

		userService.save(libraryUser);

		return "redirect:/";
	}
	
}
