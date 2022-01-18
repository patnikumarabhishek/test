package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Child;
import com.example.demo.entity.Parent;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
}
