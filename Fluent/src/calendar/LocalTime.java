package calendar;

class LocalTime {

	private int hour;
	private int minute;

	public LocalTime(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public static LocalTime parse(String time) {
		return new LocalTime(Integer.parseInt(time.substring(0, 2)),
				Integer.parseInt(time.substring(3, 5)));
	}
	
	public String toString(){
		return hour+":"+minute;
	}

}