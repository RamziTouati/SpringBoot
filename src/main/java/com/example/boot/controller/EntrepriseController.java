package com.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.boot.entities.Entreprise;
import com.example.boot.repository.EntrepriseRepository;

@Controller
@RequestMapping("/entreprise")
public class EntrepriseController {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	@GetMapping("/liste")
	public String index(Model model) {
		model.addAttribute("items", entrepriseRepository.findAll());
		return "entreprise/index";	
	}
	
	@GetMapping("/new")
	public String create() {
		return "entreprise/new";
	}
	
	@PostMapping("/add")
	public String add(Entreprise entreprise) {
		entrepriseRepository.save(entreprise);
		return "redirect:/entreprise/liste";
	}
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable Long id) {
		entrepriseRepository.deleteById(id);
		return "redirect:/entreprise/liste";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("entreprise",entrepriseRepository.findById(id).get());
		return "entreprise/edit";
	}
	
	@PostMapping("/update")
	public String update(Entreprise entreprise) {
		
		Entreprise ex = entrepriseRepository.findById(entreprise.getId()).get();
		entreprise.setEmployes(ex.getEmployes());
		entrepriseRepository.save(entreprise);
		return "redirect:/entreprise/liste";
	}
}
