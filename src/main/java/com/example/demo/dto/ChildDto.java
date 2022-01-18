package com.example.demo.dto;

import com.example.demo.entity.Child;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChildDto {

	private Long id;
	private Integer paidAmount;

	public static ChildDto getChild(Child child) {
		return ChildDto.builder()
				.id(child.getId())
				.paidAmount(child.getPaidAmount())
				.build();
	}
}
