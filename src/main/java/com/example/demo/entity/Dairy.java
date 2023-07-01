package com.example.demo.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Dairy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String Date;
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getStickers() {
	return stickers;
}
public void setStickers(String stickers) {
	this.stickers = stickers;
}
private String content;
private String stickers;
@ManyToOne(cascade =  CascadeType.ALL)
@JoinColumn(name ="login_id")
private Login person;
public Login getPerson() {
	return person;
}
public void setPerson(Login person) {
	this.person = person;
}
}
