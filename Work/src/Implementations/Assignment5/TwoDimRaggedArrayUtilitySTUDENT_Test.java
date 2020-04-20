package Implementations.Assignment5;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {
			{1.0,2.0,3.0,4.0,5.0},
			{2.0,11.0},
			{5.0,9.0,21.0},
			{3.0, 3.0}
	};

	private File inputFile, outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(69, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT), 0);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(5.75, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT), 0);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 3), 0);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(25, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 1), 0);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(21, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT), 0);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() {
		double[][] array=null;
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertTrue(Arrays.deepEquals(dataSetSTUDENT, array));
	}

}
