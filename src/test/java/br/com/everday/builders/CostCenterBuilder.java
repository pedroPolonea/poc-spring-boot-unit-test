package br.com.everday.builders;

import java.time.LocalDateTime;

import br.com.everyday.entity.CostCenter;

public class CostCenterBuilder {
	private CostCenter costCenter;
	
	public CostCenterBuilder() {
		costCenter = new CostCenter();
	}
	
	public static CostCenterBuilder oneCostCenter() {
		CostCenterBuilder costCenterBuilder = new CostCenterBuilder();
		costCenterBuilder.costCenter.setActive(true);
		costCenterBuilder.costCenter.setDataCreation(LocalDateTime.now());
		costCenterBuilder.costCenter.setId(1L);
		costCenterBuilder.costCenter.setName("PN - Patruela da Noite");
		
		return costCenterBuilder;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}
	
	
}
