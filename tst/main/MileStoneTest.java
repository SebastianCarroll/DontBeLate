package main;

import static org.junit.Assert.*;

import java.util.Date;

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
}
