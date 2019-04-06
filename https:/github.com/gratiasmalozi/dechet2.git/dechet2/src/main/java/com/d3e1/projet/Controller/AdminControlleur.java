package com.d3e1.projet.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d3e1.projet.Model.Produit;

//@CrossOrigin
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin")
public class AdminControlleur {
	
	@GetMapping("/listproduit")
	public ResponseEntity<?> listProduit() {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/creer")
	public ResponseEntity<?> creerProduit(@RequestBody Produit produit) {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{idProduit}")
	public ResponseEntity<?> supprimerProduit(@PathVariable long idProduit) {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/supprimer/{idProduit}")
	public ResponseEntity<?> modifierProduit(@RequestBody Produit produit) {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
