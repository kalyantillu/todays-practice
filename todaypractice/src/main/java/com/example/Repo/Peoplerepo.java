package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.People;

public interface Peoplerepo extends JpaRepository<People, Long>{

}
