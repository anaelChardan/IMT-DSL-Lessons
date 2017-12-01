package calendar;

public class Event {

	private String name;
	private String location;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;

	public Event(){
		this(null,null,null,null,null);
	}

	public Event(String name, String location, LocalDate date,
			LocalTime startTime, LocalTime endTime) {
		super();
		this.name = name;
		this.location = location;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(int year, int month, int day) {
		this.date = new LocalDate(year, month, day);
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = LocalTime.parse(startTime);
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = LocalTime.parse(endTime);
		;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String place) {
		this.location = place;
	}
	
	public String toString(){
		return "  event " + name + " {\n" +
				"    on " + date + "\n" +
				"    from " + startTime + "\n" +
				"    to " + endTime + "\n" +
				"    at " + location + "\n" +
				"  }";
	}

}
