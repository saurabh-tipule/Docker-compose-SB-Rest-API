package com.cjc.app.service;

import com.cjc.app.entity.Passenger;
import com.cjc.app.entity.Ticket;

public interface TicketService {

	String bookTicket(Passenger passenger);

	Ticket getTicket(String pnr);

}
