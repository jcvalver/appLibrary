package com.teczuka.devp.appLibrary.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teczuka.devp.appLibrary.model.LibraryPermission;
import com.teczuka.devp.appLibrary.model.LibraryRole;
import com.teczuka.devp.appLibrary.model.LibraryUser;
import com.teczuka.devp.appLibrary.repository.LibraryUserRepository;

@Service("userDetailsService")
@Transactional
public class BasicLibraryUserDetailsService implements UserDetailsService {

	@Autowired
	private LibraryUserRepository libraryUserRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		LibraryUser libraryUser = libraryUserRepository.findByUserName(userName);
	

	//	return new User(libraryUser.getUserName(), libraryUser.getUserPassword(), libraryUser.getUserState(), true,
	//			true, true, getAuthorities(libraryUser.getRoles()));
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (LibraryRole role : libraryUser.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleDescription()));
        }
      
        return new org.springframework.security.core.userdetails.User(libraryUser.getUserName(), libraryUser.getUserPassword(), grantedAuthorities);


	}

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<LibraryRole> roles) {

		return getGrantedAuthorities(getPrivileges(roles));
	}

	private List<String> getPrivileges(Collection<LibraryRole> roles) {

		List<String> privileges = new ArrayList<>();
		List<LibraryPermission> collection = new ArrayList<>();
		for (LibraryRole role : roles) {
			collection.addAll(role.getPermissions());
		}
		for (LibraryPermission item : collection) {
			privileges.add(item.getPermissionDescription());
		}
		return privileges;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}
}
