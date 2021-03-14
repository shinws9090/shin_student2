package shin_student2.dto;

public class Days {
	private int dayno;
	private String day;
	
	
	public Days(int dayno) {
		super();
		this.dayno = dayno;
	}
	public Days(String day) {
		super();
		this.day = day;
	}
	public Days(int dayno, String day) {
		super();
		this.dayno = dayno;
		this.day = day;
	}
	public Days() {
	}
	public int getDayno() {
		return dayno;
	}
	public void setDayno(int dayno) {
		this.dayno = dayno;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		if(day ==null) day="";
		return String.format("%s", day);
	}
//	@Override
//	public String toString() {
//		return String.format("Days [dayno=%s, day=%s]", dayno, day);
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dayno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Days other = (Days) obj;
		if (dayno != other.dayno)
			return false;
		return true;
	}

}
