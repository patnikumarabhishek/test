package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Child;

import lombok.Data;

@Data
public class ParentDto {
	
	private Long id;

	private String sender;

	private String receiver;
	
	private Integer totalAmount;

	private List<Child> child;

	private Integer paidAmount;

}
