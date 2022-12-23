package com.example.todaypractice1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todaypractice1.Entity.User;
import com.example.todaypractice1.Repo.Userepo;

@RestController
public class Usercontroller {

	@Autowired
	private Userepo repo;
	
	@PostMapping("/postdata")
	public ResponseEntity<User> postdata(@RequestBody User u)
	{
		return new ResponseEntity<>(repo.save(u), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getdata")
	public ResponseEntity<List<User>> getdata()
	{
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getdata/{id}")
	public ResponseEntity<User> singledata(@PathVariable long id)
	{
		Optional<User> obj = repo.findById(id);
		if(obj.isPresent())
		{
			return new ResponseEntity<>(obj.get(), HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
	@PutMapping("/data/{id}")
	public ResponseEntity<User> Putdata(@PathVariable long id, @RequestBody User k)
	{
		Optional<User> obj = repo.findById(id);
		if(obj.isPresent())
		{
			User save = repo.save(k);
			return new ResponseEntity<>(save, HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
	@DeleteMapping("/data/{id}")
	public ResponseEntity<User> deletedata(@PathVariable long id)
	{
		Optional<User> obj = repo.findById(id);
		if(obj.isPresent())
		{
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
}
