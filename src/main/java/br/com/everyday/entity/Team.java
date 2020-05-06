package br.com.everyday.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idteam", nullable=false)
	private Long id;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="dtCreation", nullable=false)
	private LocalDateTime dataCreation;
	@Column(name="active", nullable=false)
	private Boolean active;
	
}
