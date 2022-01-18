package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ChildDto;
import com.example.demo.dto.ParentDto;
import com.example.demo.repository.ChildRepository;
import com.google.common.base.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Child;
import com.example.demo.entity.Parent;
import com.example.demo.repository.ParentRepository;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 
 * @author 
 *
 */
@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepo;

	@Autowired
	private ChildRepository childRepo;

	/**
	 * get parents using pagination
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<ParentDto> getParentData(Integer pageNumber, Integer pageSize) {
		// page number not valid
		if(pageNumber<1){
			return null;
		}
		// default page number 0 and supporting 1 application
		Pageable paging = PageRequest.of(pageNumber-1, pageSize, Sort.by(Sort.Direction.ASC, "id"));
		Page<Parent> parentList = parentRepo.findAll(paging);

		//for calculate paid ammount
		for(Parent p : parentList.getContent()) {
			//Total amount paid by child
			Integer paidAmount = getPaidAmount(p.getChild());
			p.setPaidAmount(paidAmount);
		}
		// convert entity to dto
		Page<ParentDto> parents = parentList.map(ParentDto::fromEntity);
		return parents;
	}
	
	/**
	 * find the childs for parentId
	 * @param id parent Id
	 * @return
	 */
	public ParentDto getChildData(Long id) {
		Optional<Parent> p = parentRepo.findById(id);
		if(p.isPresent()) {
			Integer paidAmount = getPaidAmount(p.get().getChild());
			p.get().setPaidAmount(paidAmount);
			return ParentDto.fromEntityWithChild(p.get());
		}
		return null;
		
	}

	/**
	 * get total paid amount from child
	 * @param child
	 * @return
	 */
	private Integer getPaidAmount(List<Child> child) {
		Integer paidAmount = 0;
		for (Child c : child) {
			if(c.getPaidAmount() != null) {
				paidAmount = paidAmount + c.getPaidAmount();
			}
		}
		return paidAmount;
	}

	/**
	 * save parent data into parent table
	 * @param parents
	 */
	public void saveData(List<Parent> parents) {
		parentRepo.saveAll(parents);
	}

	/**
	 * save child data into child table
	 * @param child
	 */
	public void saveChildData(List<Child> child) {
		child.forEach(c -> {
			Optional<Parent> p = parentRepo.findById(c.getParentId());
			if(p.isPresent()) {
				p.get().getChild().add(c);
			}
			parentRepo.save(p.get());
		});
	}
}
