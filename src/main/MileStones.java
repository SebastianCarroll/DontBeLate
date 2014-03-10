package main;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


//import javax.faces.bean.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("milestones")
@SessionScoped
public class MileStones implements Serializable {
	
	private Calendar end = new GregorianCalendar();
	private ArrayList<MileStone> milestones = 
			new ArrayList<MileStone>();
	
	private ArrayList<String> nameList = 
			new ArrayList<String>();
	
	/**
	 * Default constructor: Necessary as jsf requires it
	 */
	public MileStones(){
		this.setEnd(new GregorianCalendar());
	}

	public ArrayList<MileStone> getMilestones() {
		return milestones;
	}

	public void setMilestones(ArrayList<MileStone> milestones) {
		this.milestones = milestones;
	}

	public ArrayList<String> getNameList() {
		return nameList;
	}

	public void setNameList(ArrayList<String> nameList) {
		this.nameList = nameList;
	}

	public MileStones(Calendar end2) {
		this.setEnd(end2);
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}
	
	public void addMileStone(MileStone milestone){
		milestones.add(milestone);
	}
	
	public void addNewMilestone(){
		milestones.add(new MileStone("", 0));
	}

	public Calendar getStart() {
		int duration = sumDuration();
		Calendar start = new GregorianCalendar();
		start = (Calendar) end.clone();
		start.add(Calendar.MINUTE, -duration);
		return start;
	}
	
	@Override
	public String toString(){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		String output = df.format(end.getTime()) + " - End\n";
		Calendar current = (Calendar) end.clone();
		for(MileStone m : milestones){
			current.add(Calendar.MINUTE, -m.getDuration());
			output += df.format(current.getTime()) + 
					" - " + m.getDescription() + "\n";
		}
		return output;
	}

	private int sumDuration() {
		int duration = 0;
		for(MileStone m : milestones){
			duration += m.getDuration();
		}
		return duration;
	}
}
