package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.entities.Employe;
import com.example.boot.entities.Entreprise;
import com.example.boot.repository.EntrepriseRepository;

@RestController
@RequestMapping("/api")
public class RestEntrepriseController {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	@GetMapping("/entreprises")
	public List<Entreprise> all(){
		List<Entreprise> l=entrepriseRepository.findAll();
		for( Entreprise entreprise:l) {
			for( Employe employe:entreprise.getEmployes()) {
				employe.setEntrep(null);
				
			}
		}
		return l;
	}
	
	@GetMapping("/entreprise/{id}")
	public Entreprise recherche(@PathVariable long id){
		Entreprise entreprise=entrepriseRepository.findById(id).get();
		
			for( Employe employe:entreprise.getEmployes()) {
				employe.setEntrep(null);
			}
		return entreprise;
	}
	
	@PostMapping("/entreprise/add")
	public Entreprise add(@RequestBody Entreprise entreprise){
		return entrepriseRepository.save(entreprise);
	}
	
	@DeleteMapping("/entreprise/{id}")
	public String delete(@PathVariable long id){
		 entrepriseRepository.deleteById(id);
		 return "Supprision réussite";
	}
	
	@PutMapping("/entreprise")
	public String delete(@RequestBody Entreprise entreprise){
		 
		Entreprise ex = entrepriseRepository.findById(entreprise.getId()).get();
		entreprise.setEmployes(ex.getEmployes());
		 entrepriseRepository.save(entreprise);
		 return "update réussite";
	}
	
	
	
}
