package com.example.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.boot.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>{

	public List<Employe> findByQualite(String qualite);
	
	@Query(value="select * from employe, entreprise where qualite= ?1 and raison_sociale= ?2 and employe.entrep_id = entreprise.id", nativeQuery = true)
	public List<Employe> recherche(String qualite, String rs);
		
	
}
