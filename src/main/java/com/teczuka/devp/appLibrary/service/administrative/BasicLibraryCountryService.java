package com.teczuka.devp.appLibrary.service.administrative;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.teczuka.devp.appLibrary.model.administrative.LibraryCountry;
import com.teczuka.devp.appLibrary.repository.administrative.LibraryCountryRepository;

@Service
public class BasicLibraryCountryService implements LibraryCountryService{
	
	@Autowired
	private LibraryCountryRepository countryRepository;

	@Override
	public void save(LibraryCountry country) {
		// TODO Auto-generated method stub	
		country.setCountryDateRegistry(new Date());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		country.setCountryUserRegistry(username);
		countryRepository.save(country);		
	}

	@Override
	public LibraryCountry findByDescription(String description) {
		// TODO Auto-generated method stub
		return countryRepository.findByCountryDescription(description);
	}

	@Override
	public List<LibraryCountry> findAllCountrys() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public LibraryCountry findById(int id) {
		// TODO Auto-generated method stub
		return countryRepository.findByCountryId(id);
	}
	
}
