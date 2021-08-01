package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="parent")
public class Parent {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
    @Column(name="sender")
    private String sender;
    
    @Column(name="receiver")
    private String receiver;
    
    @Column(name="total_amount")
    private Integer totalAmount;
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Child> child;
    
    @Transient
    private Integer paidAmount;
}
