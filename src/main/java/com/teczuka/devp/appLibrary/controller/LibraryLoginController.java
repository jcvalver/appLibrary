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
public class LibraryLoginController {

	@Autowired
	private LibraryUserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("libraryUserForm", new LibraryUser());

        return "registration";
    }


	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("libraryUserForm") LibraryUser libraryUser, BindingResult result) {

		if (result.hasErrors()) {
			return "registration";
		}

		userService.save(libraryUser);

		return "redirect:/login";
	}
	
	@RequestMapping(value = {"/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (logout != null) {
			model.addAttribute("error", "");
			model.addAttribute("message", "Has cerrado sesión correctamente.");
		}	
		
		if (error != null)
			model.addAttribute("error", "Tu Usuario o Clave es inválido.");

		

		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}
}
