package com.example.demo.controller;

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
	 * 
	 * @param parentId
	 * @return
	 */
	@GetMapping("/{parentId}")
	public Parent getChildData(@PathVariable("parentId") Long parentId) {
		
		return childService.getChildData(parentId);
	}
}
