package br.com.everyday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everyday.entity.CostCenter;
import br.com.everyday.repository.CostCenterRepository;
import br.com.everyday.service.CostCenterService;

@Service
public class CostCenterServiceImp implements CostCenterService{
	
	@Autowired
	private CostCenterRepository costCenterRepository;

	public List<CostCenter> getAll() {
		return costCenterRepository.findAll();
	} 

}
