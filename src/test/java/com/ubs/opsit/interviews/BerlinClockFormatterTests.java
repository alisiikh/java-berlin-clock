package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lial.
 */
public class BerlinClockFormatterTests {

	private static final String LS = System.lineSeparator();

	private BerlinClockFormatter clockFormatter = new BerlinClockFormatter();

	@Test
	public void shouldFormatBerlinClock() {
		BerlinClock berlinClock = new BerlinClock(false, 4, 2, 6, 2);

		String formattedClock = clockFormatter.format(berlinClock);

		Assert.assertEquals(formattedClock, "O" + LS + "RRRR" + LS + "RROO" + LS + "YYRYYROOOOO" + LS + "YYOO");
	}
}
