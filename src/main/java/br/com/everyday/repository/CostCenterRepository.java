package br.com.everyday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everyday.entity.CostCenter;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Long>{

}
