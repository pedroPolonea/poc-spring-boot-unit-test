package br.com.everyday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everyday.entity.AppointedDay;
import br.com.everyday.entity.User;

@Repository
public interface AppointedDayRepository extends JpaRepository<AppointedDay, Long>{

	List<AppointedDay> findByUser(User user); 



}
