package com.cjc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.entity.Passenger;
import com.cjc.app.entity.Ticket;
import com.cjc.app.service.TicketService;

@RestController
@RequestMapping(value = "/api/v1/irctc")
public class TicketController {

	private TicketService ticketService;

	@Autowired
	public void setTickerService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	// http://localhost:9090/api/v1/irctc/welcome

	@GetMapping(value = "/welcome")
	public String handleWelcomeRequest() {
		String msg = "Welcome To Spring Boot REST-API";
		return msg;
	}

	@PostMapping(value = "/tickets")
	public ResponseEntity<String> bookTicket(@RequestBody Passenger passenger) {
		String pnr = ticketService.bookTicket(passenger);
		return new ResponseEntity<String>(pnr, HttpStatus.CREATED);
	}

	@GetMapping(value = "/tickets/{pnr}")
	public ResponseEntity<Ticket> getTicket(@PathVariable String pnr) {
		Ticket ticket = ticketService.getTicket(pnr);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}


}
