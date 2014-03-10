package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FormatterTest {

	@Test
	public void testParseMileStones() {
		StringBuilder inputSample = new StringBuilder();
		inputSample.append("5 Wait\n");
		inputSample.append("10 Find Park\n");
		inputSample.append("15 Drive\n");
		inputSample.append("5 Clean Teeth\n");
		
		ArrayList<MileStone> expected = new ArrayList<MileStone>();
		
		MileStone[] eachMileStone = {
				new MileStone("Wait", 5),
				new MileStone("Find Park", 10),
				new MileStone("Drive", 15),
				new MileStone("Clean Teeth", 5)				
		};
		
		for(MileStone m : eachMileStone){
			expected.add(m);
		}
		
		ArrayList<MileStone> actual = 
				Formatter.parseMileStones(inputSample.toString());
		for(int i=0; i<actual.size(); i++){
			MileStone currentActual = actual.get(i);
			MileStone currentExpected =expected.get(i);
			assertEquals(currentExpected.getDuration(), currentActual.getDuration());
			assertEquals(currentExpected.getDescription(), currentActual.getDescription());
		}
	}
}
