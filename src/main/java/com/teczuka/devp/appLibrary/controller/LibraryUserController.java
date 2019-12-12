package com.teczuka.devp.appLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teczuka.devp.appLibrary.model.LibraryUser;
import com.teczuka.devp.appLibrary.service.LibraryUserService;

@Controller
@RequestMapping("/user")
public class LibraryUserController {

	@Autowired
	private LibraryUserService userService;

	   @PostMapping(value = "/register", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	   @ResponseBody
	   public String saveUser(@ModelAttribute LibraryUser libraryUser,//@Valid
	         BindingResult result) {
		   String resultState="{\"status\":\"SUCCESS\"}";
	      
	      if(result.hasErrors()){
	    	  resultState="{\"status\":\"ERROR\"}";
	
	      }else{	   	    	  
	    	  userService.save(libraryUser);
	      }
	      return resultState;
	   }
	
}
