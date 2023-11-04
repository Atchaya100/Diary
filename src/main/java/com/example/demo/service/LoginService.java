package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Dairy;
import com.example.demo.entity.Login;
import com.example.demo.repository.LoginRepository;


@Service
public class LoginService {
@Autowired
LoginRepository repo;
public Login createAccount(Login login) {
	if(login.getPassword().equals(login.getConfirm())) {
	 return repo.save(login);
	
	}
	else {
		return null;
	}
}
	
public Login checkLogin(String mail,String password) {
	Login l=repo.findByMail(mail);
	if(l==null) {
		return null;
	}
	if(l.getPassword().equals(password)) {
		return l;
	}
	else {
	return null;
	}
}
public Login find(int id) {
	Login l=repo.findById(id).get();
	return l;
}

public void delete(String mail) {
	Login l=repo.findByMail(mail);
		repo.deleteById(l.getId());
		
	
	}
public Login update(Login login) {
	if(login.getConfirm().equals(login.getPassword())) {
	String name=login.getName();
	Login l1=repo.findByName(name);
	int id=l1.getId();
	System.out.println(id);
	Login l=repo.findById(id).get();
	System.out.println(l);
	l.setMail(login.getMail());
	l.setPassword(login.getPassword());
	l.setConfirm(login.getConfirm());
	return repo.save(l);
	}
	else {
		return null ;
	}
	
}


}
