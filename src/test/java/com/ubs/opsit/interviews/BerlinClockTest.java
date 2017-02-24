package com.ubs.opsit.interviews;

/**
 * @author lial.
 */
public abstract class BerlinClockTest {

	boolean secondBlink;
	int hoursTopBlinks;
	int hoursBottomBlinks;
	int minutesTopBlinks;
	int minutesBottomBlinks;

	public BerlinClockTest(boolean secondBlink, int hoursTopBlinks, int hoursBottomBlinks, int minutesTopBlinks,
			int minutesBottomBlinks) {
		this.secondBlink = secondBlink;
		this.hoursTopBlinks = hoursTopBlinks;
		this.hoursBottomBlinks = hoursBottomBlinks;
		this.minutesTopBlinks = minutesTopBlinks;
		this.minutesBottomBlinks = minutesBottomBlinks;
	}
}
