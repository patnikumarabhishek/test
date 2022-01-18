package com.example.demo.controller;

import com.example.demo.dto.ParentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Parent;
import com.example.demo.service.ParentService;

/**
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/parent")
public class ParentController {
	
	@Autowired
	private ParentService parentService;

	/**
	 * fetch parent details
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/{pageNumber}/{pageSize}")
	public Page<ParentDto> getParentData(@PathVariable("pageNumber") Integer pageNumber,
										 @PathVariable("pageSize") Integer pageSize) {
		
		return parentService.getParentData(pageNumber, pageSize);
	}
}
