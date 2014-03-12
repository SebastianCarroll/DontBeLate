package main;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class MileStoneTest {

	@Test
	public void testFields() {
		Integer duration = 10;
		String description = "Test milestone";
		MileStone ms = new MileStone(description, duration);
		
		assertEquals(duration, ms.getDuration());
		assertEquals(description, ms.getDescription());
	}
	
	@Test
	public void testToString(){
		Integer duration = 10;
		String description = "Test milestone";
		MileStone ms = new MileStone(description, duration);
		String msAsString = ms.toString();
		assertEquals("10 " + description, msAsString);
	}
	
	@Test
	public void test_convertFromDurationToTime(){
		Integer duration = 10;
		String description = "Test milestone";
		MileStone ms = new MileStone(description, duration);
		Calendar end = new GregorianCalendar(2014, 3, 12, 14, 00);
		Calendar expectedStart = new GregorianCalendar(2014, 3, 12, 13, 50);
		ms.setStartTime(end);
		assertEquals(ms.getStartTime().getTime(), expectedStart.getTime());
	}
}
