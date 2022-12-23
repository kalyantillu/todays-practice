package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Bank_Name;
	private String Phone_Number;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	public Bank(long id, String bank_Name, String phone_Number) {
		super();
		this.id = id;
		Bank_Name = bank_Name;
		Phone_Number = phone_Number;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", Bank_Name=" + Bank_Name + ", Phone_Number=" + Phone_Number + "]";
	}
	
	
	
}
