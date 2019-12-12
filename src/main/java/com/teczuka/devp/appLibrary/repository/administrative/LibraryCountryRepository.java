package com.teczuka.devp.appLibrary.repository.administrative;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teczuka.devp.appLibrary.model.administrative.LibraryCountry;

public interface LibraryCountryRepository extends JpaRepository<LibraryCountry, Long>{

	LibraryCountry findByCountryDescription(String description);
	
	LibraryCountry findByCountryId(int id);
	
}
