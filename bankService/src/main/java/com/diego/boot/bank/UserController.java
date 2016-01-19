package com.diego.boot.bank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.boot.bank.entity.Account;
import com.diego.boot.bank.entity.User;
import com.diego.boot.bank.repo.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAll() {
		return (List<User>) repo.findAll();
	}

	@RequestMapping(value = "/users", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll() {
		repo.deleteAll();
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		repo.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<User> createUserPOST(@RequestBody User user) {
		if(user.getAccounts()!=null){
			repo.save(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}

	// -----------------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User upd) {
		User user = repo.findOne(id);
		if(user!=null){
			user.setEmail(upd.getEmail());
			user.setLastName(upd.getLastName());
			user.setName(upd.getName());
			repo.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getOne(@PathVariable("id") int id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteOne(@PathVariable("id") int id) {
		repo.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.OPTIONS)
	public void getOptions() {

	}

}
