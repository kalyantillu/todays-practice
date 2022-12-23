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

import com.example.todaypractice1.Entity.Vehicle;
import com.example.todaypractice1.Repo.Vehiclerepo;

@RestController
public class Vehiclecontroller {

	@Autowired
	private Vehiclerepo repo1; 
	
 
	@PostMapping("/pdata")
	public ResponseEntity<Vehicle> postdata1(@RequestBody Vehicle u)
	{
		return new ResponseEntity<>(repo1.save(u), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/gdata")
	public ResponseEntity<List<Vehicle>> getdata1()
	{
		return new ResponseEntity<>(repo1.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/gdata/{id}")
	public ResponseEntity<Vehicle> singledata1(@PathVariable long id)
	{
		Optional<Vehicle> obj = repo1.findById(id);
		if(obj.isPresent())
		{
			return new ResponseEntity<>(obj.get(), HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
	@PutMapping("/putdata/{id}")
	public ResponseEntity<Vehicle> Putdata1(@PathVariable long id, @RequestBody Vehicle k)
	{
		Optional<Vehicle> obj = repo1.findById(id);
		if(obj.isPresent())
		{
			Vehicle save = repo1.save(k);
			return new ResponseEntity<>(save, HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
	@DeleteMapping("/deletedata/{id}")
	public ResponseEntity<Vehicle> deletedata1(@PathVariable long id)
	{
		Optional<Vehicle> obj = repo1.findById(id);
		if(obj.isPresent())
		{
			repo1.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
}
