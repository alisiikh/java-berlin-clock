package com.ubs.opsit.interviews;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static org.junit.runners.Parameterized.*;

/**
 * @author lial.
 */
@RunWith(Parameterized.class)
public class BerlinClockCorrectInitializationTests extends BerlinClockTest {

	public BerlinClockCorrectInitializationTests(boolean secondBlink, int hoursTopBlinks, int hoursBottomBlinks,
			int minutesTopBlinks, int minutesBottomBlinks) {
		super(secondBlink, hoursTopBlinks, hoursBottomBlinks, minutesTopBlinks, minutesBottomBlinks);
	}

	@Parameters
	public static Collection<Object[]> correctInputData() {
		return Arrays.asList(new Object[][] {
				{false, 3, 3, 10, 3},
				{false, 1, 1, 1, 1},
				{false, 4, 2, 7, 4},
				{true, 3, 3, 11, 3},
				{true, 3, 4, 11, 4}
		});
	}

	@Test
	public void testBerlinClockInstantiatesCorrectly() {
		BerlinClock berlinClock = new BerlinClock(secondBlink, hoursTopBlinks, hoursBottomBlinks, minutesTopBlinks,
				minutesBottomBlinks);

		assertEquals(berlinClock.getSecondBlink(), secondBlink);
		assertEquals(berlinClock.getHoursTopBlinks(), hoursTopBlinks);
		assertEquals(berlinClock.getHoursBottomBlinks(), hoursBottomBlinks);
		assertEquals(berlinClock.getMinutesTopBlinks(), minutesTopBlinks);
		assertEquals(berlinClock.getMinutesBottomBlinks(), minutesBottomBlinks);
	}
}
