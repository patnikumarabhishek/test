package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="parent")
@AllArgsConstructor
@NoArgsConstructor
public class Parent implements Serializable {
	
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
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private List<Child> child = new ArrayList<>();

    @Transient
    private Integer paidAmount;
}
