package br.com.everyday.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="appointed_day")
public class AppointedDay {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idAppointed")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idteam", nullable=false)
	private Team team;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idMotivations", nullable=false)
	private Motivation motivation;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idCostCenter", nullable=false)
	private CostCenter costCenter;
	private LocalDate day;
	
	@OneToMany(mappedBy="appointedDay", orphanRemoval=true, cascade=CascadeType.ALL)
	private List<Pointing> pointings;
	
	@ManyToOne
	@JoinColumn(name="idUser", nullable=false)
	private User user;
}
