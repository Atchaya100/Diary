package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Login {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirm() {
	return confirm;
}
public void setConfirm(String confirm) {
	this.confirm = confirm;
}
@OneToMany(targetEntity=Dairy.class,mappedBy = "person",cascade=CascadeType.ALL)
@JsonIgnore
private List<Dairy> dairies;
public List<Dairy> getDairies() {
	return dairies;
}
public void setDairies(List<Dairy> dairies) {
	this.dairies = dairies;
    dairies.forEach(s -> s.setPerson(this));
}
private String name;
private String mail;
private String password;
private String confirm;
}
