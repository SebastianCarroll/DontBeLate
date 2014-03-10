package main;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;;

/**
 * Imports the free text input into {@link MileStone}/{@link MileStones} objects
 * @author sjc
 */
public class Formatter {
	public static ArrayList<MileStone> textToMileStones(String freeInput) {
		ArrayList<MileStone> mss = new ArrayList<MileStone>();
		String[] lines = freeInput.split(System.getProperty("line.separator"));
		for (String line : lines) {
			MileStone ms = parseLine(line);
			mss.add(ms);
		}
		return mss;
	}
	
	public static String mileStonesToText(ArrayList<MileStone> milestones){
		String milestonesAsText = "";
		for(MileStone m : milestones){
			milestonesAsText += m.toString() + "\n";
		}
		return milestonesAsText;
	}

	/**
	 * Parses a text line and creates a MileStone object from that
	 * @param line The input line in the format: [Duration] [description]
	 * @return A MileStone parsed from line
	 */
	public static MileStone parseLine(String line){
		Integer duration = 0;
		String description = "";
		String[] words = line.split("\\s+");
		MileStone milestone = null;
		try{
			duration = Integer.parseInt(words[0]);
			String[] descWords =  Arrays.copyOfRange(words, 1, words.length);
			description = StringUtils.join(descWords, " ");
			milestone = new MileStone(description, duration);
		} catch(NumberFormatException e){
			return null;
		}
		return milestone;
	}
	
}
