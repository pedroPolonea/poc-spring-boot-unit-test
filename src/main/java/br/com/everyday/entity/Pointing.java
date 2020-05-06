package br.com.everyday.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="pointing")
@EqualsAndHashCode
public class Pointing {
	
	@Id
	@Column(name="idPointing", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="dtInput", nullable=false)
	private LocalDateTime dateInput;
	@Column(name="dtOut")
	private LocalDateTime dateOutput;
	@ManyToOne
	@JoinColumn(name="idAppointed", nullable=false)
	private AppointedDay appointedDay;
}

			