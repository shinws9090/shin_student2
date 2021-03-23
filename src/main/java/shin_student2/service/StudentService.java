package shin_student2.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import shin_student2.dao.Impl.StudentDaoImpl;
import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Rank;
import shin_student2.dto.Score;
import shin_student2.dto.Student;
import shin_student2.dto.Subject;
import shin_student2.util.JdbcUtil;

public class StudentService {
	private StudentDaoImpl dao = StudentDaoImpl.getInstance();
	private static final StudentService instance = new StudentService();

	private StudentService() {
	}

	public static StudentService getInstance() {
		return instance;
	}

	public List<Student> selectByWhere(String s) {
		String sql = "select s.stdno, s.name, s.dirth, s.social, dayTimeno, dayTimename, deptno, deptname, grade, atdno, atdname, miltno, miltname,pic\r\n"
				+ "	from students s\r\n" 
				+ "	join days d on s.dayTime =d.dayTimeno \r\n"
				+ "	join department d2 on s.dept = d2.deptno \r\n" 
				+ "	join attendings a on s.atd = a.atdno \r\n"
				+ "	join militarys m on s.milt =m.miltno \r\n" + s;
		System.out.println(sql);
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Student> list = new ArrayList<Student>();
				do {
					list.add(getStudent(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		int no = rs.getInt("stdno");
		String name = rs.getString("name");
		Date birthday = rs.getDate("dirth");
		int social = rs.getInt("social");
		Days dayno = new Days(rs.getInt("dayTimeno"));
		Department deptno = new Department(rs.getInt("deptno"));
		int grade = rs.getInt("grade");
		Attendings atdno = new Attendings(rs.getString("atdno"));
		Militarys miltno = new Militarys(rs.getString("miltno"));

//		List<Score> scores = new ArrayList<Score>();
//		scores.add(new Score(new Subject(rs.getInt("subjno1"), rs.getString("subfname1")), rs.getInt("score1")));
//		scores.add(new Score(new Subject(rs.getInt("subjno2"), rs.getString("subfname2")), rs.getInt("score2")));
//		scores.add(new Score(new Subject(rs.getInt("subjno3"), rs.getString("subfname3")), rs.getInt("score3")));

		dayno.setDay(rs.getString("dayTimename"));
		deptno.setDeptname(rs.getString("deptname"));
		atdno.setAttending(rs.getString("atdname"));
		miltno.setMilitary(rs.getString("miltname"));
//		int total = rs.getInt("total");
//		double avg = rs.getDouble("avg");
//		String rank = rs.getString("rank");
//		double ranksco = rs.getDouble("ranksco");
		String pic = rs.getString("pic");

		return new Student(no, name, birthday, social, dayno, deptno, grade, atdno, miltno, pic);
	}

//	private List<String> getWhere(Student s) {
//		List<String> list = new ArrayList:;
//		list.add(s.getNo());
//	}

	public void modifyStudent(Student student) {
		dao.studentUpdate(student);
	}

	public String addStudent(Student student) {
		return dao.insertStudentAndScore(student);
	}

	public String removeStudent(Student student) {
		return dao.deleteStudentAndScore(student);
	}

	public Rank rankSelect(Student student) {
		String a = "select rank, ranksco  from ranking where ? between lowsco and hisco";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(a)) {
			pstmt.setDouble(1, student.getAvg());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Rank(rs.getString("rank"), rs.getInt("ranksco"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
