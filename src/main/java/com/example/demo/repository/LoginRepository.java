package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>{
public Login findByMail(String mail);
public Login findByName(String name);

}
