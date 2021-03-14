package shin_student2.dto;

public class Attendings {
	private String atdno;
	private String attending;
	
	
	public Attendings(String atdno) {
		super();
		this.atdno = atdno;
	}
	public Attendings(String atdno, String attending) {
		super();
		this.atdno = atdno;
		this.attending = attending;
	}
	public Attendings() {
		// TODO Auto-generated constructor stub
	}
	public String getAtdno() {
		return atdno;
	}
	public void setAtdno(String atdno) {
		this.atdno = atdno;
	}
	public String getAttending() {
		return attending;
	}
	public void setAttending(String attending) {
		this.attending = attending;
	}
	@Override
	public String toString() {
		if(attending ==null) attending="";
		return String.format("%s", attending);
	}
//	@Override
//	public String toString() {
//		return String.format("Attendings [atdno=%s, attending=%s]", atdno, attending);
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atdno == null) ? 0 : atdno.hashCode());
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
		Attendings other = (Attendings) obj;
		if (atdno == null) {
			if (other.atdno != null)
				return false;
		} else if (!atdno.equals(other.atdno))
			return false;
		return true;
	}

	
}
