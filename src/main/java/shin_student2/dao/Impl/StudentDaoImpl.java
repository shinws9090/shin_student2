package shin_student2.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shin_student2.dao.StudentDao;
import shin_student2.dto.Student;
import shin_student2.ui.exception.SqlConstraintException;
import shin_student2.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {
	private static final StudentDaoImpl instance = new StudentDaoImpl();

	private StudentDaoImpl() {
	}

	public static StudentDaoImpl getInstance() {
		return instance;
	}


	@Override
	public void studentUpdate(Student student) {
		System.out.println(student);
		String sql = "update students \r\n" + 
				"	set name = ?, dirth = ?, social = ?, dayTime = ?, dept = ?, grade = ?, atd = ?, milt = ?, pic = ? \r\n" + 
				"	where stdno = ?;";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(10, student.getNo());
			pstmt.setString(1, student.getName());
			pstmt.setDate(2, student.getBirthday());
			pstmt.setInt(3, student.getSocial());
			pstmt.setInt(4, student.getDayno().getDayno());
			pstmt.setInt(5, student.getDeptno().getDeptno());
			pstmt.setInt(6, student.getGrade());
			pstmt.setString(7, student.getAtdno().getAtdno());
			pstmt.setString(8, student.getMiltno().getMiltno());
			pstmt.setString(9, student.getPic());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// 추가 및 삭제 시 성적 테이블의 정보도 같이 동작
	public String insertStudentAndScore(Student s) {
		// stdno, name, dirth, social, dayTime, dept, grade, atd, milt

		String stdSql = "insert into students values (?,?,?,?,?,?,?,?,?,?)";
		String scoSql = "insert into scores values(?,?,-1)";
		String res = "";
		Connection con = null;
		PreparedStatement stdPstmt = null;
		PreparedStatement scoPstmt = null;
		try {
			System.out.println(s);
			con = JdbcUtil.getConnection();
			stdPstmt = con.prepareStatement(stdSql);
			scoPstmt = con.prepareStatement(scoSql);

			con.setAutoCommit(false);
			stdPstmt.setInt(1, s.getNo());
			stdPstmt.setString(2, s.getName());
			stdPstmt.setDate(3, s.getBirthday());
			stdPstmt.setInt(4, s.getSocial());
			stdPstmt.setInt(5, s.getDayno().getDayno());
			stdPstmt.setInt(6, s.getDeptno().getDeptno());
			stdPstmt.setInt(7, s.getGrade());
			stdPstmt.setString(8, s.getAtdno().getAtdno());
			stdPstmt.setString(9, s.getMiltno().getMiltno());
			stdPstmt.setString(10, s.getPic());
			stdPstmt.executeUpdate();

			for (int i = 0; i < 4; i++) {
				scoPstmt.setInt(1, s.getNo());
				scoPstmt.setInt(2, i + 1);
				scoPstmt.executeUpdate();
			}
			con.commit();
			con.setAutoCommit(true);
			res = "commit";
		} catch (SQLException e) {
			res = "rollback";
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SqlConstraintException(e.getMessage(),e);

		} finally {
			closeUnit(con, stdPstmt, scoPstmt);

		}
		return res;
	}

	public String deleteStudentAndScore(Student student) {
		String scoSql = "delete from scores where stdno = ?";
		String stdSql = "delete from students where stdno = ?";
		String res = "";
		Connection con = null;
		PreparedStatement stdPstmt = null;
		PreparedStatement scoPstmt = null;
		try {
			System.out.println(student);
			con = JdbcUtil.getConnection();
			stdPstmt = con.prepareStatement(stdSql);
			scoPstmt = con.prepareStatement(scoSql);

			con.setAutoCommit(false);
			scoPstmt.setInt(1, student.getNo());
			scoPstmt.executeUpdate();
			
			stdPstmt.setInt(1, student.getNo());
			stdPstmt.executeUpdate();


			con.commit();
			con.setAutoCommit(true);
			res = "commit";
		} catch (SQLException e) {
			e.printStackTrace();
			res = "rollback";
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			closeUnit(con, stdPstmt, scoPstmt);

		}
		return res;

	}

	private void closeUnit(Connection con, PreparedStatement stdPstmt, PreparedStatement scoPstmt) {
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stdPstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			scoPstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
