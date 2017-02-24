package com.ubs.opsit.interviews;

import org.apache.commons.lang.Validate;

/**
 * @author lial.
 */
public final class BerlinClock {

	private boolean secondBlink;
	private int hoursTopBlinks;
	private int hoursBottomBlinks;
	private int minutesTopBlinks;
	private int minutesBottomBlinks;

	public BerlinClock(boolean secondBlink, int hoursTopBlinks, int hoursBottomBlinks, int minutesTopBlinks,
			int minutesBottomBlinks) {
		Validate.isTrue(hoursTopBlinks >= 0 && hoursTopBlinks <= 4, "Incorrect hours top row blinks provided!");
		Validate.isTrue(hoursBottomBlinks >= 0 && hoursTopBlinks <= 4, "Incorrect hours bottom row blinks provided!");
		Validate.isTrue(minutesTopBlinks >= 0 && minutesTopBlinks <= 11, "Incorrect minutes top row blinks provided!");
		Validate.isTrue(minutesBottomBlinks >= 0 && minutesBottomBlinks <= 4, "Incorrect minutes bottom row blinks provided!");

		this.secondBlink = secondBlink;
		this.hoursTopBlinks = hoursTopBlinks;
		this.hoursBottomBlinks = hoursBottomBlinks;
		this.minutesTopBlinks = minutesTopBlinks;
		this.minutesBottomBlinks = minutesBottomBlinks;
	}

	public boolean getSecondBlink() {
		return secondBlink;
	}

	public int getHoursTopBlinks() {
		return hoursTopBlinks;
	}

	public int getHoursBottomBlinks() {
		return hoursBottomBlinks;
	}

	public int getMinutesTopBlinks() {
		return minutesTopBlinks;
	}

	public int getMinutesBottomBlinks() {
		return minutesBottomBlinks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BerlinClock that = (BerlinClock) o;

		if (secondBlink != that.secondBlink)
			return false;
		if (hoursTopBlinks != that.hoursTopBlinks)
			return false;
		if (hoursBottomBlinks != that.hoursBottomBlinks)
			return false;
		if (minutesTopBlinks != that.minutesTopBlinks)
			return false;
		return minutesBottomBlinks == that.minutesBottomBlinks;
	}

	@Override
	public int hashCode() {
		int result = (secondBlink ? 1 : 0);
		result = 31 * result + hoursTopBlinks;
		result = 31 * result + hoursBottomBlinks;
		result = 31 * result + minutesTopBlinks;
		result = 31 * result + minutesBottomBlinks;
		return result;
	}
}
