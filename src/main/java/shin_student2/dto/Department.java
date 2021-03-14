package shin_student2.dto;

public class Department {
	private int deptno;
	private String deptname;
	
	
	public Department(int deptno) {
		super();
		this.deptno = deptno;
	}
	public Department(int deptno, String deptname) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	@Override
	public String toString() {
		if(deptname ==null) deptname="";
		return String.format("%s", deptname);
	}
//	@Override
//	public String toString() {
//		return String.format("Department [deptno=%s, deptname=%s]", deptno, deptname);
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
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
		Department other = (Department) obj;
		if (deptno != other.deptno)
			return false;
		return true;
	}
	
}
