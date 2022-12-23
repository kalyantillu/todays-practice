package com.example.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

@Entity
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String first_Name;
	private String last_Name;
	private String Birth_Date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="people_bank", joinColumns = {@JoinColumn(name="people_id")},
			inverseJoinColumns =  {@JoinColumn(name="bank_id")})
	private  Bank bank;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getBirth_Date() {
		return Birth_Date;
	}

	public void setBirth_Date(String birth_Date) {
		Birth_Date = birth_Date;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public People(long id, String first_Name, String last_Name, String birth_Date, Bank bank) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		Birth_Date = birth_Date;
		this.bank = bank;
	}

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", Birth_Date="
				+ Birth_Date + ", bank=" + bank + "]";
	}
	
	

}
