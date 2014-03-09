package main;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.ws.util.StringUtils;

public class Formatter {
	public static ArrayList<MileStone> parseMileStones(String freeInput) {
		ArrayList<MileStone> mss = new ArrayList<MileStone>();
		String[] lines = freeInput.split(System.getProperty("line.separator"));
		for (String line : lines) {

			MileStone ms = new MileStone(line);
			mss.add();
		}
	}

	public static MileStone parseLine(String line){
		Integer duration = 0;
		String description = "";
		String[] words = line.split("\\s+");
		try{
			duration = Integer.parseInt(words[0]);
			String[] desc =  Arrays.copyOfRange(words, 1, words.length);
			description = StringUtils.join(desc, " ");
		}
	}
	
}
