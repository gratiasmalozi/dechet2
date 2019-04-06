package com.d3e1.projet.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d3e1.projet.Model.Categorie;
import com.d3e1.projet.Model.Produit;
import com.d3e1.projet.Model.UserEntity;
import com.d3e1.projet.Repository.CategorieRepository;
import com.d3e1.projet.Repository.ProduitRepository;
import com.d3e1.projet.Repository.UserRepository;

@Service
public class ServiceImpl implements IService{
	
	@Autowired
	ProduitRepository produitRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public void addProduct(Produit produit, long idUser) {
		UserEntity user = userRepo.findById(idUser).get();
		Produit p = produitRepo.findByNom(produit.getNom());
		Categorie categorie = categorieRepository.findByNom(produit.getCategorie().getNom());
		
		if(p == null) {
			Produit.setTotal(Produit.getTotal()+produit.getNombre());
			produit.setCategorie(categorie);
			produitRepo.save(produit);
		
		}else {
			p.setNombre(p.getNombre()+produit.getNombre());
			p.getUsers().add(user);
			this.produitRepo.save(p);
			Produit.setTotal(Produit.getTotal()+produit.getNombre());
		}
		
		
	}

}
