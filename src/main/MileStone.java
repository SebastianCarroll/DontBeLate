package main;
public class MileStone {
	private Integer duration;
	private String description;

	public MileStone(String description, 
			Integer duration) {
		this.duration = duration;
		this.description = description;
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
}
