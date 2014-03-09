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
	private ArrayList<MileStone> mileStones = 
			new ArrayList<MileStone>();
	
	public MileStones(){
		this.setEnd(new GregorianCalendar());
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
		mileStones.add(milestone);
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
		for(MileStone m : mileStones){
			current.add(Calendar.MINUTE, -m.getDuration());
			output += df.format(current.getTime()) + 
					" - " + m.getDescription() + "\n";
		}
		return output;
	}

	private int sumDuration() {
		int duration = 0;
		for(MileStone m : mileStones){
			duration += m.getDuration();
		}
		return duration;
	}
}
