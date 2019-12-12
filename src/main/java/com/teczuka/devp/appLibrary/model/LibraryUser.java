package com.teczuka.devp.appLibrary.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "LIBRARY_USER")
public class LibraryUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_FULLNAME")
	private String userFullname;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

	@Column(name = "USER_STATE")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean userState;

	@Column(name = "USER_DATEREGISTRY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date userDateRegistry;

	@Column(name = "USER_DATEUPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date userDateUpdate;

	@Column(name = "USER_USERREGISTRY")
	private String userUserRegistry;

	@Column(name = "USER_USERUPDATE")
	private String userUserUpdate;

	@JoinTable(name = "LIBRARY_USERROLE", 
			   joinColumns = @JoinColumn(name = "USERROLE_USERID", referencedColumnName = "USER_ID"),
			   inverseJoinColumns =  @JoinColumn(name = "USERROLE_ROLEID", referencedColumnName = "ROLE_ID"))
	@ManyToMany
	private Set<LibraryRole> roles;
	
	@Transient
	private String userPasswordConfirm;	
	
	public LibraryUser() {
		
	}	

	public LibraryUser(int userId, String userFullname, String userEmail, String userName, String userPassword,
			boolean userState, Date userDateRegistry, Date userDateUpdate, String userUserRegistry,
			String userUserUpdate) {
		super();
		this.userId = userId;
		this.userFullname = userFullname;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
		this.userDateRegistry = userDateRegistry;
		this.userDateUpdate = userDateUpdate;
		this.userUserRegistry = userUserRegistry;
		this.userUserUpdate = userUserUpdate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFullname() {
		return userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean getUserState() {
		return userState;
	}

	public void setUserState(boolean userState) {
		this.userState = userState;
	}

	public Date getUserDateRegistry() {
		return userDateRegistry;
	}

	public void setUserDateRegistry(Date userDateRegistry) {
		this.userDateRegistry = userDateRegistry;
	}

	public Date getUserDateUpdate() {
		return userDateUpdate;
	}

	public void setUserDateUpdate(Date userDateUpdate) {
		this.userDateUpdate = userDateUpdate;
	}

	public String getUserUserRegistry() {
		return userUserRegistry;
	}

	public void setUserUserRegistry(String userUserRegistry) {
		this.userUserRegistry = userUserRegistry;
	}

	public String getUserUserUpdate() {
		return userUserUpdate;
	}

	public void setUserUserUpdate(String userUserUpdate) {
		this.userUserUpdate = userUserUpdate;
	}
	
	public Set<LibraryRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<LibraryRole> roles) {
		this.roles = roles;
	}	

	
	public String getUserPasswordConfirm() {
		return userPasswordConfirm;
	}

	public void setUserPasswordConfirm(String userPasswordConfirm) {
		this.userPasswordConfirm = userPasswordConfirm;
	}


	@Override
	public String toString() {
		return "LibraryUser [userId=" + userId + ", userFullname=" + userFullname + ", userEmail=" + userEmail
				+ ", userName=" + userName + ", userPassword=" + userPassword + ", userState=" + userState
				+ ", userDateRegistry=" + userDateRegistry + ", userDateUpdate=" + userDateUpdate
				+ ", userUserRegistry=" + userUserRegistry + ", userUserUpdate=" + userUserUpdate
				+ ", userPasswordConfirm="+userPasswordConfirm+"]";
	}
}
