package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Dairy;
import com.example.demo.entity.Login;
import com.example.demo.service.DairyService;
import com.example.demo.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	@Autowired
	LoginService service;
	@Autowired
	DairyService dservice;
	
	 @GetMapping("/")
		public String Hi() {
			return "hello";
		}
    @PostMapping("/create")
	public Login create(@RequestBody Login login) {
		return service.createAccount(login);
	}
    @GetMapping("/login/{mail}/{password}")
   	public Login login(@PathVariable String mail,@PathVariable String password) {
   		return service.checkLogin(mail, password);
   	}
    @DeleteMapping("/delete/{mail}")
    public void delete(@PathVariable String mail) {
    	 service.delete(mail);
    }
    @PutMapping("/update")
    public Login update(@RequestBody Login login) {
		return service.update(login);
    	
    }
    @PostMapping("/dcreate/{id}")
    public Dairy create(@PathVariable int id,@RequestBody Dairy dairy) {
		return dservice.create(id,dairy);
	}
    @GetMapping("/view/{id}")
   	public List<Dairy> login(@PathVariable int id) {
   		return dservice.view(id);
   	}
    @GetMapping("/find/{id}")
   	public Login find(@PathVariable int id) {
   		return service.find(id);
   	}
    @PutMapping("/updated/{id}")
    public Dairy updateD(@PathVariable int id,@RequestBody Dairy dairy) {
		return dservice.update(id,dairy);
    	
    }
    @DeleteMapping("/deleted/{id}")
    public void deleteD(@PathVariable int id) {
    	 dservice.delete(id);
    }
    
    
}
