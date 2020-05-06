package br.com.everyday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everyday.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
