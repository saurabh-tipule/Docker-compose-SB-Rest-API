package com.cjc.app.serviceimpl;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.app.entity.Passenger;
import com.cjc.app.entity.Ticket;
import com.cjc.app.repository.TicketRepository;
import com.cjc.app.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public String bookTicket(Passenger passenger) {

		Ticket ticket = new Ticket();

		ticket.setFullName(passenger.getFullName());
		ticket.setMobileNo(passenger.getMobileNo());
		ticket.setEmailId(passenger.getEmailId());
		ticket.setAge(passenger.getAge());
		ticket.setAdharNo(passenger.getAdharNo());
		ticket.setGender(passenger.getGender());
		ticket.setSource(passenger.getSource());
		ticket.setDestination(passenger.getDestination());
		ticket.setTrainName(passenger.getTrainName());
		ticket.setTrainNumber(passenger.getTrainNumber());

		ticket.setCost(generateCost());
		ticket.setPnrNo(generatePnr());

		Ticket dbTicket = ticketRepository.save(ticket);
		return dbTicket.getPnrNo();
	}

	private Double generateCost() {
		Random random = new Random();
		double min = 200.0;
		double max = 1000.0;

		double cost = min + (random.nextDouble() * (max - min));
		return cost;
	}

	private String generatePnr() {
		String pnr = "PNR" + UUID.randomUUID().toString().replace("-", "").substring(0, 7).toUpperCase();

		return pnr;
	}

	@Override
	public Ticket getTicket(String pnr) {

		Ticket ticket = ticketRepository.findByPnrNo(pnr);
		return ticket;
	}

}
