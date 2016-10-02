package at.woodstick.fiddle.datetime;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Various tests concerning {@link Month} enum.
 */
public class MonthTest {
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
	
	}
	
	@Test
	public void testMonthDisplayNames() {
		Locale locale = Locale.GERMAN;
		
		Assert.assertEquals("Januar", getFullDisplayName(Month.JANUARY, locale));
		Assert.assertEquals("Februar", getFullDisplayName(Month.FEBRUARY, locale));
		Assert.assertEquals("März", getFullDisplayName(Month.MARCH, locale));
		Assert.assertEquals("April", getFullDisplayName(Month.APRIL, locale));
		Assert.assertEquals("Mai", getFullDisplayName(Month.MAY, locale));
		Assert.assertEquals("Juni", getFullDisplayName(Month.JUNE, locale));
		Assert.assertEquals("Juli", getFullDisplayName(Month.JULY, locale));
		Assert.assertEquals("August", getFullDisplayName(Month.AUGUST, locale));
		Assert.assertEquals("September", getFullDisplayName(Month.SEPTEMBER, locale));
		Assert.assertEquals("Oktober", getFullDisplayName(Month.OCTOBER, locale));
		Assert.assertEquals("November", getFullDisplayName(Month.NOVEMBER, locale));
		Assert.assertEquals("Dezember", getFullDisplayName(Month.DECEMBER, locale));
		
		Assert.assertEquals("Jan", getShortDisplayName(Month.JANUARY, locale));
		Assert.assertEquals("Feb", getShortDisplayName(Month.FEBRUARY, locale));
		Assert.assertEquals("Mär", getShortDisplayName(Month.MARCH, locale));
		Assert.assertEquals("Apr", getShortDisplayName(Month.APRIL, locale));
		Assert.assertEquals("Mai", getShortDisplayName(Month.MAY, locale));
		Assert.assertEquals("Jun", getShortDisplayName(Month.JUNE, locale));
		Assert.assertEquals("Jul", getShortDisplayName(Month.JULY, locale));
		Assert.assertEquals("Aug", getShortDisplayName(Month.AUGUST, locale));
		Assert.assertEquals("Sep", getShortDisplayName(Month.SEPTEMBER, locale));
		Assert.assertEquals("Okt", getShortDisplayName(Month.OCTOBER, locale));
		Assert.assertEquals("Nov", getShortDisplayName(Month.NOVEMBER, locale));
		Assert.assertEquals("Dez", getShortDisplayName(Month.DECEMBER, locale));
	}

	/**
	 * @param month
	 * @param locale
	 * @return display name for <i>month</i> using the given locale and {@link TextStyle#FULL}
	 * @see Month#getDisplayName(TextStyle, Locale)
	 */
	private String getFullDisplayName(Month month, Locale locale) {
		return month.getDisplayName(TextStyle.FULL, locale);
	}
	
	/**
	 * @param month
	 * @param locale
	 * @return display name for <i>month</i> using the given locale and {@link TextStyle#SHORT}
	 * @see Month#getDisplayName(TextStyle, Locale)
	 */
	private String getShortDisplayName(Month month, Locale locale) {
		return month.getDisplayName(TextStyle.SHORT, locale);
	}
}
