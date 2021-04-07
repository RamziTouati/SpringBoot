package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.entities.Employe;
import com.example.boot.entities.Entreprise;
import com.example.boot.repository.EmployeRepository;
import com.example.boot.repository.EntrepriseRepository;

@RestController
@RequestMapping("/api")
public class RestEmployeController {

	@Autowired
	EmployeRepository employeRepository;
	
	@GetMapping("/employe/search")
	public List<Employe> search(@RequestParam String qualite){
		List<Employe> l = employeRepository.findByQualite(qualite);
		for( Employe employe:l) {
			
			employe.getEntrep().setEmployes(null);;
				
		}
		return l;
	}
	
	@GetMapping("/employe/find")
	public List<Employe> find(@RequestParam String qualite, @RequestParam String rs){
		List<Employe> l = employeRepository.recherche(qualite, rs);
		for( Employe employe:l) {
			employe.getEntrep().setEmployes(null);
		}
		return l;
	}
	
	

}
