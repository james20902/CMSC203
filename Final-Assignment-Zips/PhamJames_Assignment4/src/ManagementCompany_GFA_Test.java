package Implementations.Assignment4;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompany_GFA_Test {
	Property p1;
	ManagementCompany m ; 
	
	@Before
	public void setUp() throws Exception {
		m= new ManagementCompany("Railey", "555555555",6);
	}

	@After
	public void tearDown() throws Exception {
		m=null;
	}

	@Test
	public void testAddProperty() {
		p1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);
		 
		assertEquals(m.addProperty(p1),0,0);
	}




}
