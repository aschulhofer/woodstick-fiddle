package at.woodstick.fiddle.datetime;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Various tests concerning <i>dates</i> without respect to <i>time</i> or <i>time zones</i>.
 * @see LocalDate
 * @see YearMonth
 * @see MonthDay
 * @see Year
 * @see TemporalAdjusters
 */
public class DateTest {
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
	
	}
	
	@Test
	public void testLocalDate() {
		LocalDate date = LocalDate.of(2011, Month.NOVEMBER, 11);
		
		assertEquals(11, date.getDayOfMonth());
		assertEquals(Month.NOVEMBER, date.getMonth());
		assertEquals(Month.NOVEMBER.getValue(), date.getMonthValue());
		assertEquals("Freitag", date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMAN));
		
		assertEquals(1, date.with(TemporalAdjusters.firstDayOfMonth()).getDayOfMonth());
	}
	
	@Test
	public void testYear() {
		Year twok11 = Year.of(2011);
		Year twok12 = Year.of(2012);
		
		Assert.assertFalse("2011 should be no leap year", twok11.isLeap());
		Assert.assertTrue("2012 should be a leap year",   twok12.isLeap());
	}
}
