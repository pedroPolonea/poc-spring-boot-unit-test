package br.com.everyday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everyday.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
