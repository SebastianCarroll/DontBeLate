package main;

import java.util.Calendar;

/**
 * Basic class the record the duration and description of each task
 * @author sjc
 */
public class MileStone {
	private Integer duration;
	private String description;
	private Calendar startTime;

	public MileStone(String description, 
			Integer duration) {
		this.duration = duration;
		this.description = description;
	}
	
	/**
	 * Parses the input string and then creates the parameters from this
	 * @param freeInput String in the same format as expected by {@link Formatter#parseLine(String)}
	 */
	public MileStone(String freeInput){
		MileStone m = Formatter.parseLine(freeInput);
		duration = m.duration;
		description = m.description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return duration.toString() + " " + description;
	}

	public  Calendar getStartTime(){
		return startTime;
	}
	public void setStartTime(Calendar end) {
		end.add(Calendar.MINUTE, -duration);
		startTime = end;
	}
}
