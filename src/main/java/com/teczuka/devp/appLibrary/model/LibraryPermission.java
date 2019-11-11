package com.teczuka.devp.appLibrary.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="LIBRARY_PERMISSION")
public class LibraryPermission implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PERMISSION_ID")
	private int permissionId;
	
	@Column(name="PERMISSION_DESCRIPTION")
	private String permissionDescription;
	
	@Column(name="PERMISSION_URL")
	private String permissionUrl;
	
	@Column(name="PERMISSION_MENU")
	private String permissionMenu;
	
	@Column(name="PERMISSION_STATE")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean permissionState;
	
	@Column(name="PERMISSION_DATEREGISTRY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date permissionDateRegistry;
	
	@Column(name="PERMISSION_DATEUPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date permissionDateUpdate;
	
	@Column(name="PERMISSION_USERREGISTRY")
	private String permissionUserRegistry;
	
	@Column(name="PERMISSION_USERUPDATE")
	private String permissionUserUpdate;
	
	@ManyToMany(mappedBy = "permissions")
    private Set<LibraryRole> roles;

	public Set<LibraryRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<LibraryRole> roles) {
		this.roles = roles;
	}
	
	public LibraryPermission() {
		
	}

	public LibraryPermission(String permissionDescription, String permissionUrl, String permissionMenu,
			boolean permissionState, Date permissionDateRegistry, Date permissionDateUpdate, String permissionUserRegistry,
			String permissionUserUpdate) {
		super();
		this.permissionDescription = permissionDescription;
		this.permissionUrl = permissionUrl;
		this.permissionMenu = permissionMenu;
		this.permissionState = permissionState;
		this.permissionDateRegistry = permissionDateRegistry;
		this.permissionDateUpdate = permissionDateUpdate;
		this.permissionUserRegistry = permissionUserRegistry;
		this.permissionUserUpdate = permissionUserUpdate;
	}	

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	public String getPermissionMenu() {
		return permissionMenu;
	}

	public void setPermissionMenu(String permissionMenu) {
		this.permissionMenu = permissionMenu;
	}

	public boolean getPermissionState() {
		return permissionState;
	}

	public void setPermissionState(boolean permissionState) {
		this.permissionState = permissionState;
	}

	public Date getPermissionDateRegistry() {
		return permissionDateRegistry;
	}

	public void setPermissionDateRegistry(Date permissionDateRegistry) {
		this.permissionDateRegistry = permissionDateRegistry;
	}

	public Date getPermissionDateUpdate() {
		return permissionDateUpdate;
	}

	public void setPermissionDateUpdate(Date permissionDateUpdate) {
		this.permissionDateUpdate = permissionDateUpdate;
	}

	public String getPermissionUserRegistry() {
		return permissionUserRegistry;
	}

	public void setPermissionUserRegistry(String permissionUserRegistry) {
		this.permissionUserRegistry = permissionUserRegistry;
	}

	public String getPermissionUserUpdate() {
		return permissionUserUpdate;
	}

	public void setPermissionUserUpdate(String permissionUserUpdate) {
		this.permissionUserUpdate = permissionUserUpdate;
	}
	
	@Override
	public String toString() {
		return "LibraryPermission [permissionDescription=" + permissionDescription + ", permissionUrl=" + permissionUrl
				+ ", permissionMenu=" + permissionMenu + ", permissionState=" + permissionState
				+ ", permissionDateRegistry=" + permissionDateRegistry + ", permissionDateUpdate="
				+ permissionDateUpdate + ", permissionUserRegistry=" + permissionUserRegistry
				+ ", permissionUserUpdate=" + permissionUserUpdate + "]";
	}
	
	
}
