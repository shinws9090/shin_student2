package shin_student2.dto;

public class Militarys {
	private String miltno;
	private String military;
	
	
	public Militarys(String miltno) {
		super();
		this.miltno = miltno;
	}
	public Militarys(String miltno, String military) {
		super();
		this.miltno = miltno;
		this.military = military;
	}
	public Militarys() {
		// TODO Auto-generated constructor stub
	}
	public String getMiltno() {
		return miltno;
	}
	public void setMiltno(String miltno) {
		this.miltno = miltno;
	}
	public String getMilitary() {
		return military;
	}
	public void setMilitary(String military) {
		this.military = military;
	}
	@Override
	public String toString() {
		if(military ==null) military="";
		return String.format("%s", military);
	}
//	@Override
//	public String toString() {
//		return String.format("Militarys [miltno=%s, military=%s]", miltno, military);
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((miltno == null) ? 0 : miltno.hashCode());
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
		Militarys other = (Militarys) obj;
		if (miltno == null) {
			if (other.miltno != null)
				return false;
		} else if (!miltno.equals(other.miltno))
			return false;
		return true;
	}

	
}
