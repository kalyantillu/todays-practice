package com.example.todaypractice1.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todaypractice1.Entity.User;

public interface Userepo extends JpaRepository<User, Long>{

}
