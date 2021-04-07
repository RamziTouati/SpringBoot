package com.example.boot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Entreprise {
	
	public Entreprise() {
		super();
	}
	public Entreprise(long id, String raison_Sociale, String adresse, String tel, List<Employe> employes) {
		super();
		this.id = id;
		this.raison_Sociale = raison_Sociale;
		this.adresse = adresse;
		this.tel = tel;
		Employes = employes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRaison_Sociale() {
		return raison_Sociale;
	}
	public void setRaison_Sociale(String raison_Sociale) {
		this.raison_Sociale = raison_Sociale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Employe> getEmployes() {
		return Employes;
	}
	public void setEmployes(List<Employe> employes) {
		Employes = employes;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String raison_Sociale;
	private String adresse;
	private String tel;
	@OneToMany(mappedBy="entrep",orphanRemoval=true,fetch=FetchType.EAGER)
	private List<Employe> Employes;
	
	

}
