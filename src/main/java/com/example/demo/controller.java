package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AddressRepository addressRepo;

	@GetMapping("users")
	public ResponseEntity<?> getUsers(Pageable pageable){
		
		Page<User> users = userRepo.findAll(pageable);
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id){
		
		User user = userRepo.findById(id).get(); 
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@PostMapping("user")
	public ResponseEntity<?> createUser(@RequestBody User user){

		return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK);
	}
	@GetMapping("address/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable Integer id){
		
		Address addr= addressRepo.findById(id).get(); 
		
		return new ResponseEntity<>(addr, HttpStatus.OK);
	}
	@DeleteMapping("address/{id}")
	public ResponseEntity<?> deleteAddressById(@PathVariable Integer id){
		addressRepo.deleteById(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	@PostMapping("address")
	public ResponseEntity<?> createAddress(@RequestBody Address address){
		return new ResponseEntity<>(addressRepo.save(address), HttpStatus.OK);
	}

}
