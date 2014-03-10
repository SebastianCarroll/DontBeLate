package main;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.omg.CORBA.IMP_LIMIT;

public class MileStonesTest {

	@Test
	public void testConstructor() {
		Calendar end = new GregorianCalendar();
		MileStones mss = new MileStones(end);
		assertEquals(end, mss.getEnd());
	}
	
	@Test
	public void testAddingManyMilestones() {
		Calendar end = new GregorianCalendar();
		MileStones mss = new MileStones(end);
		
		Integer[] ds= {10, 20, 60, 12};
		
		Integer sum = SumInts(ds);
		
		Calendar start = (Calendar) end.clone();
		
		start.add(Calendar.MINUTE, -sum);
		
		MileStone ms1 = new MileStone("Step1", ds[0]);
		MileStone ms2 = new MileStone("step2", ds[1]);
		MileStone ms3 = new MileStone("step3", ds[2]);
		MileStone ms4 = new MileStone("step4", ds[3]);
		mss.addMileStone(ms1);
		mss.addMileStone(ms2);
		mss.addMileStone(ms3);
		mss.addMileStone(ms4);
		assertEquals(start.compareTo(mss.getStart()), 0);
	}	
	
	private Integer SumInts(Integer[] ds) {
		Integer sum = 0;
		for(Integer i: ds){
			sum += i;
		}
		return sum;
	}

	@Test
	public void testAddingOneMilestone() {
		Calendar end = new GregorianCalendar();
		MileStones mss = new MileStones(end);
		
		Integer duration = 10;
		String description = "Test milestone";
		
		Calendar start = (Calendar) end.clone();
		
		start.add(Calendar.MINUTE, -duration);
		
		MileStone ms = new MileStone(description, duration);
		mss.addMileStone(ms);
		assertEquals(start, mss.getStart());
	}
	
	@Test
	public void testToString(){
		Calendar end = new GregorianCalendar(2014, 3, 12, 14, 00);
		MileStones mss = new MileStones(end);
		
		MileStone[] eachMileStone = {
				new MileStone("Wait time", 10),
				new MileStone("Find park", 5),
				new MileStone("Drive", 15),
				new MileStone("Clean Teeth", 5)				
		};
		
		for(MileStone m : eachMileStone){
			mss.addMileStone(m);
		}
		
		String actual = mss.toString();
		String expected = 
				"14:00 - End\n" +
				"13:50 - Wait time\n" +
				"13:45 - Find park\n" +
				"13:30 - Drive\n" +
				"13:25 - Clean Teeth\n";		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_formatting(){
		StringBuilder inputSample = new StringBuilder();
		inputSample.append("5 Wait\n");
		inputSample.append("10 Find Park\n");
		inputSample.append("15 Drive\n");
		inputSample.append("5 Clean Teeth\n");
		MileStones ms = new MileStones();
	}

}
