package com.d3e1.projet.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d3e1.projet.Model.UserEntity;
import com.d3e1.projet.Repository.UserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public void deleteUser(long idUser) {
		
		this.userRepo.deleteById(idUser);
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		
		return this.userRepo.save(user);
	}

	@Override
	public UserEntity getUserByUsername(String username) {
		
		return this.userRepo.findByUsername(username);
	}
    
	/*@Override
	public List<UserEntity> getUsers() {
		// TODO Auto-generated method stub  03/03
		return null;
	} */
	
	public List<UserEntity> getUsers() { List<UserEntity> 
	listeProfils = userRepo.findAll();
	return listeProfils;
	}

	
}
