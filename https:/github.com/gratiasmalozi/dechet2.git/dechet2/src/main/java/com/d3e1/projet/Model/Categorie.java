package com.d3e1.projet.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private long id;
	    
	   @Column(unique=true)
	   private String nom;
	   
	   
	public Categorie() {
		
	}

	public Categorie(String nom) {
		this.nom = nom;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
