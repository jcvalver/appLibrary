package com.teczuka.devp.appLibrary.service;

import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.teczuka.devp.appLibrary.model.LibraryUser;
import com.teczuka.devp.appLibrary.repository.LibraryRoleRepository;
import com.teczuka.devp.appLibrary.repository.LibraryUserRepository;

@Service
public class BasicLibraryUserService implements LibraryUserService {

	@Autowired
	private LibraryUserRepository userRepository;

	@Autowired
	private LibraryRoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoderPassword;

	@Override
	public void save(LibraryUser user) {
		System.out.println(user.toString());
		user.setUserPassword(encoderPassword.encode(user.getUserPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		user.setUserDateRegistry(new Date());
		user.setUserUserRegistry(user.getUserName());
		userRepository.save(user);
	}

	@Override
	public LibraryUser findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
