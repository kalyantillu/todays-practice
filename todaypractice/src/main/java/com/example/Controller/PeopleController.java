package com.example.Controller;

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

import com.example.Entity.People;
import com.example.Repo.Peoplerepo;

@RestController
public class PeopleController {

	@Autowired
	private Peoplerepo repo;

	@PostMapping("/pdata")
	public ResponseEntity<People> post(@RequestBody People p)
	{
		return new ResponseEntity<>(repo.save(p), HttpStatus.CREATED);
	}
	
	@GetMapping("/gdata")
	public ResponseEntity<List<People>> get()
	{
		return new ResponseEntity<>(repo.findAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("/gdata/{id}")
	public ResponseEntity<People> getsingle(@PathVariable long id)
	{
		Optional<People> obj = repo.findById(id);
		if(obj.isPresent())
		{
		return new ResponseEntity<>(obj.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		
	}
	
	@PutMapping("/data/{id}")
	public ResponseEntity<People> put(@PathVariable long id, @RequestBody People k )
	{
		Optional<People> obj = repo.findById(id);
		if(obj.isPresent())
		{
			People save = repo.save(k);
		return new ResponseEntity<>(save, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		
	}
	
	@DeleteMapping("/data/{id}")
	public ResponseEntity<People> delete(@PathVariable long id)
	{
		Optional<People> obj = repo.findById(id);
		if(obj.isPresent())
		{
			repo.deleteById(id);
		return new ResponseEntity<>( HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		
	}

	
	
}
