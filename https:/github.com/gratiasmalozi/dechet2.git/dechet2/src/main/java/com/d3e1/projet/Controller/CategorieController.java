package com.d3e1.projet.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d3e1.projet.Model.Categorie;
import com.d3e1.projet.Model.Produit;
import com.d3e1.projet.Repository.CategorieRepository;



@RestController
//@CrossOrigin
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/catego")
public class CategorieController {
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@PostMapping("/creer")
	public ResponseEntity<Void> creerCategorie(@RequestBody Categorie categorie) {
		categorieRepository.save(categorie);
		return  new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	  


}
