package com.ubs.opsit.interviews;

import org.apache.commons.lang.Validate;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author lial.
 */
public final class BerlinClockTimeConverter implements TimeConverter {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	private final BerlinClockFormatter clockFormatter = new BerlinClockFormatter();

	@Override
	public String convertTime(String aTime) {
		Validate.notEmpty(aTime, "Provided time string is incorrect");

		LocalTime localTime = LocalTime.parse(aTime, formatter);

		int seconds = localTime.getSecond();
		int hours = parseHours(aTime);
		int minutes = localTime.getMinute();

		boolean secondBlink = seconds % 2 == 0;
		int hoursTopBlinks = hours / 5;
		int hoursBottomBlinks = hours % 5;
		int minutesTopBlinks = minutes / 5;
		int minutesBottomBlinks = minutes % 5;

		BerlinClock berlinClock = new BerlinClock(secondBlink, hoursTopBlinks, hoursBottomBlinks,
				minutesTopBlinks, minutesBottomBlinks);

		return clockFormatter.format(berlinClock);
	}

	private int parseHours(String aTime) {
		TemporalAccessor accessor = formatter.parse(aTime);
		Period period = accessor.query(DateTimeFormatter.parsedExcessDays());

		if (period.equals(Period.ofDays(1))) {
			return 24;
		} else {
			return accessor.query(LocalTime::from).getHour();
		}
	}
}
