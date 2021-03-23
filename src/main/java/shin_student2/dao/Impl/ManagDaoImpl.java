package shin_student2.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shin_student2.dao.ManagDao;
import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.util.JdbcUtil;

public class ManagDaoImpl implements ManagDao {
	
	private static final ManagDaoImpl instance = new ManagDaoImpl();

	private ManagDaoImpl() {
	}

	public static ManagDaoImpl getInstance() {
		return instance;
	}
	

	@Override
	public int insertDept(Department department) {
		String sql = "insert into department values (?,?)";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, department.getDeptno());
			pstmt.setString(2, department.getDeptname());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateDept(Department department) {
		String sql = "UPDATE department\r\n" + 
				"	SET deptname=?\r\n" + 
				"	WHERE deptno=?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, department.getDeptname());
			pstmt.setInt(2, department.getDeptno());
			System.out.println(pstmt);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDept(Department department) {
		String sql = "DELETE FROM department WHERE deptno =?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, department.getDeptno());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertDays(Days days) {
		String sql = "insert into days values (?,?)";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, days.getDayno());
			pstmt.setString(2, days.getDay());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateDays(Days days) {
		String sql = "UPDATE days\r\n" + 
				"	SET dayTimename=?\r\n" + 
				"	WHERE dayTimeno=?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, days.getDay());
			pstmt.setInt(2, days.getDayno());
			System.out.println(pstmt);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDays(Days days) {
		String sql = "DELETE FROM days WHERE dayTimeno =?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, days.getDayno());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertAtd(Attendings attendings) {
		String sql = "insert into attendings values (?,?)";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, attendings.getAtdno());
			pstmt.setString(2, attendings.getAttending());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAtd(Attendings attendings) {
		String sql = "UPDATE attendings\r\n" + 
				"	SET atdname=?\r\n" + 
				"	WHERE atdno=?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, attendings.getAttending());
			pstmt.setString(2, attendings.getAtdno());
			System.out.println(pstmt);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAtd(Attendings attendings) {
		String sql = "DELETE FROM attendings WHERE atdno =?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, attendings.getAtdno());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertMilitays(Militarys militarys) {
		String sql = "insert into militarys values (?,?)";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, militarys.getMiltno());
			pstmt.setString(2, militarys.getMilitary());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMilitays(Militarys militarys) {
		String sql = "UPDATE militarys\r\n" + 
				"	SET miltname=?\r\n" + 
				"	WHERE miltno=?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, militarys.getMilitary());
			pstmt.setString(2, militarys.getMiltno());
			System.out.println(pstmt);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMilitays(Militarys militarys) {
		String sql = "DELETE FROM militarys WHERE miltno =?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, militarys.getMiltno());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
