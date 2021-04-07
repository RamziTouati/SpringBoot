package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
