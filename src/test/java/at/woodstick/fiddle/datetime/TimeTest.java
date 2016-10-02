package at.woodstick.fiddle.datetime;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class TimeTest {
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
	
	}
	
	@Test
	public void testLocalTimeConstruction() {
		int hour = 11;
		int minute = 11;
		int second = 11;
		int nanoOfSecond = 11;
		
		LocalTime timeNoSeconds = LocalTime.of(hour, minute);
		LocalTime timeNoNano    = LocalTime.of(hour, minute, second);
		LocalTime timeWithNano  = LocalTime.of(hour, minute, second, nanoOfSecond);
		
		LocalTime timeFromString = LocalTime.parse(buildTimeString(hour, minute, second, nanoOfSecond));
		
		assertEquals(hour, timeNoSeconds.getHour());
		assertEquals(minute, timeNoSeconds.getMinute());
		assertEquals(0, timeNoSeconds.getSecond());
		assertEquals(0, timeNoSeconds.getNano());
		
		assertEquals(hour, timeNoNano.getHour());
		assertEquals(minute, timeNoNano.getMinute());
		assertEquals(second, timeNoNano.getSecond());
		assertEquals(0, timeNoNano.getNano());
		
		assertEquals(hour, timeWithNano.getHour());
		assertEquals(minute, timeWithNano.getMinute());
		assertEquals(second, timeWithNano.getSecond());
		assertEquals(nanoOfSecond, timeWithNano.getNano());
		
		assertEquals(hour, timeFromString.getHour());
		assertEquals(minute, timeFromString.getMinute());
		assertEquals(second, timeFromString.getSecond());
		assertEquals(nanoOfSecond, timeFromString.getNano());
		
		assertEquals(LocalTime.MIDNIGHT, LocalTime.ofNanoOfDay(0));
		assertEquals(LocalTime.MIDNIGHT, LocalTime.ofSecondOfDay(0));
	}
	
	@Test
	public void testDuration() {
		int scheduleHours   = 12;
		int scheduleMinutes = 30;
		int scheduleSeconds =  5;
		
		int currentHours   = 16;
		int currentMinutes = 22;
		int currentSeconds = 23;
		
		int previousHours   = Math.abs(currentHours + scheduleHours) % 24;
		int previousMinutes = Math.abs(currentMinutes + scheduleMinutes) % 60;
		int previousSeconds = Math.abs(currentSeconds + scheduleSeconds) % 60;
		
		LocalDateTime currentExecution = LocalDateTime.of(2016, Month.OCTOBER, 2, currentHours, currentMinutes, currentSeconds);
		LocalDateTime nextExecution = currentExecution.plusHours(scheduleHours)
														.plusMinutes(scheduleMinutes)
														.plusSeconds(scheduleSeconds);
		
		Duration schedulePeriod = Duration.between(nextExecution, currentExecution);
		
		LocalDateTime previousExection = currentExecution.minus(schedulePeriod);
		
		assertEquals(previousHours, previousExection.getHour());
		assertEquals(previousMinutes, previousExection.getMinute());
		assertEquals(previousSeconds, previousExection.getSecond());
	}
	
	@Test
	public void testDurationDay() {
		int scheduleDays   	= 1;
		int scheduleHours   = 0;
		int scheduleMinutes = 0;
		int scheduleSeconds = 0;
		
		int currentDay 	   =  2;
		int currentHours   = 16;
		int currentMinutes = 22;
		int currentSeconds = 23;
		
		int previousDays    = Math.abs(currentDay - scheduleDays);
		int previousHours   = Math.abs(currentHours + scheduleHours) % 24;
		int previousMinutes = Math.abs(currentMinutes + scheduleMinutes) % 60;
		int previousSeconds = Math.abs(currentSeconds + scheduleSeconds) % 60;
		
		LocalDateTime currentExecution = LocalDateTime.of(2016, Month.OCTOBER, currentDay, currentHours, currentMinutes, currentSeconds);
		LocalDateTime nextExecution = currentExecution.plusDays(scheduleDays)
													  .plusHours(scheduleHours)
													  .plusMinutes(scheduleMinutes)
													  .plusSeconds(scheduleSeconds);
		
		Duration schedulePeriod = Duration.between(currentExecution, nextExecution);
		
		LocalDateTime previousExection = currentExecution.minus(schedulePeriod);
		
		assertEquals(previousDays,    previousExection.getDayOfMonth());
		assertEquals(previousHours,   previousExection.getHour());
		assertEquals(previousMinutes, previousExection.getMinute());
		assertEquals(previousSeconds, previousExection.getSecond());
	}
	
	/**
	 * Builds local time string of format <b><i>hour</i>:<i>minute</i>:<i>second</i>.<i>nanoOfSecond</i></b>.
	 * @param hour
	 * @param minute
	 * @param second
	 * @param nanoOfSecond
	 * @return local time string
	 * @see DateTimeFormatter#ISO_LOCAL_TIME
	 */
	private String buildTimeString(int hour, int minute, int second, int nanoOfSecond) {
		return hour + ":" + minute + ":" + second + "." + String.format("%09d", nanoOfSecond);
	}
}
