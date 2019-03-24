package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPrintPrimes {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	PrintPrimes pp = new PrintPrimes();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void out() {
		String test = new String("Prime: 2\r\nPrime: 3\r\nPrime: 5\r\nPrime: 7\r\nPrime: 11\r\n");
		PrintPrimes.printPrimes(5);
		assertEquals(test, outContent.toString());
	}

}
