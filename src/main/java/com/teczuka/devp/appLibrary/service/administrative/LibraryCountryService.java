package com.teczuka.devp.appLibrary.service.administrative;

import java.util.List;

import com.teczuka.devp.appLibrary.model.administrative.LibraryCountry;

public interface LibraryCountryService {
	
	void save(LibraryCountry country);

	LibraryCountry findByDescription(String description);
	
	LibraryCountry findById(int id);
	
	List<LibraryCountry> findAllCountrys();

}
