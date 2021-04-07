package com.example.boot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long matricule;
	private String nom;
	public Employe() {
		super();
	}
	public Employe(long matricule, String nom, String prenom, String qualite, Entreprise entrep) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.qualite = qualite;
		this.entrep = entrep;
	}
	public long getMatricule() {
		return matricule;
	}
	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getQualite() {
		return qualite;
	}
	public void setQualite(String qualite) {
		this.qualite = qualite;
	}
	public Entreprise getEntrep() {
		return entrep;
	}
	public void setEntrep(Entreprise entrep) {
		this.entrep = entrep;
	}
	private String prenom;
	private String qualite;
	@ManyToOne
	private Entreprise entrep;
}
