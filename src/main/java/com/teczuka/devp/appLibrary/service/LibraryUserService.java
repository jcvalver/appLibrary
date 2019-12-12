package com.teczuka.devp.appLibrary.service;

import com.teczuka.devp.appLibrary.model.LibraryUser;

public interface LibraryUserService {

	void save(LibraryUser user);

	LibraryUser findByUserName(String userName);
	
	
}
