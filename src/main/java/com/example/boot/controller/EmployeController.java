package com.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.boot.entities.Employe;
import com.example.boot.entities.Entreprise;
import com.example.boot.repository.EmployeRepository;
import com.example.boot.repository.EntrepriseRepository;

@Controller
@RequestMapping("/employe")
public class EmployeController {

	
	@Autowired
	EmployeRepository employeRepository;
	
	@Autowired
	EntrepriseRepository entrepriseRepository;

	@GetMapping("/liste")
	public String index(Model model) {
		model.addAttribute("items", employeRepository.findAll());
		return "employe/index";	
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("entreprises", entrepriseRepository.findAll());
		return "employe/new";
	}
	
	@PostMapping({"/add", "/update"})
	public String add(Employe employe) {
		employeRepository.save(employe);
		return "redirect:/employe/liste";
	}
	
	@GetMapping("/remove/{matricule}")
	public String remove(@PathVariable Long matricule) {
		employeRepository.deleteById(matricule);
		return "redirect:/employe/liste";
	}
	
	@GetMapping("/edit/{matricule}")
	public String edit(@PathVariable Long matricule, Model model) {
		model.addAttribute("entreprises", entrepriseRepository.findAll());
		model.addAttribute("employe",employeRepository.findById(matricule).get());
		return "employe/edit";
	}
	
	//@PostMapping("/update")
	//public String update(Employe employe) {
		
		//Employe ex = employeRepository.findById(employe.getMatricule()).get();
		//employe.setEntrep(ex.getEntrep());
		//employeRepository.save(employe);
		//return "redirect:/employe/liste";
	//}
}
