package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @author 
 *
 */
@Data
@Entity
@Table(name="child")
@NoArgsConstructor
@AllArgsConstructor
public class Child implements Serializable {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

    @Transient
    private Long parentId;

	@ManyToOne
    @JsonIgnore
    private Parent parent;

    @Column(name="paid_amount")
    private Integer paidAmount;


}
