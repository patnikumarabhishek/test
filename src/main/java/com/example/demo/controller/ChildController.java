package com.example.demo.controller;

import com.example.demo.dto.ParentDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/child")
public class ChildController {
	
	@Autowired
	private ParentService childService;
	
	/**\
	 * fetch child details for parentId
	 * @param parentId
	 * @return
	 */
	@GetMapping("/{parentId}")
	@ApiOperation("fetch child details for parent.Reponse will contain in form of common parent data with child details.")
	public ParentDto getChildData(@PathVariable("parentId") Long parentId) {
		
		return childService.getChildData(parentId);
	}
}
