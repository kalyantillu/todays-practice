package com.example.todaypractice1.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstname;
	private String lastname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="User_vehicles", joinColumns = {@JoinColumn(name="user_id")},
			inverseJoinColumns =  {@JoinColumn(name="vehicle_id")})
	private List<Vehicle> vehicle;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public User(long id, String firstname, String lastname, List<Vehicle> vehicle) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.vehicle = vehicle;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", vehicle=" + vehicle + "]";
	}
	
	
}
