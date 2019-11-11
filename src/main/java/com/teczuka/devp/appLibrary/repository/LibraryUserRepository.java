package com.teczuka.devp.appLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teczuka.devp.appLibrary.model.LibraryUser;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
	
	LibraryUser findByUserName(String name);
}