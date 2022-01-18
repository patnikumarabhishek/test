package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.Child;

import com.example.demo.entity.Parent;
import lombok.Data;

@Data
public class ParentDto {
	
	private Long id;

	private String sender;

	private String receiver;
	
	private Integer totalAmount;

	private List<ChildDto> child;

	private Integer paidAmount;

	public static ParentDto fromEntity(Parent entity) {
		ParentDto dto = new ParentDto();
		dto.setPaidAmount(entity.getPaidAmount());
		dto.setId(entity.getId());
		dto.setSender(entity.getSender());
		dto.setReceiver(entity.getReceiver());
		dto.setTotalAmount(entity.getTotalAmount());
		return dto;
	}

	public static ParentDto fromEntityWithChild(Parent entity) {
		ParentDto dto = new ParentDto();
		dto.setPaidAmount(entity.getPaidAmount());
		dto.setId(entity.getId());
		dto.setChild(entity.getChild().stream().map(c -> ChildDto.getChild(c)).collect(Collectors.toList()));
		dto.setSender(entity.getSender());
		dto.setReceiver(entity.getReceiver());
		dto.setTotalAmount(entity.getTotalAmount());
		return dto;
	}

}
