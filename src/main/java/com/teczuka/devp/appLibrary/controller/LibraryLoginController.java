package com.teczuka.devp.appLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LibraryLoginController {
	
	@RequestMapping(value = {"/","/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (logout != null) {
			model.addAttribute("error", "");
			model.addAttribute("message", "Has cerrado sesión correctamente.");
		}	
		
		if (error != null)
			model.addAttribute("error", "Tu Usuario o Clave es inválido.");		

		return "login";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model) {
		return "dashboard";
	}
}
