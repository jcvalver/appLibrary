package com.teczuka.devp.appLibrary.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="LIBRARY_ROLE")
public class LibraryRole implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROLE_ID")
	private int roleId;
	
	@Column(name="ROLE_DESCRIPTION")
	private String roleDescription;
	
	@Column(name="ROLE_STATE")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean roleState;
	
	@Column(name="ROLE_DATEREGISTRY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date roleDateRegistry;
	
	@Column(name="ROLE_DATEUPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date roleDateUpdate;
	
	@Column(name="ROLE_USERREGISTRY")
	private String roleUserRegistry;
	
	@Column(name="ROLE_USERUPDATE")
	private String roleUserUpdate;
	
	@ManyToMany(mappedBy = "roles")
    private Set<LibraryUser> users;
	
	@JoinTable(name = "LIBRARY_PERMISSIONROLE", 
			   joinColumns = @JoinColumn(name = "PERMISSIONROLE_ROLEID",referencedColumnName = "ROLE_ID", nullable = false), 
			   inverseJoinColumns =  @JoinColumn(name = "PERMISSIONROLE_PERMISSIONID",referencedColumnName = "PERMISSION_ID", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<LibraryPermission> permissions;
	

	public Set<LibraryPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<LibraryPermission> permissions) {
		this.permissions = permissions;
	}
	
	public LibraryRole() {
		
	}

	public LibraryRole(int roleId, String roleDescription, boolean roleState, Date roleDateRegistry, Date roleDateUpdate,
			String roleUserRegistry, String roleUserUpdate) {
		super();
		this.roleId = roleId;
		this.roleDescription = roleDescription;
		this.roleState = roleState;
		this.roleDateRegistry = roleDateRegistry;
		this.roleDateUpdate = roleDateUpdate;
		this.roleUserRegistry = roleUserRegistry;
		this.roleUserUpdate = roleUserUpdate;
	}	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public boolean getRoleState() {
		return roleState;
	}

	public void setRoleState(boolean roleState) {
		this.roleState = roleState;
	}

	public Date getRoleDateRegistry() {
		return roleDateRegistry;
	}

	public void setRoleDateRegistry(Date roleDateRegistry) {
		this.roleDateRegistry = roleDateRegistry;
	}

	public Date getRoleDateUpdate() {
		return roleDateUpdate;
	}

	public void setRoleDateUpdate(Date roleDateUpdate) {
		this.roleDateUpdate = roleDateUpdate;
	}

	public String getRoleUserRegistry() {
		return roleUserRegistry;
	}

	public void setRoleUserRegistry(String roleUserRegistry) {
		this.roleUserRegistry = roleUserRegistry;
	}

	public String getRoleUserUpdate() {
		return roleUserUpdate;
	}

	public void setRoleUserUpdate(String roleUserUpdate) {
		this.roleUserUpdate = roleUserUpdate;
	}
	

	public Set<LibraryUser> getUsers() {
		return users;
	}

	public void setUsers(Set<LibraryUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "LibraryRol [roleId=" + roleId + ", roleDescription=" + roleDescription + ", roleState=" + roleState
				+ ", roleDateRegistry=" + roleDateRegistry + ", roleDateUpdate=" + roleDateUpdate
				+ ", roleUserRegistry=" + roleUserRegistry + ", roleUserUpdate=" + roleUserUpdate + "]";
	}	
}
