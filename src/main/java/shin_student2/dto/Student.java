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
	private int total;
	private double avg;
	private String rank;
	private double ranksco;
	private String pic;
	
	
	public Student() {
		super();
	}
	
	public Student(int no, String name, Date birthday, int social, Days dayno, Department deptno, int grade,
			Attendings atdno, Militarys miltno , String pic) {
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

	public Student(String name, Department deptno, int grade, String rank) {
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
			Attendings atdno, Militarys miltno, List<Score> scores, int total, double avg, String rank,
			double ranksco, String pic) {
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
		this.total = total;
		this.avg = avg;
		this.rank = rank;
		this.ranksco = ranksco;
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public double getRanksco() {
		return ranksco;
	}

	public void setRanksco(double ranksco) {
		this.ranksco = ranksco;
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
				no, name, birthday, social, dayno, deptno, grade, atdno, miltno, scores,pic);
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

}
