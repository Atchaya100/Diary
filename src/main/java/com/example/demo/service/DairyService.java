package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Dairy;
import com.example.demo.entity.Login;
import com.example.demo.repository.DairyRepository;
import com.example.demo.repository.LoginRepository;
@Service
public class DairyService {
	@Autowired
	LoginRepository repo;
	@Autowired
	DairyRepository drepo;
	public Dairy create(int id,Dairy dairy) {
		Login l=repo.findById(id).get();
		
		List<Dairy> d=l.getDairies();
		d.add(dairy);
		l.setDairies(d);
		repo.save(l);
		return dairy;
		
	}
 public List<Dairy> view(int id){
	 Login l=repo.findById(id).get();
	 return l.getDairies();
 }
 public void delete(int id) {
	 //removing the dairy from list in login first and then deleting the dairy so that the login would not be deleted due to mapping
	 Dairy d=drepo.findById(id).get();
	 int i=d.getPerson().getId();
	 Login l=repo.findById(i).get();
	 System.out.println(l.getDairies());
	 l.getDairies().remove(d);
	 System.out.println(l.getDairies());
	 drepo.deleteById(id);
	 repo.save(l);
	 
 }
 public Dairy update(int id,Dairy dairy) {
	 Dairy d=drepo.findById(id).get();
	 d.setContent(dairy.getContent());
	 d.setStickers(dairy.getStickers());
	 d.setDate(dairy.getDate());
	 return drepo.save(d);
 }
}
