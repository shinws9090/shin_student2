package shin_student2.dto;

import java.sql.Date;
import java.util.List;

public class Student {
	private int no;
	private String name;
	private Date birthday;
	private int social;
	private Days dayno;
	private Department deptno;
	private int grade;
	private Attendings atdno;
	private Militarys miltno;
	private List<Score> scores;

	private Rank rank;
	private String pic;

	public Student() {
		super();
	}

	public Student(int no, String name, Date birthday, int social, Days dayno, Department deptno, int grade,
			Attendings atdno, Militarys miltno, String pic) {
		super();
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.social = social;
		this.dayno = dayno;
		this.deptno = deptno;
		this.grade = grade;
		this.atdno = atdno;
		this.miltno = miltno;
		this.pic = pic;
	}

	public Student(String name, Department deptno, int grade, Rank rank) {
		super();
		this.name = name;
		this.deptno = deptno;
		this.grade = grade;
		this.rank = rank;
	}

	public Student(int social, Days dayno, Department deptno, int grade, Attendings atdno, Militarys miltno) {
		super();
		this.social = social;
		this.dayno = dayno;
		this.deptno = deptno;
		this.grade = grade;
		this.atdno = atdno;
		this.miltno = miltno;
	}

	public Student(int no, String name, Date birthday, int social, Days dayno, Department deptno, int grade,
			Attendings atdno, Militarys miltno, List<Score> scores, Rank rank, double ranksco, String pic) {
		super();
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.social = social;
		this.dayno = dayno;
		this.deptno = deptno;
		this.grade = grade;
		this.atdno = atdno;
		this.miltno = miltno;
		this.scores = scores;
		this.rank = rank;
		this.pic = pic;
	}

	public Student(int no) {
		super();
		this.no = no;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getTotal() {
		int total = 0;
			for(Score s :scores) {
				total +=s.getScoer();
			}
		return total<0?-1:total;
	}

	

	public double getAvg() {
		int idx = 0;
		for(int i = 0; i<scores.size();i++) {
			if(scores.get(i).getScoer()==-1) {
				idx +=1;
			}
			if(idx==scores.size()) {
				idx--;
			}
		}
		double avg = getTotal()/(scores.size()-idx);
		if(avg<0) avg=0;
		
		return avg;
	}

	

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public Days getDayno() {
		return dayno;
	}

	public void setDayno(Days dayno) {
		this.dayno = dayno;
	}

	public Department getDeptno() {
		return deptno;
	}

	public void setDeptno(Department deptno) {
		this.deptno = deptno;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Attendings getAtdno() {
		return atdno;
	}

	public void setAtdno(Attendings atdno) {
		this.atdno = atdno;
	}

	public Militarys getMiltno() {
		return miltno;
	}

	public void setMiltno(Militarys miltno) {
		this.miltno = miltno;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [no=%s, name=%s, birthday=%s, social=%s, dayno=%s, deptno=%s, grade=%s, atdno=%s, miltno=%s, scores=%s, pic = %s]%n",
				no, name, birthday, social, dayno, deptno, grade, atdno, miltno, scores, pic);
	}
//	@Override
//	public String toString() {
//		return String.format(
//				"%s%n",
//				scores);
//	}
//	@Override
//	public String toString() {
//		return String.format("%s", no);
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
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
		Student other = (Student) obj;
		if (no != other.no)
			return false;
		return true;
	}
	

}
