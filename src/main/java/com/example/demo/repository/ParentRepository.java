package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

}
