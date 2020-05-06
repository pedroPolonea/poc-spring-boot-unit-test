package br.com.everyday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everyday.entity.Motivation;

@Repository
public interface MotivationRepository extends JpaRepository<Motivation, Long> {

}
