package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class RoleModel implements GrantedAuthority {
 @Id
 private String nomeRole;
 
 @ManyToMany(mappedBy="roles")
 private List<UsuarioModel>usuarios;

@Override
public String getAuthority() {
	// TODO Auto-generated method stub
	return this.nomeRole;
}

public String getNomeRole() {
	return nomeRole;
}

public void setNomeRole(String nomeRole) {
	this.nomeRole = nomeRole;
}

public List<UsuarioModel> getUsuarios() {
	return usuarios;
}

public void setUsuarios(List<UsuarioModel> usuarios) {
	this.usuarios = usuarios;
}

@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}

@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}

@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	super.finalize();
}

@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
 

 
}
