package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Child;
import com.example.demo.entity.Parent;
import com.example.demo.repository.ParentRepository;

/**
 * 
 * @author 
 *
 */
@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepo;

	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<Parent> getParentData(Integer pageNumber, Integer pageSize) {
		
		Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
		Page<Parent> parents = parentRepo.findAll(paging);
		for(Parent p : parents.getContent()) {
			//Total amount paid by child
			Integer paidAmount = 0;
			for (Child c : p.getChild()) {
				if(c.getPaidAmount() != null) {
					paidAmount = paidAmount + c.getPaidAmount();
				}
			}
			p.setPaidAmount(paidAmount);
		}
		
		return parents;
	}
	
	/**
	 * find the childs n parent for parentId
	 * @param id
	 * @return
	 */
	public Parent getChildData(Long id) {
		Optional<Parent> p = parentRepo.findById(id);
		if(p.isPresent()) {
			return p.get();
		} 
		
		return null;
		
	}

}
