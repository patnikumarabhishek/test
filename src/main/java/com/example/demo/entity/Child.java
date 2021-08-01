package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/**
 * 
 * @author 
 *
 */
@Data
@Entity
@Table(name="child")
public class Child {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_id", nullable = false)
    @JsonIgnore
    private Parent parent;
    
    @Column(name="paid_amount")
    private Integer paidAmount;

}
