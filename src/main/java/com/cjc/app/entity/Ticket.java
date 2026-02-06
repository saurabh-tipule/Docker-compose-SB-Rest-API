package com.cjc.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

	@Id
	@SequenceGenerator(name = "tic_sequence", sequenceName = "ticket_sequence", initialValue = 5001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tic_sequence")
	private Integer ticketId;

	private String fullName;

	private Long mobileNo;

	private String emailId;

	private Integer age;

	private String gender;

	private Long adharNo;

	private String trainName;

	private Integer trainNumber;

	private String source;

	private String destination;

	private Double cost;

	private String pnrNo;

}
