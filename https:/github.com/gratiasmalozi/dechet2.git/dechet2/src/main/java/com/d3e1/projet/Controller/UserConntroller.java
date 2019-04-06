package com.d3e1.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.d3e1.projet.DTO.UserService;
import com.d3e1.projet.Model.UserEntity;
import com.d3e1.projet.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin
@RequestMapping("/pi")

 class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	UserService userService;
	

	@PostMapping("/sinscrire")
    public String sinscrire(@RequestBody UserEntity user) {
        UserEntity dbNom = userRepository.findByNom(user.getNom());
        UserEntity dbMail = userRepository.findByEmail(user.getEmail());
       
        if((dbNom==null) && (dbMail==null)){
        
            UserEntity utilisateur = new UserEntity(user.getNom(),user.getPrenom(),
            		user.isEnabled(),
          user.getAdresse(),user.getEmail(),user.getTel(),user.getMotDePasse());
            userRepository.save(utilisateur);
            return "creation utilisateur réussie";
        }
		return "echec création utilisateur";
	}
	
	/*@GetMapping("/getuser/{username}")
	public ResponseEntity<?> getUser(@PathVariable String username){
		
		return new ResponseEntity<UserEntity>(this.userService.getUserByUsername(username), HttpStatus.OK);
	}
	*/
	
	@GetMapping("/usersList") //03/03
    public ResponseEntity<?> getUsers(){
        List<UserEntity> listeProfils = userService.getUsers();
        return ResponseEntity.ok(listeProfils);

    }
	
	@PutMapping("/updateuser")
	public ResponseEntity<?> updateAcount(@RequestBody UserEntity user){
		
		this.userService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") long id )
	 {
		this.userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	 }
	   
	
}
