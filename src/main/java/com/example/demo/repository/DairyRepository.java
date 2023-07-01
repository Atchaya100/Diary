package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Dairy;
import com.example.demo.entity.Login;


public interface DairyRepository extends JpaRepository<Dairy,Integer>{
}
