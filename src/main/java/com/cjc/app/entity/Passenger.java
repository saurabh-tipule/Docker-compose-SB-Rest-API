package com.cjc.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

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

}
