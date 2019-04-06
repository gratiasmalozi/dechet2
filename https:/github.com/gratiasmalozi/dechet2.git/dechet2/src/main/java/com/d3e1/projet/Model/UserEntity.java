package com.d3e1.projet.Model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "utilisateur")
public class UserEntity{
	
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
     
 	 @NotNull
 	 private String nom;  //ou Entreprise
    
     @NotNull
 	 private String prenom;
     
 	 //@NotBlank
	 private boolean enabled;
 	 
 	 //@NotBlank
	 private String adresse;
	 
 	 //@NotBlank
     //@Column(unique=true)
     @Email
	 private String email;
	 
 	 //@NotBlank
     //@Column(unique=true)
	 private String tel;
 	 
 	//@NotNull
    //@Column(unique=true)
	private String username;
	

	@NotNull
     //@Column
	 private String motDePasse;
	
	@ManyToMany(mappedBy="users")
	private List<Produit> produits;
	  
	//CONSTRUCTORS
	public UserEntity(){
		   
	}


	public UserEntity(@NotNull String nom, @NotNull String prenom, @NotNull boolean enabled, @NotNull String adresse,
			@NotNull @Email String email, @NotNull String tel, @NotNull String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.enabled = enabled;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.motDePasse = motDePasse;
	}

	//GETTERS - SETTERS
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

	 public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(Produit produit) {
		this.produits.add(produit);
	}
	
}
