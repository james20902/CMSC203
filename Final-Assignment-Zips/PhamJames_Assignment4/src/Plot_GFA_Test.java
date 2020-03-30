package Implementations.Assignment4;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Plot_GFA_Test {
	private Plot plot1, plot2;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(1,1,2,2); 
		plot2 = new Plot(2,1,2,2);
	}

	@After
	public void tearDown() throws Exception {
		plot1=plot2=null;
	}

	@Test
	public void testOverlaps1() {
		assertTrue(plot1.overlaps(plot2)); //plot2 overlaps the right side of plot1
	}
}
