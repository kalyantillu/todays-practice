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

import com.example.Entity.Bank;
import com.example.Repo.Bankrepo;

@RestController
public class BankController {

	@Autowired
	private Bankrepo repo1;
		@PostMapping("/postdata")
	public ResponseEntity<Bank> post1(@RequestBody Bank p) 
	{
		return new ResponseEntity<>(repo1.save(p), HttpStatus.CREATED);
	}
	
	@GetMapping("/getdata")
	public ResponseEntity<List<Bank>> get1()
	{
		return new ResponseEntity<>(repo1.findAll(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getdata/{id}")
	public ResponseEntity<Bank> getsingle1(@PathVariable long id)
	{
		Optional<Bank> obj = repo1.findById(id);
		if(obj.isPresent())
		{
		return new ResponseEntity<>(obj.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		
	}
	
	@PutMapping("/putdata/{id}")
	public ResponseEntity<Bank> put1(@PathVariable long id, @RequestBody Bank k )
	{
		Optional<Bank> obj = repo1.findById(id);
		if(obj.isPresent())
		{
			Bank save = repo1.save(k);
		return new ResponseEntity<>(save, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		
	}
	
	@DeleteMapping("/deletedata/{id}")
	public ResponseEntity<Bank> delete1(@PathVariable long id)
	{
		Optional<Bank> obj = repo1.findById(id);
		if(obj.isPresent())
		{
			repo1.deleteById(id);
		return new ResponseEntity<>( HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		
	}

	
	
}
