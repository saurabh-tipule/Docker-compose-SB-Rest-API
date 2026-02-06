package com.cjc.app.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiError {

	private LocalDateTime localdateTime;

	private int status;

	private String path;

	private String message;
	
}
