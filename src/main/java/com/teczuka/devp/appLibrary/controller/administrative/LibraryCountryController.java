package com.teczuka.devp.appLibrary.controller.administrative;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.teczuka.devp.appLibrary.model.administrative.LibraryCountry;
import com.teczuka.devp.appLibrary.service.administrative.LibraryCountryService;


@Controller
@RequestMapping("/country")
public class LibraryCountryController {

	@Autowired
	LibraryCountryService countryService;

	@RequestMapping(method = RequestMethod.GET)
	public String listCountry(Model model) {
		List<LibraryCountry> countrys = countryService.findAllCountrys();
		model.addAttribute("countrys", countrys);
		return "administrative/country";
	}

	@PostMapping(value = "/register", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String saveCountry(@ModelAttribute LibraryCountry libraryCountry, // @Valid
			BindingResult result) {
		String resultState = "{\"status\":\"SUCCESS\"}";
		
		System.out.println("result:"+result);
		if (result.hasErrors()) {
			resultState = "{\"status\":\"ERROR\"}";

		} else {
			countryService.save(libraryCountry);
		}
		System.out.println(libraryCountry.toString());
		return resultState;
	}
	
	@RequestMapping(value =  "/edit/{countryId}" , method = RequestMethod.GET,produces =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<LibraryCountry> updateCountry(@PathVariable String countryId) {	
			 
			 LibraryCountry libraryCountry= countryService.findById(Integer.parseInt(countryId));
			 
			 if(libraryCountry!=null) {
				 return new ResponseEntity<LibraryCountry>(libraryCountry, HttpStatus.OK);	            
			 }else
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);		  
		
	}
	
	
	
	@PostMapping(value = "/edit/{countryId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public String updateCountry(@PathVariable String countryId,@ModelAttribute LibraryCountry libraryCountry, // @Valid
			BindingResult result) {
		System.out.println(libraryCountry);
		String resultState = "{\"status\":\"SUCCESS\"}";
		
		if (result.hasErrors()) {
			resultState = "{\"status\":\"ERROR\"}";

		} else {
			libraryCountry.setCountryState(true);
			countryService.save(libraryCountry);
		}
		return resultState;
	}
	
	
	@RequestMapping(value =  "/delete/{countryId}" , method = RequestMethod.GET,produces =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteCountry(@PathVariable String countryId) {				 
				LibraryCountry libraryCountry= countryService.findById(Integer.parseInt(countryId));
				String resultState = "{\"status\":\"SUCCESS\"}";
				
				if (libraryCountry==null) {
					resultState = "{\"status\":\"ERROR\"}";

				} else {				
					libraryCountry.setCountryState(false);				
					countryService.save(libraryCountry);
				}
				return resultState;		
	}

}
