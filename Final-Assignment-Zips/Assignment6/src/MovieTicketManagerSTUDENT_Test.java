package Implementations.Assignment6;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		//add adults
		ticketList.addTicket("Movie", "PG13", 4,19,"NONE","Adult",0);
		ticketList.addTicket("Another movie", "NR", 2,22,"IMAX","Adult",0);
		ticketList.addTicket("Spirited Away", "PG", 3,14,"3D","Adult",0);

		//add children
		ticketList.addTicket("Little Mermaid", "G", 5,17,"NONE","Child",0);
		ticketList.addTicket("Fortnite", "G", 2,12,"NONE","Child",0);
		ticketList.addTicket("Ratatouille", "PG", 2,14,"3D","Child",0);

		//add employees
		ticketList.addTicket("Deadpool", "NR", 5,19,"NONE","Employee",12111);
		ticketList.addTicket("Action Point", "NR", 2,12,"NONE","Employee",18274);
		ticketList.addTicket("Book Club", "PG13", 1,13,"IMAX","Employee",23234);

		//add MoviePass members
		ticketList.addTicket("Deadpool", "NR", 5,19,"IMAX","MoviePass",55555);
		ticketList.addTicket("Deadpool", "NR", 1,13,"IMAX","MoviePass",55555);
		ticketList.addTicket("Star War", "PG13", 2,12,"NONE","MoviePass",33333);
	}

	@After
	public void tearDown() throws Exception {
		ticketList = null;
	}

	/**
	 * Student Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		assertEquals(ticketList.numVisits(12111), 1, 0);
		assertEquals(ticketList.numVisits(18274), 1, 0);
		assertEquals(ticketList.numVisits(23234), 1, 0);
	
		//Student test MoviePass members' number of visits
		assertEquals(ticketList.numVisits(55555), 2, 0);
		assertEquals(ticketList.numVisits(33333), 1, 0);
	}

	/**
	 * Student Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		assertEquals(ticketList.numThisMovie(12111, "Deadpool"), 1, 0);
		assertEquals(ticketList.numThisMovie(18274, "Deadpool"), 0, 0);
		assertEquals(ticketList.numThisMovie(23234, "Book Club"), 1, 0);

		assertEquals(ticketList.numThisMovie(55555, "Deadpool"), 2, 0);
		assertEquals(ticketList.numThisMovie(33333, "Star War"), 1, 0);

	}

}
