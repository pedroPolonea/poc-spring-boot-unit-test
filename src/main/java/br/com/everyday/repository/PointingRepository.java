package br.com.everyday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everyday.entity.AppointedDay;
import br.com.everyday.entity.Pointing;

@Repository
public interface PointingRepository extends JpaRepository<Pointing, Long>{
	List<Pointing> findByAppointedDay(AppointedDay appointedDay);
}
