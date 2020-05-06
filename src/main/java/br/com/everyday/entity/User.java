package br.com.everyday.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idUser")
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String login;
	@NotNull
	private String password;
	@Column(name="dt_creation")
	private LocalDateTime dataCreation;
	private Boolean active;
	
	@OneToMany(mappedBy="user", orphanRemoval=true, cascade=CascadeType.ALL)
	private List<AppointedDay> appointedDays; 
}
