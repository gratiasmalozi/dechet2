package com.d3e1.projet.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.d3e1.projet.DTO.IService;
import com.d3e1.projet.Model.Produit;
import com.d3e1.projet.Model.UserEntity;
import com.d3e1.projet.Repository.ProduitRepository;
import com.d3e1.projet.Repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/po")
public class ProduitController {
	@Autowired
	ProduitRepository produitRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
    IService service;
	
	
	@PostMapping("/produit/{idUser}")
	public ResponseEntity<?> enregistrement(@RequestBody Produit produit, @PathVariable long idUser) {
		
		this.service.addProduct(produit, idUser);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@GetMapping("/produitsListe") //04/03
    public ResponseEntity<?> getProduit(){
        List<Produit> listeProduits = (produitRepo).findAll();
        return ResponseEntity.ok(listeProduits);

    }
	@GetMapping("/produits")
	public long totalProduits() {
		return Produit.getTotal();
	}
	

}	  
    


