package com.ubs.opsit.interviews;

import java.util.Arrays;

/**
 * @author lial.
 */
public final class BerlinClockFormatter {

	private static final char OFF_FORMAT = 'O';
	private static final String SECOND_BLINK_FORMAT = "Y";
	private static final String HOURS_BLINKS_FORMAT = "RRRR";
	private static final String MINUTES_TOP_BLINKS_FORMAT = "YYRYYRYYRYY";
	private static final String MINUTES_BOTTOM_BLINKS_FORMAT = "YYYY";

	public String format(BerlinClock clock) {
		StringBuilder sb = new StringBuilder();

		return sb.append(clock.getSecondBlink() ? SECOND_BLINK_FORMAT : OFF_FORMAT)
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getHoursTopBlinks(), HOURS_BLINKS_FORMAT))
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getHoursBottomBlinks(), HOURS_BLINKS_FORMAT))
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getMinutesTopBlinks(), MINUTES_TOP_BLINKS_FORMAT))
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getMinutesBottomBlinks(), MINUTES_BOTTOM_BLINKS_FORMAT))
				.toString();
	}

	private char[] formatBerlinClockRow(int blinks, String format) {
		char[] berlinClockRow = format.toCharArray();

		Arrays.fill(berlinClockRow, blinks, berlinClockRow.length, OFF_FORMAT);

		return berlinClockRow;
	}
}
