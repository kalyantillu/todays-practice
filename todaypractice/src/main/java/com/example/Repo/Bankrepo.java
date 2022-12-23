package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Bank;

public interface Bankrepo extends JpaRepository<Bank, Long> {

}
