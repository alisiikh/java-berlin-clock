package com.ubs.opsit.interviews;

import java.util.Arrays;

/**
 * @author lial.
 */
public final class BerlinClockFormatter {

	private static final char OFF = 'O';
	private static final String SECOND_ROW_FORMAT = "Y";
	private static final String HOURS_ROW_FORMAT = "RRRR";
	private static final String MINUTES_TOP_ROW_FORMAT = "YYRYYRYYRYY";
	private static final String MINUTES_BOTTOM_ROW_FORMAT = "YYYY";

	public String format(BerlinClock clock) {
		StringBuilder sb = new StringBuilder();

		return sb.append(clock.getSecondBlink() ? SECOND_ROW_FORMAT : OFF)
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getHoursTopBlinks(), HOURS_ROW_FORMAT))
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getHoursBottomBlinks(), HOURS_ROW_FORMAT))
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getMinutesTopBlinks(), MINUTES_TOP_ROW_FORMAT))
				.append(System.lineSeparator())
				.append(formatBerlinClockRow(clock.getMinutesBottomBlinks(), MINUTES_BOTTOM_ROW_FORMAT))
				.toString();
	}

	private char[] formatBerlinClockRow(int blinks, String format) {
		char[] berlinClockRow = format.toCharArray();

		Arrays.fill(berlinClockRow, blinks, berlinClockRow.length, OFF);

		return berlinClockRow;
	}
}
