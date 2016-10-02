package at.woodstick.fiddle.datetime;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Various tests concerning {@link DayOfWeek} enum.
 */
public class DayOfWeekTest {
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
	
	}
	
	@Test
	public void testDayOfWeekDisplayNames() {
		Locale locale = Locale.GERMAN;
		
		Assert.assertEquals("Montag", getFullDisplayName(DayOfWeek.MONDAY, locale));
		Assert.assertEquals("Dienstag", getFullDisplayName(DayOfWeek.TUESDAY, locale));
		Assert.assertEquals("Mittwoch", getFullDisplayName(DayOfWeek.WEDNESDAY, locale));
		Assert.assertEquals("Donnerstag", getFullDisplayName(DayOfWeek.THURSDAY, locale));
		Assert.assertEquals("Freitag", getFullDisplayName(DayOfWeek.FRIDAY, locale));
		Assert.assertEquals("Samstag", getFullDisplayName(DayOfWeek.SATURDAY, locale));
		Assert.assertEquals("Sonntag", getFullDisplayName(DayOfWeek.SUNDAY, locale));
		
		Assert.assertEquals("Mo", getShortDisplayName(DayOfWeek.MONDAY, locale));
		Assert.assertEquals("Di", getShortDisplayName(DayOfWeek.TUESDAY, locale));
		Assert.assertEquals("Mi", getShortDisplayName(DayOfWeek.WEDNESDAY, locale));
		Assert.assertEquals("Do", getShortDisplayName(DayOfWeek.THURSDAY, locale));
		Assert.assertEquals("Fr", getShortDisplayName(DayOfWeek.FRIDAY, locale));
		Assert.assertEquals("Sa", getShortDisplayName(DayOfWeek.SATURDAY, locale));
		Assert.assertEquals("So", getShortDisplayName(DayOfWeek.SUNDAY, locale));
	}

	/**
	 * @param dayOfWeek
	 * @param locale
	 * @return display name for <i>dayOfWeek</i> using the given locale and {@link TextStyle#FULL}
	 * @see DayOfWeek#getDisplayName(TextStyle, Locale)
	 */
	private String getFullDisplayName(DayOfWeek dayOfWeek, Locale locale) {
		return dayOfWeek.getDisplayName(TextStyle.FULL, locale);
	}
	
	/**
	 * @param dayOfWeek
	 * @param locale
	 * @return display name for <i>dayOfWeek</i> using the given locale and {@link TextStyle#SHORT}
	 * @see DayOfWeek#getDisplayName(TextStyle, Locale)
	 */
	private String getShortDisplayName(DayOfWeek dayOfWeek, Locale locale) {
		return dayOfWeek.getDisplayName(TextStyle.SHORT, locale);
	}
}
