package Implementations.Assignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {

	ManagementCompany company;

	@Before
	public void setUp() throws Exception {
		//student create a management company
		company = new ManagementCompany("JamesCo", "12345", 5, 0, 0, 100, 100);
		//student add three properties, with plots, to mgmt co
		company.addProperty("Belmar", "Silver Spring", 1200, "John Smith", 3, 3, 3, 3);
		company.addProperty("Camden", "Rockville", 2450,"Ann Taylor", 5, 9, 4, 4);
		company.addProperty("Hamptons", "Rockville", -1250, "Rick Steves", 10, 16, 3, 5);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null
		company = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		company.addProperty("Jamestown", "thecity", 2400, "James");
		//student should add property with 8 args
		company.addProperty("ATown", "AnotherCity", 3012, "Man", 19, 23, 3, 5);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(company.addProperty("This", "property", 4054, "shouldnt add", 50, 50, 1, 1), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(company.maxRentProp(), 2450, 0);
	}

	@Test
	public void testTotalRent() {
		assertEquals(company.totalRent(), 4900, 0);
	}

 }
