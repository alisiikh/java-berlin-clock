package com.ubs.opsit.interviews;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


/**
 * @author lial.
 */
@RunWith(Parameterized.class)
public class BerlinClockIncorrectInitializationTests extends BerlinClockTest {

	public BerlinClockIncorrectInitializationTests(boolean secondRow, int hoursTopRow, int hoursBottomRow,
			int secondsTopRow, int secondsBottomRow) {
		super(secondRow, hoursTopRow, hoursBottomRow, secondsTopRow, secondsBottomRow);
	}

	@Parameters
	public static Collection<Object[]> wrongInputData() {
		return Arrays.asList(new Object[][] {
				{false, 15, 5, 5, 5},
				{false, -1, 1, 1, 1},
				{false, 1, -1, 1, 1},
				{true, 1, 1, -1, 1},
				{true, 1, 1, 1, -1}
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBerlinClockInitializationFails() {
		new BerlinClock(secondBlink, hoursTopBlinks, hoursBottomBlinks, minutesTopBlinks, minutesBottomBlinks);
	}
}
